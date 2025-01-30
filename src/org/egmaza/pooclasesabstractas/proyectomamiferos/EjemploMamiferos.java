package org.egmaza.pooclasesabstractas.proyectomamiferos;

import org.egmaza.pooclasesabstractas.proyectomamiferos.animales.*;

public class EjemploMamiferos {
    
    public static void main(String[] args) {
            
        Mamifero[] mamiferos = {
            new Leon("Sabana", 120, 180, 190, "Panthera leo", 3, 70, 15, 114),
            new Tigre("Selva", 85, 280, 150, "Panthera tigris", 7.5f,55,"Tigre de Sumatra"),
            new Guepardo("Sabana", 80, 130, 65, "Acinonyx jubatus", 2, 110),
            new Lobo("Bosque", 83, 140, 60, "Canis lupus", "gris", 5, 6, "Canis lupus occidentalis"),
            new Perro("Ciudad", 35, 55, 25, "Canis lupus familiaris", "marrón", 5.3f, 43),
            new Perro("Ciudad", 25, 40, 15, "Canis lupus familiaris", "blanco", 3.1f, 32),
            new Perro("Campo", 48, 60, 35, "Canis lupus familiaris", "negro", 6.6f, 68)
        };
        
        for(Mamifero m:mamiferos){
            System.out.println(m.getClass().getSimpleName() +": "+ m);
            System.out.println(m.comer());
            System.out.println(m.dormir());
            System.out.println(m.correr());
            System.out.println(m.comunicarse());
            System.out.println();
        }
    }
}