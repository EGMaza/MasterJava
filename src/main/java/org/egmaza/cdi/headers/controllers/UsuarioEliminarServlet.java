package org.egmaza.cdi.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.egmaza.cdi.headers.models.Usuario;
import org.egmaza.cdi.headers.services.UsuarioService;
import org.egmaza.cdi.headers.services.UsuarioServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {

    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        try{
            id = Long.valueOf(req.getParameter("id"));
        }
        catch (NumberFormatException e){
            id = 0L;
        }
        if (id>0){
            Optional<Usuario> u = service.porId(id);
            if(u.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath()+"/usuarios");
            }
            else{
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el usuario en la base de datos!");
            }

        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error: el ID es null, se debe enviar como parámetro en la url!");
        }
    }
}