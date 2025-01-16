package Tareas;

import java.util.Scanner;

public class TareaImprimirX {
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
            n=146;//En mi consola despues de 146 caracteres pintados se da un salto de linea, para evitarlo topé 'n' a 146
        }

        int[][] a = new int[n][n];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(i==j || a.length-i-1==j){
                    System.out.print("X");
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        s.close();
    }
}
