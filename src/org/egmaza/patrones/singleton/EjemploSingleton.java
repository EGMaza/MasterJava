package org.egmaza.patrones.singleton;

public class EjemploSingleton {

    public static void main(String[] args) {
        ConexionDBSingleton con = null;
        for(int i=0; i<10; i++){
            con = ConexionDBSingleton.getInstancia();
            System.out.println("con = " + con);
        }

        ConexionDBSingleton con2 = ConexionDBSingleton.getInstancia();
        ConexionDBSingleton con3 = ConexionDBSingleton.getInstancia();

        boolean b1 = (con == con2) && (con2 == con3) && (con == con3);
        System.out.println("b1 = " + b1);
    }
}