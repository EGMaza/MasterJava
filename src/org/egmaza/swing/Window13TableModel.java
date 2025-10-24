package org.egmaza.swing;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class Window13TableModel extends JFrame {

    JPanel panel = new JPanel();
    public Window13TableModel() throws HeadlessException {
        super("Tabla con registros o Grilla");

        JTable table = new JTable(new UserTableModel());
        JScrollPane scroll = new JScrollPane(table);
        panel.add(scroll);
        getContentPane().add(panel);
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new Window13TableModel();
    }

    private static class UserTableModel extends AbstractTableModel {

        private String[] columns = {"Id", "Name", "Lastname", "Email"};
        private Object[][] rows;

        public UserTableModel() {
            this.rows = new Object[5][4];
            rows[0] = new Object[]{1, "Eduardo", "González", "egonzalez@correo.com"};
            rows[1] = new Object[]{2, "Pepe", "Doe", "pdoe@correo.com"};
            rows[2] = new Object[]{3, "Ana", "Roe", "aroe@correo.com"};
            rows[3] = new Object[]{4, "James", "Gosling", "jgosling@correo.com"};
            rows[4] = new Object[]{5, "Bruce", "Gao",  "bgao@correo.com"};


        }

        @Override
        public int getRowCount() {
            return rows.length;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rows[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }
    }
}
