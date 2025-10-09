package org.egmaza.optional.ejemplo.repositorio;

import org.egmaza.optional.ejemplo.models.Computadora;
import org.egmaza.optional.ejemplo.models.Fabricante;
import org.egmaza.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadoraRepositorio implements Repositorio<Computadora>{

    private List<Computadora> dataSource = new ArrayList<>();
    public ComputadoraRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("I9-9880H", new Fabricante("Intel"));
        //Procesador proc = new Procesador("Ryzen 9", new Fabricante("AMD"));
        Computadora asus = new Computadora("Asus ROG", "Strix G512", proc);

        dataSource.add(asus);
        dataSource.add(new Computadora("MacBook Pro", "MVVK2CI"));
    }

    @Override
    public Optional<Computadora> filtrar(String nombre) {
        return dataSource.stream()
                .filter( c ->
                        c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();
        /*for(Computadora c : dataSource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
        */
    }
}