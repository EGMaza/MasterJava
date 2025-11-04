package org.egmaza.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.egmaza.apiservlet.webapp.headers.models.Producto;
import org.egmaza.apiservlet.webapp.headers.services.LoginServiceImpl;
import org.egmaza.apiservlet.webapp.headers.services.ProductoService;
import org.egmaza.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];

        Optional<String> cookieOptional = new LoginServiceImpl().getUsername(req);

        Optional<String> cookieOptional2 = Arrays.stream(cookies)
                .filter(c -> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findFirst();

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("   <meta charset=\"UTF-8\">");
            out.println("   <title>Listado de productos</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("      <h1>Listado de Productos!</h1>");
            if(cookieOptional.isPresent()){
                out.println("<div style='color: blue;'>Hola " + cookieOptional.get() + " bienvenido</div>");
            }
            out.println("      <table>");
            out.println("         <tr>");
            out.println("         <th>ID</th>");
            out.println("         <th>Nombre</th>");
            out.println("         <th>Tipo</th>");
            if(cookieOptional.isPresent()){
                out.println("         <th>Precio</th>");
            }
            out.println("         <tr>");
            productos.forEach(p -> {
                out.println("<td>" + p.getId() + "</td>\n");
                out.println("<td>" + p.getNombre() + "</td>\n");
                out.println("<td>" + p.getTipo() + "</td>\n");
                if(cookieOptional.isPresent()){
                    out.println("<td>" + p.getPrecio() + "</td>\n");
                }
                out.println("</tr>");
            });
            out.println("      </table>");

            out.println("   </body>");
            out.println("</html>");

        }
    }
}