package Arreglos;

import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion3b {
    public static void main(String[] args) {
        int[] a = new int[7];
        int numero, posicion, ultimo;
        Scanner s = new Scanner(System.in);

        for(int i = 0;i<a.length;i++){
            System.out.print("Ingrese un número: ");
            a[i] = s.nextInt();
        }
        System.out.println();
        System.out.println("Ingrese un numero a insertar: ");
        numero = s.nextInt();
        posicion = 0;
        int[] b = new int[a.length+1];
        if(numero>a[a.length-1]){
            System.arraycopy(a, 0, b, 0, a.length);
            b[b.length-1] = numero;
        }
        else{
            ultimo = a[a.length-1];
            while(a[posicion] < numero && posicion < a.length){
                posicion++;
            }
    
            for(int i = a.length-2; i>=posicion;i--){
                a[i+1] = a[i];
            }
            a[posicion] = numero;
            System.arraycopy(a, 0, b, 0, a.length);
            b[b.length-1] = ultimo;
        }
        a=b;

        System.out.println("El nuevo arreglo ordenado:");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        s.close();
    }
}
