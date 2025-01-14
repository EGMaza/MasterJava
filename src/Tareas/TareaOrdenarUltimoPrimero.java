package Tareas;

import java.util.Scanner;

public class TareaOrdenarUltimoPrimero {
    public static void main(String[] args) {
        int[] a = new int[10];

        Scanner s = new Scanner(System.in);

        for(int i=0;i<a.length;i++){
            System.out.print("Ingrese un número: ");
            a[i] = s.nextInt();
        }

        System.out.println("Arreglo en el orden especificado: ");
        for(int i=0;i<a.length/2;i++){
            System.out.print(a[a.length-i-1] + " " + a[i] + " ");
        }
        s.close();
    }
}
