package org.egmaza.swing;

import javax.swing.*;
import java.awt.*;

public class Window12ConfirmDialog extends JFrame {

    Container panel;

    public Window12ConfirmDialog() throws HeadlessException {
        super("Confirmar antes de ejecutar una tarea");

        panel = getContentPane();
        panel.setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,100);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 4, 4));

        JLabel name = new JLabel("Nombre: ", JLabel.RIGHT);
        JTextField nameField = new JTextField();
        formPanel.add(name);
        formPanel.add(nameField);

        JLabel lastname = new JLabel("Apellido: ", JLabel.RIGHT);
        JTextField lastnameField = new JTextField();
        formPanel.add(lastname);
        formPanel.add(lastnameField);

        JLabel taxNumber = new JLabel("RFC: ", JLabel.RIGHT);
        JTextField taxNumberField = new JTextField();
        formPanel.add(taxNumber);
        formPanel.add(taxNumberField);

        JRadioButton morning = new JRadioButton("Grupo mañana", true);
        JRadioButton afternoon = new JRadioButton("Grupo tarde");
        formPanel.add(morning);
        formPanel.add(afternoon);

        int option = JOptionPane.showConfirmDialog(
                this,
                formPanel,
                "Introduzca los datos",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        System.out.println("Opción seleccionada: " + option);
        if (option == JOptionPane.OK_OPTION) {
            String nameValue = nameField.getText();
            System.out.println("Has introducido " + nameValue);
            JOptionPane.showMessageDialog(
                    this,
                    "Ejecutado con éxito!",
                    "Alerta",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(
                    this,
                    "Se canceló la acción",
                    "Alerta",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Hemos seleccionado Cancelar");
        }
    }

    public static void main(String[] args) {
        new Window12ConfirmDialog();
    }
}