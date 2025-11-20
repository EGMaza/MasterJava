package org.egmaza.cdi.headers.controllers;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.egmaza.cdi.headers.configs.ProductoServicePrincipal;
import org.egmaza.cdi.headers.models.Producto;
import org.egmaza.cdi.headers.services.ProductoService;
import org.egmaza.cdi.headers.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/productos/eliminar")
public class ProductoEliminarServlet extends HttpServlet {

    @Inject
    @ProductoServicePrincipal
    private ProductoService service;

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
            Optional<Producto> o = service.porId(id);
            if(o.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath()+"/productos");
            }
            else{
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el producto en la base de datos!");
            }

        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error: el ID es null, se debe enviar como parámetro en la url!");
        }
    }
}
