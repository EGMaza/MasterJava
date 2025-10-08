package org.egmaza.optional.ejemplo;

import org.egmaza.optional.ejemplo.models.Computadora;
import org.egmaza.optional.ejemplo.repositorio.ComputadoraRepositorio;
import org.egmaza.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    static void main() {

        Repositorio<Computadora> repositorio = new ComputadoraRepositorio();

        //Optional<Computadora> pc = repositorio.filtrar("Asus rog");

        /*if (pc.isPresent()) {
            System.out.println(pc.get());
        }
        else{
            System.out.println("No se encontró");
        }*/

        repositorio.filtrar("rog").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se encontró"));

    }
}
