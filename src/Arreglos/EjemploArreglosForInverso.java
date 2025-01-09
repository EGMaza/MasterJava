package Arreglos;

import java.util.Arrays;

public class EjemploArreglosForInverso {
    public static void main(String[] args) {
        //String[] productos = new String[7];
        String[] productos = {"Kingston Pendrive 64GB","Samsung Galaxy",
        "Disco Duro SSD Samnsung Externo","Asus Notebook","Macbook Air",
        "Chromecast 4ta generación","Bicicleta Oxford"};
        int max = productos.length;

        /*
        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samnsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";
        */

        Arrays.sort(productos);

        System.out.println("con un ciclo for normal");
        for(int i=0;i<max;i++){
            System.out.println("para indice " + i + ": " + productos[i]);
        }

        System.out.println("\ncon un ciclo for inverso");
        for(int i=0;i<max;i++){
            System.out.println("para indice " + (max-1-i) + ": " + productos[max-1-i]);
        }

        System.out.println("\ncon un ciclo for inverso 2");
        for(int i=max-1;i>=0;i--){
            System.out.println("para indice " + i + ": " + productos[i]);
        }



    }
    //Nota de GIT: Para sincronizar nuestra rama actual con una rama específica del repositorio en GITHUB
    // se usa el siguiente comando:
    //git push --set-upstream <URLRepositorioRemoto> <NombreRamaRepositorioRemoto>
    //Un ejemplo sería:
    //git push --set-upstream https://github.com/EGMaza/EjerciciosCursoJav.git Arreglos
}
