package org.egmaza.patrones.singleton;

public class ConexionDBSingleton {

    private static ConexionDBSingleton instancia;

    private ConexionDBSingleton(){
        System.out.println("Conectándose a algún motor de base de datos");
    }

    public static ConexionDBSingleton getInstancia(){
        if(instancia == null){
            instancia = new ConexionDBSingleton();
        }
        return instancia;
    }
}