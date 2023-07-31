package io.artcreativity.swing;

import javax.swing.*;

public class PersonneWindows {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PersonneWindows");
        frame.setContentPane(new PersonneWindows().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
