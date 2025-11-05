package org.egmaza.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.egmaza.apiservlet.webapp.headers.models.Producto;
import org.egmaza.apiservlet.webapp.headers.services.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        String mensajeRequest = (String) req.getAttribute("mensaje");
        String mensajeApp = (String) getServletContext().getAttribute("mensaje");

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

            if(usernameOptional.isPresent()){
                out.println("<div style='color: blue;'>Hola " + usernameOptional.get() + " bienvenido</div>");
            }

            out.println("      <table>");
            out.println("         <tr>");
            out.println("         <th>ID</th>");
            out.println("         <th>Nombre</th>");
            out.println("         <th>Tipo</th>");
            if(usernameOptional.isPresent()){
                out.println("         <th>Precio</th>");
                out.println("         <th>agregar</th>");
            }
            out.println("         <tr>");
            productos.forEach(p -> {
                out.println("<td>" + p.getId() + "</td>\n");
                out.println("<td>" + p.getNombre() + "</td>\n");
                out.println("<td>" + p.getTipo() + "</td>\n");
                if(usernameOptional.isPresent()){
                    out.println("<td>" + p.getPrecio() + "</td>\n");
                    out.println("<td><a href=\""
                            + req.getContextPath()
                            + "/agregar-carro?id=" + p.getId()
                            + "\">agregar al carrito</a></td>\n");
                }
                out.println("</tr>");
            });
            out.println("      </table>");
            out.println("<p>" + mensajeApp + "</p>");
            out.println("<p>" + mensajeRequest + "</p>");
            out.println("   </body>");
            out.println("</html>");

        }
    }
}