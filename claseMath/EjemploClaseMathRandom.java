package claseMath;

import java.util.Random;

public class EjemploClaseMathRandom {
    public static void main(String[] args) {
        double random = Math.random();
        String [] colores = {"azul","amarillo","rojo","verde","blanco","negro"};
        System.out.println("random = " + random);

        random *= colores.length;
        System.out.println("random = " + random);

        random = Math.floor(random);
        System.out.println("random = " + random);

        Random objRandom = new Random();
        int randomInt = 10 + objRandom.nextInt(10);//Imprime un número entero al azar entre 10 y 19
        System.out.println("randomInt = " + randomInt);

        randomInt = objRandom.nextInt(colores.length);
        System.out.println("randomInt = " + randomInt);
        System.out.println("colores: " + colores[randomInt]);

        for(int c = 0;c<15;c++){
            Random objRandom2 = new Random();
            int randomInt2 = -10 + objRandom2.nextInt(21);
            System.out.println("randomInt2 = " + randomInt2);
            //imprime 15 valores enteros al azar entre -10 y 10 (incluyendo ambos)
        }
    }
}
