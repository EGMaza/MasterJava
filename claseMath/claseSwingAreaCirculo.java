package claseMath;

import javax.swing.*;

public class ClaseSwingAreaCirculo {  
    public static void main(String[] args) {
        
        try{
            double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese radio de la circunferencia"));
            double area = Math.PI * (Math.pow(radio, 2));
            double area2 = area * 100;
            int truncador = (int)area2;
            double areaTruncada = (double)truncador/100;
            JOptionPane.showMessageDialog(null, "El área del círculo es igual a: " + areaTruncada + " cm cuadrados");
            JOptionPane.showMessageDialog(null, "El área del círculo sin truncar es igual a: " + area + " cm cuadrados");
            System.exit(0);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"por favor introduzca un valor válido");
            main(args);
        }
        
    }
}
