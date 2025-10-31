package org.egmaza.apiservlet.webapp.headers.services;

import org.egmaza.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L,"Notebook Asus", "Computación", 175000),
                new Producto(2L, "Mesa escritorio", "Oficina", 100000),
                new Producto(3L,"Teclado mecánico", "Computación", 40000));
    }
}
