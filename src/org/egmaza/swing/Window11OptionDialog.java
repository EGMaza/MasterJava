package org.egmaza.swing;

import javax.swing.*;
import java.awt.*;

public class Window11OptionDialog extends JFrame {

    Container c;

    public Window11OptionDialog() throws HeadlessException {
        super("Ventana de dialogo con opciones");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        Object[] options = {"SI", "NO", "Quizas mas tarde", "Cancelar"};
        int value = JOptionPane.showOptionDialog(
                null,
                "Desea continuar?",
                "Confirmar alguna opción",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        System.out.println("Opcion seleccionada: " + value);
        setSize(200,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Window11OptionDialog();
    }
}