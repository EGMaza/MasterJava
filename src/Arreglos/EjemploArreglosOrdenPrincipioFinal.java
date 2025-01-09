package Arreglos;

public class EjemploArreglosOrdenPrincipioFinal {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int[] a = new int[10];

        for(int i=0;i<numeros.length;i++){
            numeros[i] = i +1 ;
        }
        int cont = 0;
        for(int i=0;i<numeros.length-i;i++){

            //System.out.print(numeros[i] + " ");
            //System.out.print(numeros[numeros.length-1-i] + " ");
            a[cont++]=numeros[i];
            a[cont++]=numeros[numeros.length-1-i];
        }

        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }        
    }

}
