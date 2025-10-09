package org.egmaza.optional.ejemplo;

import org.egmaza.optional.ejemplo.models.Computadora;
import org.egmaza.optional.ejemplo.models.Fabricante;
import org.egmaza.optional.ejemplo.models.Procesador;
import org.egmaza.optional.ejemplo.repositorio.ComputadoraRepositorio;
import org.egmaza.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {

    public static void main(String[] args) {

        Repositorio<Computadora> repositorio = new ComputadoraRepositorio();

        String f = repositorio.filtrar("asus")
                //.flatMap( c -> c.getProcesador())
                .flatMap(Computadora::getProcesador)
                //.flatMap(p -> p.getFabricante())
                .flatMap(Procesador::getFabricante)
                .filter(fab -> "Intel".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                //.orElseThrow() //devuelve (arroja) una excepción (pesonaizada si se pasa como parámetro) si el Optional generado hasta el momento está vacío
                .orElse("Desconocido"); //devuelve el valor pasado como parámetro si el Optional generado hasta el momento está vacío

        System.out.println(f);
    }
}