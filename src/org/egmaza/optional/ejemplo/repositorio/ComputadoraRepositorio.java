package org.egmaza.optional.ejemplo.repositorio;

import org.egmaza.optional.ejemplo.models.Computadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadoraRepositorio implements Repositorio<Computadora>{

    private List<Computadora> dataSource = new ArrayList<>();
    public ComputadoraRepositorio() {
        dataSource = new ArrayList<>();
        dataSource.add(new Computadora("Asus ROG", "Strix G512"));
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