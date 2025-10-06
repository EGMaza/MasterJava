package org.egmaza.api.stream.ejemplos;

import org.egmaza.api.stream.ejemplos.models.Factura;
import org.egmaza.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Jonh", "Doe");
        Usuario u2 = new Usuario("Pepe", "Perez");

        u1.addFactura(new Factura("Compras tecnológicas"));
        u1.addFactura(new Factura("Compra de muebles"));

        u2.addFactura( new Factura("Compra de bicicleta"));
        u2.addFactura(new Factura("Compra de notebook"));

        List<Usuario> usuarios = Arrays.asList(u1, u2);

        /*for (Usuario u : usuarios) {
            for(Factura f : u.getFacturas()) {
                System.out.println(f.getDescripcion());
            }
        }*/

        usuarios.stream().flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(", Cliente: ").concat(f.getUsuario().toString())));


    }
}
