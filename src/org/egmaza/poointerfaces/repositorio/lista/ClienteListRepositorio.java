package org.egmaza.poointerfaces.repositorio.lista;

import org.egmaza.poointerfaces.modelo.Cliente;
import org.egmaza.poointerfaces.repositorio.AbstractaListRepositorio;
import org.egmaza.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) {
        Cliente c = (this.porId(cliente.getId()));
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
      
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC){
                resultado = ordenar(campo, a, b);
            }
            else if(dir == Direccion.DESC){
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo) {
            case "id":
                resultado =a.getId().compareTo(b.getId());
            break;
            case "nombre":
                resultado =a.getNombre().compareTo(b.getNombre());
            break;
            case "apellido":
                resultado =a.getApellido().compareTo(b.getApellido());
            break;
        }
        return resultado;
    }
}

/*ESTE METODO IMPLEMENTA UNA CLASE ANÓNIMA
public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        //ESTO ES UNA CLASE ANONIMA:
        //Aqui empieza la clase anónima --------------------------------------------------------
        
        //Declaracion de la clase anónima:::
        listaOrdenada.sort(new Comparator<Cliente>() {

            //Atributo de la clase anónima:::
            int resultado = 0;

            //Metodo 1 de la clase anónima (este es el que se ejecuta al llamar la clase):::
            @Override
            public int compare(Cliente a, Cliente b) {
                //int resultado = 0;
                if(dir == Direccion.ASC){
                    resultado = this.ordenar(a, b);
                }
                else if(dir == Direccion.DESC){
                    resultado = this.ordenar(b, a);
                }
                return resultado;
            }

            //Metodo 2 de la clase anónima:::
            private int ordenar(Cliente a, Cliente b){
                //int resultado = 0;
                if(dir == Direccion.ASC){
                    switch (campo) {
                        case "id":
                            resultado =a.getId().compareTo(b.getId());
                        break;
                        case "nombre":
                            resultado =a.getNombre().compareTo(b.getNombre());
                        break;
                        case "apellido":
                            resultado =a.getApellido().compareTo(b.getApellido());
                        break;
                    }
                }
                return resultado;
            }
        });
        //Aqui termina la clase anónima --------------------------------------------------------
        return listaOrdenada;
    }
 */