package Arreglos;

import java.util.Arrays;
//import java.util.Collections;

public class EjemploArreglosForInversoMutable {
    public static void main(String[] args) {
        //String[] productos = new String[7];
        String[] productos = {"Kingston Pendrive 64GB","Samsung Galaxy",
        "Disco Duro SSD Samnsung Externo","Asus Notebook","Macbook Air",
        "Chromecast 4ta generación","Bicicleta Oxford","Mochila Pocket"};

        int max = productos.length;
        Arrays.sort(productos);
        //Collections.reverse(Arrays.asList(productos));
        arregloInverso(productos);//lo que se pasa como parámetro es la REFERENCIA de donde está el objeto Array que se va a modificar
        //por lo cual cuando dicho objeto se vuelva a consultar se verán reflejados los cambios hechos aunque éstos se hallan realizado
        //con otro objeto Array que usó ésa misma referencia
        

        System.out.println("con un ciclo for normal");
        for(int i=0;i<max;i++){
            System.out.println("para indice " + i + ": " + productos[i]);
        }

        /*System.out.println("con un ciclo for mutado");
        for(int i=0;i<max;i++){
            String actual = productos[i];
            String inverso = productos[max-i-1];
            productos[i] = inverso;
            productos[max-i-1] = actual;
            if(i>=(max-i-1)){
                break;
            }
        }*/

    }

    public static void arregloInverso(String[] productos){

        int max = productos.length;
        
        for(int i=0;i<(max/2);i++){
            String actual = productos[i];
            String inverso = productos[max-i-1];
            productos[i] = inverso;
            productos[max-i-1] = actual;
        }
    }
    //Nota de GIT: Para sincronizar nuestra rama actual con una rama específica del repositorio en GITHUB
    // se usa el siguiente comando:
    //git push --set-upstream <URLRepositorioRemoto> <NombreRamaRepositorioRemoto>
    //Un ejemplo sería:
    //git push --set-upstream https://github.com/EGMaza/EjerciciosCursoJav.git Arreglos
}
