package org.egmaza.appfacturas;

import java.util.Scanner;

import org.egmaza.appfacturas.modelo.*;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("555-5");
        cliente.setNombre("Andrés");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese la descripción de la factura: ");
        Factura factura = new Factura(s.nextLine(), cliente);
        Producto producto;
        System.out.println();

        for(int i=0;i<2;i++){
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + 
            ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");

            factura.addItemFactura(new ItemFactura(s.nextInt(), producto));

            System.out.println();
            s.nextLine();
        }
        s.close();
        System.out.println(factura);
    }
}
