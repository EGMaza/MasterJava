package Arreglos;

import java.util.Scanner;

public class EjemploArreglosEliminarElemento {
    public static void main(String[] args) {
        int a[] = new int[10];
        int posicion;
        Scanner s = new Scanner(System.in);

        for(int i=0;i<a.length;i++){
            System.out.print("Ingrese un numero: ");
            a[i]=s.nextInt();
        }
        System.out.println();

        System.out.println("Ingrese la posicion a eliminar (de 0 a 9)");
        posicion=s.nextInt();

        System.out.println("El arreglo sin eliminar elemento:");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for(int i=posicion;i<=a.length-2;i++){
            a[i]=a[i+1];
        }
        
        int[] b = new int[a.length-1];

        for(int i=0;i<b.length;i++){
            b[i] = a[i];
        }
        a=b;

        System.out.println("El arreglo ya sin el elemento eliminado:");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        s.close();
    }

}
