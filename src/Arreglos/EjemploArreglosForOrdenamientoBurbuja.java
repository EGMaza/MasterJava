package Arreglos;

public class EjemploArreglosForOrdenamientoBurbuja {
    public static void main(String[] args) {
        String[] productos = {"Kingston Pendrive 64GB","Samsung Galaxy",
        "Disco Duro SSD Samnsung Externo","Asus Notebook","Macbook Air",
        "Chromecast 4ta generación","Bicicleta Oxford"};

        sortBurbuja(productos);

        int max = productos.length;
        for(int i=0;i<max;i++){
            System.out.println("para indice " + i + ": " + productos[i]);
        }

        //----------------------

        Integer[] numeros = new Integer[4];

        numeros[0] = 10;
        numeros[1] = 7;
        numeros[2] = 35;
        numeros[3] = -1;

        sortBurbuja(numeros);

        max = numeros.length;
        for(int i=0;i<max;i++){
            System.out.println("para indice " + i + ": " + numeros[i]);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })//Esta linea sirve para ignorar los warnings que se puedan
    //generar durante la ejecución del código
    public static void sortBurbuja(Object[] arreglo){
        int cont = 0;
        int max = arreglo.length;
        for(int i=0;i<max-1;i++){
            for(int j=0;j<max-1-i;j++){
                if(((Comparable)arreglo[j+1]).compareTo(arreglo[j])>0){
                    Object aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                }
                cont++;
            }
        }
        System.out.println("El programa iteró " + cont + " veces");

    }

        

    //Nota de GIT: Para sincronizar nuestra rama actual con una rama específica del repositorio en GITHUB
    // se usa el siguiente comando:
    //git push --set-upstream <URLRepositorioRemoto> <NombreRamaRepositorioRemoto>
    //Un ejemplo sería:
    //git push --set-upstream https://github.com/EGMaza/EjerciciosCursoJav.git Arreglos
}
