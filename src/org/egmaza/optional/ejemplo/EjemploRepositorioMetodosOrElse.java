package org.egmaza.optional.ejemplo;

import org.egmaza.optional.ejemplo.models.Computadora;
import org.egmaza.optional.ejemplo.repositorio.ComputadoraRepositorio;
import org.egmaza.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {

    public static void main(String[] args) {

        Repositorio<Computadora> repositorio = new ComputadoraRepositorio();

        Computadora defecto = new Computadora("HO Omen", "LA0001");
        Computadora pc = repositorio.filtrar("rog")
                .orElse(valorDefecto());

        System.out.println(pc);
        //pc = repositorio.filtrar("macbook5").orElseGet(() -> valorDefecto());
        pc = repositorio.filtrar("macbook pro")
                .orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);

        System.out.println(pc);
    }

    public static Computadora valorDefecto(){
        System.out.println("Obteniendo valor por defecto!!!");
        return new Computadora("HO Omen", "LA0001");
    }
}
