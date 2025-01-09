package lineaComandos;

public class ArgumentosLineaComandosCalculadora {
    public static void main(String[] args) {
        if(args.length==3){
            String tipoOp = args[0].toLowerCase();
            double num1 = Double.parseDouble(args[1]);
            double num2 = Double.parseDouble(args[2]);
            double resultado;

            switch (tipoOp) {
                case "sumar":
                    resultado = num1 + num2;
                    System.out.println("El resultado de la suma de " + num1 + " mas " + num2 + " es " + resultado);
                    break;
                
                case "restar":
                    resultado = num1 - num2;
                    System.out.println("El resultado de la resta de " + num1 + " menos " + num2 + " es " + resultado);
                    break;
                
                case "multiplicar":
                    resultado = num1 * num2;
                    System.out.println("El resultado de la multiplicación de " + num1 + " por " + num2 + " es " + resultado);
                    break;
                
                case "dividir":
                    if(num2 != 0){
                        resultado = num1 / num2;
                        System.out.println("El resultado de la división de " + num1 + " entre " + num2 + " es " + resultado);
                    }
                    else{
                        System.out.println("No se puede dividir entre cero");
                    }
                    break;

                default:
                    System.out.println("Operacion no reconocida");
                    break;
            }
            /*
            if(tipoOp.equals("sumar")){}
            else if(tipoOp.equals("restar")){}
            else if(tipoOp.equals("multiplicar")){}
            else if(tipoOp.equals("dividir")){}
            else{}
            */


        }
        else{
            System.out.println("Debe introducir parámetros");
        }
        
    }
}
