package Tareas;

import java.util.Scanner;

public class TareaImprimeNumeroMayor {
    public static void main(String[] args) {
        int[] a = new int[7];
        int mayor = 11;
        Scanner s = new Scanner(System.in);
        
        for(int i=0;i<a.length;i++){

            System.out.print("Ingrese un numero del 11 al 99: ");
            a[i] = s.nextInt();

            if(a[i]>99 || a[i]<11){
                System.out.println("\nNumero no valido, reintente");
                i--;
            }
            else if(a[i]>mayor){
                mayor = a[i];
            }
        }

        System.out.print("\nArreglo ingresado: ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("\nEl número mayor del arreglo es: " + mayor);

        s.close();
    }
}
