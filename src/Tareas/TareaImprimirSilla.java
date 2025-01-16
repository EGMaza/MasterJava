package Tareas;

import java.util.Scanner;

public class TareaImprimirSilla {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("Escriba un número entero diferente de cero: ");
        n = s.nextInt();
        if(n==0){
            System.err.println("ERROR");
            System.exit(1);
        }
        else if(n<0){
            n*=-1;//Por si se ingresa un numero negativo lo vuelve positivo
        }
        
        if(n>146){
            n=146;//En mi consola después de 146 caracteres pintados se da un salto de línea, para evitarlo topé 'n' a 146
        }

        int[][] a = new int[n][n];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(j==0 || i==a[i].length/2 || j==a[i].length-1 && i>a[i].length/2){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        s.close();
    }
}
