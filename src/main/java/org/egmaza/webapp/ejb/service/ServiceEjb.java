package org.egmaza.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;

//@RequestScoped
@Stateless
public class ServiceEjb {

    private int contador;

    public String saludar(String nombre){
        System.out.println("Imprimiendo dentro del ejb con instancia: " + this);
        contador++;
        System.out.println("Valor del contador en método saludar: " + contador);
        return "Hola que tal " + nombre;
    }
}
