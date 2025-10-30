package org.egmaza.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametroGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("   <meta charset=\"UTF-8\">");
        out.println("   <title>Parámetros Get de la url</title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("      <h1>Parámetros Get de la url!</h1>");
        if(saludo!=null && nombre!=null){
            out.println("      <h2>El saludo enviado es: " + saludo + " " + nombre + "</h2>");
        }
        else if(saludo!=null){
            out.println("      <h2>El saludo enviado es: " + saludo + "</h2>");
        }
        else if(nombre!=null){
            out.println("      <h2>El nombre enviado es: " + nombre + "</h2>");
        }
        else {
            out.println("<h2>no se han pasado los parámetros saludo ni nombre</h2>");
        }
        try {
            Integer codigo = Integer.valueOf(req.getParameter("codigo"));
            out.println("<h3>El código enviado es: " + codigo + "</h3>");
        } catch (NumberFormatException e) {
            out.println("<h3>El código no fue enviado, es null!!!</h3>");
        }

        out.println("   </body>");
        out.println("</html>");
        out.close();
    }
}
