package org.egmaza.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.egmaza.apiservlet.webapp.headers.models.Producto;
import org.egmaza.apiservlet.webapp.headers.services.ProductoService;
import org.egmaza.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html"})
public class ProductoXlsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");

        if (esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment;filename=productos.xlsx");
        }


        try (PrintWriter out = resp.getWriter()) {
            if (!esXls) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("   <meta charset=\"UTF-8\">");
                out.println("   <title>Listado de productos</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("      <h1>Listado de Productos!</h1>");
                out.println("      <p><a href=\"" + req.getContextPath() + "/productos.xls" + "\">Expotar a Excel</a></p>");
                out.println("      <p><a href=\"" + req.getContextPath() + "/productos.json" + "\">Mostrar como Json</a></p>");
            }
            out.println("      <table>");
            out.println("         <tr>");
            out.println("         <th>ID</th>");
            out.println("         <th>Nombre</th>");
            out.println("         <th>Tipo</th>");
            out.println("         <th>Precio</th>");
            out.println("         <tr>");
            productos.forEach(p -> out.println("<td>" + p.getId() + "</td>\n" +
                    "<td>" + p.getNombre() + "</td>\n" +
                    "<td>" + p.getTipo() + "</td>\n" +
                    "<td>" + p.getPrecio() + "</td>\n<tr>"
            ));
            out.println("      </table>");

            if(!esXls) {
                out.println("   </body>");
                out.println("</html>");
            }
        }
    }
}