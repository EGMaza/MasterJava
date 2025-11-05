package org.egmaza.apiservlet.webapp.headers.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class TareaListener implements ServletRequestListener {

    private ServletContext servletContext;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletRequest().setAttribute("nombreCompleto", "Eduardo González");
    }
}