package org.egmaza.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Window09Calculator2 extends JFrame implements ActionListener {

    Container container;
    String total = "";
    String operation = "";
    int  aux;
    JLabel result;
    JLabel view;

    public Window09Calculator2() throws HeadlessException {
        super("Ejemplo Calculadora");
        container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));
        JPanel panelTop = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel panelCenter = new JPanel(new GridLayout(5,3,5,5));
        JPanel panelRight = new JPanel(new GridLayout(5,1,5,5));

        container.add(panelTop, BorderLayout.NORTH);
        container.add(panelCenter, BorderLayout.CENTER);
        container.add(panelRight, BorderLayout.EAST);

        panelTop.add(this.view = new JLabel("", SwingConstants.RIGHT));
        panelTop.add(this.result = new JLabel("0", SwingConstants.RIGHT));
        view.setFont(new Font("Serif", Font.PLAIN, 16));
        result.setFont(new Font("Serif", Font.BOLD, 20));


        Border border = panelTop.getBorder();
        Border margin = new EmptyBorder(10,10,10,10);
        panelTop.setBorder(new CompoundBorder(border, margin));

        JButton buttonAC = new JButton("AC");
        JButton buttonAdd = new JButton("+");
        JButton buttonSus = new JButton("-");
        JButton buttonDiv = new JButton("/");
        JButton buttonMult = new JButton("*");
        JButton buttonEquals = new JButton("=");

        panelCenter.add(buttonAC);
        panelCenter.add(new JLabel());
        panelCenter.add(new JLabel());

        for(int i = 9; i>=0; i--){
            if(i == 0){
                panelCenter.add(new JLabel());
            }
            JButton button = new JButton(String.valueOf(i));
            panelCenter.add(button);
            button.addActionListener( event ->{
                String value  = event.getActionCommand();
                total += value;
                this.view.setText(view.getText().concat(value));
            });

        }

        panelRight.add(buttonAdd);
        panelRight.add(buttonSus);
        panelRight.add(buttonDiv);
        panelRight.add(buttonMult);
        panelRight.add(buttonEquals);

        buttonAdd.addActionListener(this);
        buttonSus.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonMult.addActionListener(this);
        buttonEquals.addActionListener(event ->{
            int value = 0;
            int numeroA = this.aux;
            int numeroB = Integer.parseInt(this.total);

            value = switch (this.operation) {
                case "+" -> numeroA + numeroB;
                case "-" -> numeroA - numeroB;
                case "*" -> numeroA * numeroB;
                case "/" -> numeroA / numeroB;
                default -> value;
            };
            this.total = String.valueOf(value);
            this.result.setText(this.total);
        });
        buttonAC.addActionListener( event ->{
            this.total = "";
            this.operation = "";
            this.aux = 0;
            this.view.setText("");
            this.result.setText("0");
        });


        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new Window09Calculator2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.operation = e.getActionCommand();
        if(total.isEmpty()){
            total = "0";
        }
        this.aux = Integer.parseInt(this.total);
        this.total = "";
        this.view.setText(this.view.getText().concat(operation));

    }
}
