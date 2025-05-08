package org.egmaza.carrosupermercado;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado<T>{

    private List<T> objetos;
    private int max = 5;

    public BolsaSupermercado() {
        this.objetos = new ArrayList<>();
    }

    public void addProducto(T t){
        if(objetos.size()<=max){
            objetos.add(t);
        }
        else{
            throw new RuntimeException("Se alcanzó el número máximo de objetos en la bolsa");
        }
    }

    public List<T> getProductos(){
        return objetos;
    }
}
