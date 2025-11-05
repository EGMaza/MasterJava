package org.egmaza.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/index.html",""})
public class NombreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try(PrintWriter out = resp.getWriter()){

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("   <meta charset=\"UTF-8\">");
        out.println("   <title>Tarea Listener Nombre!</title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("      <h1>Tarea Listener Nombre!</h1>");
        out.println("      <h2> "+ (String)req.getAttribute("nombreCompleto") +"</h2>");
        out.println("   </body>");
        out.println("</html>");
        }
    }
}