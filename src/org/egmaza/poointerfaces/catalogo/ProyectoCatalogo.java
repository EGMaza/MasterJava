package org.egmaza.poointerfaces.catalogo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProyectoCatalogo {
    public static void main(String[] args){

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date dia1,dia2;

        try{
            dia1 = f.parse( "02/08/2017");
            dia2 = f.parse("01/11/2023");
        }
        catch(ParseException e){
            System.err.println("Fecha erronea");
            dia1 = null;
            dia2 = null;
            System.exit(1);
        }

        Producto[] listaProductos = {
            new IPhone(18999, "Apple", "IPhone 15", "blanco"),
            new TvLcd(5699, "Hisense", 32),
            new Libro(559, dia1, "Hector Arturo Flores", "Programación orientada a objetos usando Java", "Ecoe Ediciones"),
            new Comics(79, dia2, "Dan Slott", "The Amazing Spider-Man N.9", "Panini Comics", "Spider-Man")
        };

        for(Producto p:listaProductos){
            System.out.println("Producto: " + p.getClass().getSimpleName() + p + "\n");
        }
    }
}