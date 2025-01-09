package lineaComandos;

public class ArgumentosLineaComandos {
    public static void main(String[] args) {
        if(args.length==0){
            System.err.println("Debe ingresar argumentos o parámetros");
            System.exit(-1);
        }else{
            for(int i = 0;i<args.length;i++){
                System.out.println("Argumentos n°" + i + ": " + args[i]);
            }
        }
    }
}

//NOTA IMPORTANTE: Si se trata de ejecutar una clase que tiene un package desde la consola, se debe ejecutar
// con el comando "java" de la siguiente manera: "java package.nombreClase parametros"
//Si lo que se desea es complilar la clase, entonces se usa el comando
// "javac" de la siguiente manera: "javac package/nombreClase.java"
//OTRA NOTA IMPORTANTE: Se puede compilar desde consola con el agregado "-encoding utf8" ya sea antes o despues
//del nombre de la clase cuando ejecutamos el comando "javac", quedando de la siguientes maneras:
//"javac -encoding utf8 package/nombreClase.java" o bien
//"javac package/nombreClase.java -encoding utf8"
//De cualquiera de las dos maneras lo que se logra al compilar la clase es que reconozca los acentos y algunos
//caracteres especiales al ejecutar el programa
