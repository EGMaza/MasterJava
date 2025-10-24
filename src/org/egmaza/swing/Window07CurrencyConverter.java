package org.egmaza.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window07CurrencyConverter extends JFrame implements ActionListener {

    Container  panel;
    JButton buttonEu, buttonUsd, buttonReset;
    JTextField mount;

    public static final String CURRENCY_DOLAR = "Dolar";
    public static final String CURRENCY_EUROS = "Euros";

    public Window07CurrencyConverter() throws HeadlessException {
        super("Conversor de monedas");
        panel = getContentPane();
        panel.setLayout(new FlowLayout());
        mount = new JTextField(10);
        buttonEu = new JButton(CURRENCY_EUROS);
        buttonEu.addActionListener(this);
        buttonUsd = new JButton(CURRENCY_DOLAR);
        buttonUsd.addActionListener(this);
        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(this);
        panel.add(mount);
        panel.add(buttonEu);
        panel.add(buttonUsd);
        panel.add(buttonReset);
        setSize(300,250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float value = Float.parseFloat(mount.getText());
        String textCurrency = e.getActionCommand();
        if(textCurrency.equalsIgnoreCase(CURRENCY_EUROS)){
            value = value/21.38f;
            panel.setBackground(Color.green);
            mount.setText(String.valueOf(value));
        }
        else if(textCurrency.equalsIgnoreCase(CURRENCY_DOLAR)){
            value = (float)(value/18.40);
            panel.setBackground(Color.blue);
            mount.setText(String.valueOf(value));
        }
        else{
            value = 0;
            panel.setBackground(Color.white);
            mount.setText("");
        }

    }

    public static void main(String[] args) {
        new Window07CurrencyConverter();
    }
}