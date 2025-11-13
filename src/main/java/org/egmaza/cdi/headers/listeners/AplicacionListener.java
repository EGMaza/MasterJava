package org.egmaza.cdi.headers.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.egmaza.cdi.headers.models.Carro;

@WebListener
public class AplicacionListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Inicializando la aplicación");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje" , "algún valor global de la app!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //sce.getServletContext().log("Destruyendo la aplicación");
        servletContext.log("Destruyendo la aplicación");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Inicializando el request");
        sre.getServletRequest().setAttribute("mensaje", "guardando algún valor para el request");
        sre.getServletRequest().setAttribute("title", "Catálogo Servet");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Destruyendo el request");

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Inicializando la sesión HTTP");
        //Carro carro = new Carro();
        //HttpSession session = se.getSession();
        //session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la sesión HTTP");
    }
}