package org.egmaza.cdi.headers.services;

import org.egmaza.cdi.headers.models.Categoria;
import org.egmaza.cdi.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L,"Notebook Asus", "Computación", 175000),
                new Producto(2L, "Mesa escritorio", "Oficina", 100000),
                new Producto(3L,"Teclado mecánico", "Computación", 40000));
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return List.of();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
