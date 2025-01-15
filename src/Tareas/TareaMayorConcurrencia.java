package Tareas;

public class TareaMayorConcurrencia {
    public static void main(String[] args) {
        int[] a = new int[10];
        
        for(int i=0;i<a.length;i++){
            a[i] = (int) (Math.random() * 9) + 1;
        }

        System.out.print("\nArreglo obtenido: ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int aux=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    aux = a[j+1];
                    a[j+1]=a[j];
                    a[j]=aux;
                }
            }
        }

        int[] mayores = new int[10];
        int numAnalizado=a[0], contRepsActual=0, contRepsMayor=0, indiceMayores=0;
        
        for(int i=0;i<a.length-1;i++){
            if(contRepsActual==0){
                numAnalizado=a[i];
                contRepsActual++;
            }
                
            if(a[i]==a[i+1]){
                contRepsActual++;
            }
            else if(contRepsActual==contRepsMayor){
                mayores[indiceMayores]=numAnalizado;
                indiceMayores++;
                contRepsActual=0;
            }
            else if(contRepsActual>contRepsMayor){
                for(int j=0;j<=indiceMayores;j++)
                    mayores[j]=a[0]-1;

                indiceMayores=0;
                mayores[indiceMayores]=numAnalizado;
                indiceMayores++;
                contRepsMayor=contRepsActual;
                contRepsActual=0;
            }
            else{
                contRepsActual=0;
            }
            
            if(i==a.length-2){
                if(contRepsActual>contRepsMayor){
                    mayores[0]=numAnalizado;
                    mayores[1]=a[0]-1;
                    contRepsMayor=contRepsActual;
                    indiceMayores=0;
                }
                else if(contRepsActual==contRepsMayor){
                    mayores[indiceMayores]=numAnalizado;
                    indiceMayores++;
                }
            }
        }

        if(indiceMayores>1){
            System.out.print("Los número que se encontraron más veces fueron: ");
            for(int i=0;i<indiceMayores;i++){
                System.out.print(mayores[i] + " ");
            }
            System.out.println("\nConcurrencias encontradas de cada uno: " + contRepsMayor);
        }
        else{
            System.out.println("El numero que se encontró mas veces fue: " + mayores[0]);
            System.out.println("Concurrencias encontradas " + contRepsMayor);
        }
    }
}
