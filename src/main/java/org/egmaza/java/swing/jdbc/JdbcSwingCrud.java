package org.egmaza.java.swing.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JdbcSwingCrud extends JFrame {

    private Container c;
    private JTextField nameField = new JTextField();
    private JTextField priceField = new JTextField();
    private JTextField quantityField = new JTextField();

    public JdbcSwingCrud() throws HeadlessException {
        super("Swing: GUI con Base de Datos MySQL");

        c = getContentPane();
        c.setLayout(new BorderLayout(20, 10));

        JPanel formPanel = new JPanel(new GridLayout(4,2,20,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JButton buttonSave = new JButton("Guardar");

        formPanel.add(new JLabel("Nombre: "));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Precio: "));
        formPanel.add(priceField);

        formPanel.add(new JLabel("Cantidad: "));
        formPanel.add(quantityField);

        formPanel.add(new JLabel(""));
        formPanel.add(buttonSave);
        buttonSave.addActionListener(new AddActionListener());

        c.add(formPanel, BorderLayout.WEST);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JdbcSwingCrud();
    }

    private class AddActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int price = Integer.parseInt(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Object[] product = new Object[]{name, price, quantity};

            System.out.println(product[0]);
            System.out.println(product[1]);
            System.out.println(product[2]);
        }
    }
}