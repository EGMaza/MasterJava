package org.egmaza.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window03GridLayout extends JFrame implements ActionListener{

    public Window03GridLayout(){
        super("Ejemplo de Botón y eventos");

        JPanel panel = new JPanel(new GridLayout(4, 3,8, 4));


        for(int i=1;i<=10;i++){
            JButton button = new JButton("Aceptar ".concat(String.valueOf(i)));
            button.addActionListener(e -> System.out.println("Botón pulsado"));
            button.addActionListener(this);
            button.addActionListener(new ButtonClicListener());
            button.setSize(200,100);
            //button.setPreferredSize(new Dimension(200,100));
            panel.add(button);
        }

        setContentPane(panel);
        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Botón pulsado2");
    }

    public static void main(String[] args) {
        new Window03GridLayout();


    }

    private static class ButtonClicListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Botón pulsado3");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}