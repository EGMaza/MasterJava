package claseMath;

import java.util.Scanner;

public class CalculaAreaCirculo {
    public static void main(String[] args) {
        double radio = 3.2;
        double area;
        Scanner s = new Scanner(System.in);
        try{
            System.out.print("Por favor introduzca el radio en cm del circulo: ");
            radio = Double.parseDouble(s.nextLine());
            area = Math.PI * (Math.pow(radio, 2));
            System.out.println("El área del circulo con radio " + radio + " es igual a " + area + " cm cuadrados");
        }
        catch(NumberFormatException e){
            System.out.println("Valor introducido no numerico o no valido");    
        }
    }
}
