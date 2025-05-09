package org.egmaza.poointerfaces.repositorio;

import org.egmaza.poointerfaces.modelo.BaseEntity;
import org.egmaza.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if(id==null || id<=0){
            throw new LecturaAccesoDatoException("ID inválido, debe ser > 0");
        }

        T resultado = null;
        for(T cli:dataSource){
            if(cli.getId()!=null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        if (resultado == null){
            throw new LecturaAccesoDatoException("No existe registro con el ID: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException{
        if (t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }

        if(this.dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Error: el objeto con ID " + t.getId() + " existe en el repositorio");
        }

        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
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