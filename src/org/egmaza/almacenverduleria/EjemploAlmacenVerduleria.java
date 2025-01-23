package org.egmaza.almacenverduleria;

public class EjemploAlmacenVerduleria {
    public static void main(String[] args) {

        Producto[] productos = {
            new Fruta("Manzanas Golden", 45, 1000, "rojo"),
            new Fruta("Plátanos Dominicos", 23, 500, "amarillo"),
            new Lacteo("Yogurth Lala", 12, 2, 30),
            new Lacteo("Queso Oaxaca La Villita", 50, 1, 180),
            new Limpieza("Limpiapisos Fabuloso", 80, 
                "Sulfonato de sodio 20%, Perfume C9-11",2.5), 
            new Limpieza("Detergente Mas Color", 55,
                "Carboximetil celulosa, Edta/Tripolifosfato de sodio", 2),
            new NoPerecible("Donitas Bimbo", 22, 6, 1250),
            new NoPerecible("Galletas Emperador Gamesa", 20, 10, 480)
        };

        for(Producto p:productos){
            System.out.println(p);
            System.out.println("===================================================================");
        }
    }    
}