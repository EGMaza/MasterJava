package Tareas;

import java.util.Scanner;

public class TareaPromedioPositivosNegativos {
    public static void main(String[] args) {
        double[] a = new double[7];
        Scanner s = new Scanner(System.in);

        double sumPositivos=0, sumNegativos=0;
        int contPositivos=0, contNegativos=0, contCeros=0;

        for(int i=0;i<a.length;i++){
            System.out.print("Ingrese un número: ");
            a[i]=s.nextDouble();
            if(a[i]>0){
                sumPositivos+=a[i];
                contPositivos++;
            }else if(a[i]<0){
                sumNegativos+=a[i];
                contNegativos++;
            }else{
                contCeros++;
            }
        }
        if(contPositivos==0)
            System.out.println("Promedio de los número positivos = 0");
        else
            System.out.println("Promedio de los número positivos = " + sumPositivos/contPositivos);
        
        if(contNegativos==0)
            System.out.println("Promedio de los número negativos = 0");
        else
            System.out.println("Promedio de los número negativos = " + sumNegativos/contNegativos);
        
        System.out.println("Numero de ceros encontrados = " + contCeros);
    s.close();
    }
}
