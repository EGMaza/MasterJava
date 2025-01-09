package claseMath;

public class EjemploClaseMath {
    public static void main(String[] args) {
        
        int absoluto = Math.abs(-3);
        System.out.println("Absoluto = " + absoluto);

        absoluto = Math.abs(3);
        System.out.println("Absoluto = " + absoluto);

        double max = Math.max(3.5, 1.2);
        System.out.println("max = " + max); 

        double min = Math.min(3.5, 1.2);
        System.out.println("min = " + min);

        double techo = Math.ceil(3.5);
        System.out.println("techo = " + techo);

        double piso = Math.floor(3.5);
        System.out.println("piso = " + piso);

        long entero = Math.round(3.5);
        System.out.println("entero = " + entero);

        long entero2 = Math.round(3.4);
        System.out.println("entero2 = " + entero2);

        long entero3 = Math.round(Math.PI);//Math.PI = 3.141592653589793
        System.out.println("entero3 = " + entero3);

        System.out.println("PI en Java = " + Math.PI);

        double exp = Math.exp(1);
        System.out.println("e = " + exp);

        double log = Math.log(10);
        System.out.println("log = " + log);

        double potencia = Math.pow(10, 3);
        System.out.println("potencia = " + potencia);

        double raiz = Math.sqrt(5);
        System.out.println("raiz = " + raiz);

        double grados = Math.toDegrees(1.57);
        grados = Math.round(grados);
        System.out.println("convertir de radianes a grados (aproximación) = " + grados);

        double radianes = Math.toRadians(90);
        System.out.println("convertir de grados a radianes = " + radianes);

        System.out.println("sin(90): " + Math.sin(radianes));//la función seno (sin) de Java recibe RADIANES
        //(no grados directamente) como parámetro

        System.out.println("cos(90): + " + Math.cos(radianes));

        radianes = Math.toRadians(180);
        System.out.println("sin(180): " + Math.sin(radianes));
        System.out.println("cos(180): + " + Math.cos(radianes));

        radianes = Math.toRadians(0);
        System.out.println("sin(0): " + Math.sin(radianes));
        System.out.println("cos(0): + " + Math.cos(radianes));

        //Nota: La clase Math al igual que la clases System, no se puede
        //instanciar, solo tiene elementos estáticos (métodos y constantes)

    }

}
