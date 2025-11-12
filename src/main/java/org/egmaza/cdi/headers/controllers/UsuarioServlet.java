package org.egmaza.cdi.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.egmaza.cdi.headers.models.Usuario;
import org.egmaza.cdi.headers.services.*;
import org.egmaza.cdi.headers.services.LoginService;
import org.egmaza.cdi.headers.services.LoginServiceSessionImpl;
import org.egmaza.cdi.headers.services.UsuarioService;
import org.egmaza.cdi.headers.services.UsuarioServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection)req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceJdbcImpl(connection);
        List<Usuario> usuarios = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("usuarios", usuarios);
        req.setAttribute("username", usernameOptional);
        req.setAttribute("title", req.getAttribute("title") + ": Listado de usuarios");
        getServletContext().getRequestDispatcher("/listarUsuarios.jsp").forward(req, resp);
    }
}