package org.egmaza.poointerfaces.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.egmaza.poointerfaces.modelo.Cliente;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    public ClienteListRepositorio(List<Cliente> dataSource) {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for(Cliente cli:dataSource){
            if(cli.getId()!=null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = (this.porId(cliente.getId()));
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
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

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
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

    @Override
    public int total() {
        return this.dataSource.size();
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