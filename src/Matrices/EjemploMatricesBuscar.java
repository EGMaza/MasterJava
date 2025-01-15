package Matrices;

public class EjemploMatricesBuscar {
    public static void main(String[] args) {
        int[][] matrizDeEneteros ={
            {35,90,3,1978},
            {15,2020,10,5},
            {677,127,32767,1999}
        };

        int elementoBuscar = 2020;
        boolean encontrado = false;
        int i,j=0;

        buscar: for(i=0;i<matrizDeEneteros.length;i++){
            for(j=0;j<matrizDeEneteros[i].length;j++){
                if(matrizDeEneteros[i][j] == elementoBuscar){
                    encontrado = true;
                    break buscar;
                }
            }
        }

        if(encontrado)
            System.out.println("Encontrado " + elementoBuscar + " en las coordenadas: (" + i + "," + j +")");
        else
            System.out.println(elementoBuscar + " no se encontró en la matriz");
        
    }

}
