package Arreglos;

import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2b {
    public static void main(String[] args) {

        int[] a = new int[10];
        int elemento, posicion, ultimo;
        Scanner s = new Scanner(System.in);

        for(int i=0;i<a.length;i++){
            System.out.print("Ingrese un número: ");
            a[i] = s.nextInt();
        }
        ultimo = a[a.length-1];

        System.out.println();
        System.out.println("Introduzca el nuevo elemento: ");
        elemento = s.nextInt();
        System.out.println("Introduzca la posición donde agregar (de 0 a 9)");
        posicion = s.nextInt();

        for(int i=a.length-2;i>=posicion;i--){
            a[i+1] = a[i];
        }

        a[posicion]=elemento;

        int[] b = new int[a.length+1];
        System.arraycopy(a, 0, b, 0, 10);
        b[b.length-1]=ultimo;
        a=b;

        System.out.println("El arreglo:");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        s.close();
    }
}
