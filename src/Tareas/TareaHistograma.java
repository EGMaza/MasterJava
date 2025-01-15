package Tareas;

public class TareaHistograma {
    public static void main(String[] args) {
        int[] a = new int[12];
        
        for(int i=0;i<a.length;i++){
            a[i] = (int) (Math.random() * 6) + 1;
        }

        System.out.print("\nArreglo obtenido: ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int[] histograma = new int[6];
        for(int i=0;i<a.length;i++){
            switch (a[i]) {
                case 1:
                    histograma[0]++;
                    break;
                    
                case 2:
                    histograma[1]++;
                    break;
                    
                case 3:
                    histograma[2]++;
                    break;
                    
                case 4:
                    histograma[3]++;
                    break;
                    
                case 5:
                    histograma[4]++;
                    break;
                    
                case 6:
                    histograma[5]++;
                    break;
            
                default:
                    break;
            }
        }
        System.out.println("Histograma:");
        for(int i=0;i<histograma.length;i++){
            System.out.print(i+1 + ".- ");
            for(int j=0;j<histograma[i];j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
