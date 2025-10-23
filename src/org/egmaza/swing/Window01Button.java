package org.egmaza.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window01Button extends JFrame implements ActionListener{

    public Window01Button(){
        super("Ejemplo de Botón y eventos");

        JButton button = new JButton("Aceptar");
        button.setSize(100,50);
        button.addActionListener(e -> System.out.println("Botón pulsado"));
        button.addActionListener(this);
        button.addActionListener(new ButtonClicListener());
        getContentPane().add(button);
        setSize(200, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Botón pulsado2");
    }

    public static void main(String[] args) {
        new Window01Button();


    }

    private static class ButtonClicListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Botón pulsado3");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}