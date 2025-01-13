package Arreglos;

import java.util.Scanner;

public class EjemploArreglosBuscarNumero {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner s = new Scanner(System.in);
        for(int i=0;i<a.length;i++){
            System.out.print("Ingrese un número: ");
            a[i]=s.nextInt();
        }

        System.out.println("\nIngrese un número a buscar");
        int num = s.nextInt();
        s.close();

        int i=0;
        /*while (i<a.length && a[i] != num) {
            i++;
        }*/
        for(;i<a.length && a[i] != num;i++){}
        if(i==10){
            System.out.println("Número no encontrado");
        }
        else if(a[i] == num){
            System.out.println("Número encontrado en la posición: " + i);
        }
    }

}
