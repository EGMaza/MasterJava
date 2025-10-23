package org.egmaza.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window06Counter extends JFrame implements ActionListener {

    private int counter;
    private JButton button = new JButton("Count");
    private JButton buttonDecrement = new JButton("Decrement");
    private JLabel result = new JLabel("Counter: 0");

    public Window06Counter() throws HeadlessException {
        super("Ejemplo contador");

        Container panel = getContentPane();
        panel.add(button);
        panel.add(result);
        panel.add(buttonDecrement);
        panel.setLayout(new FlowLayout());
        button.addActionListener(this);
        buttonDecrement.addActionListener(event ->{
            counter--;
            result.setText("Counter: ".concat(String.valueOf(counter)));
        });
        setVisible(true);
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new Window06Counter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        result.setText("Counter: ".concat(String.valueOf(counter)));

    }
}
