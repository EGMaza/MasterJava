package org.egmaza.optional.ejemplo;

import org.egmaza.optional.ejemplo.models.Computadora;
import org.egmaza.optional.ejemplo.repositorio.ComputadoraRepositorio;
import org.egmaza.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {

    public static void main(String[] args) {

        Repositorio<Computadora> repositorio = new ComputadoraRepositorio();

        Computadora pc = repositorio.filtrar("rog")
                //.get(); //Funcionalmente es lo mismo que .orElseThrow pero por convención lo correcto es usar .orrElseThrow si no se usa el .isPresent()
                //.orElseThrow(() -> new IllegalStateException());
                .orElseThrow(IllegalStateException::new);

        System.out.println(pc);
        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();

        System.out.println(extension);

    }
}