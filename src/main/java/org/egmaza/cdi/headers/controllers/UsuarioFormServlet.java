package org.egmaza.cdi.headers.controllers;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/usuarios/form")
public class UsuarioFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceJdbcImpl(conn);

        Long id;
        try {
            id = Long.valueOf(req.getParameter("id"));
        }
        catch (NumberFormatException e) {
            id = 0L;
        }

        Usuario usuario = new Usuario();

        if(id>0){
            Optional<Usuario> opt = service.porId(id);
            if (opt.isPresent()){
                usuario = opt.get();
            }
        }
        req.setAttribute("usuario", usuario);
        req.setAttribute("title", req.getAttribute("title") + ": Formulario de usuarios");
        getServletContext().getRequestDispatcher("/formUsuario.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceJdbcImpl(conn);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");


        Map<String, String> errores = new HashMap<>();
        if (username == null || username.isEmpty()){
            errores.put("username", "el nombre de usuario es requerido");
        }

        if (password == null || password.isEmpty()){
            errores.put("password", "la contraseña es requerida");
        }

        if (email == null || email.isEmpty()){
            errores.put("email", "el email es requerido");
        }


        Long id;
        try{
            id=Long.valueOf(req.getParameter("id"));
        }
        catch (NumberFormatException e){
            id=0L;
        }

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setPassword(password);
        usuario.setUsername(username);
        usuario.setEmail(email);

        if(errores.isEmpty()){
            service.guardar(usuario);
            resp.sendRedirect(req.getContextPath()+"/usuarios");
        }
        else{
            req.setAttribute("errores", errores);
            req.setAttribute("usuario", usuario);
            req.setAttribute("title", req.getAttribute("title") + ": Formulario de usuarios");
            getServletContext().getRequestDispatcher("/formUsuario.jsp").forward(req, resp);
        }
    }
}