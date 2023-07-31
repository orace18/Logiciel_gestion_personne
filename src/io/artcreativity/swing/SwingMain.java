package io.artcreativity.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMain {

    public static void main(String[] args) {
        JFrame maFenetre = new JFrame("Me premier fenetre");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Hello World"));

        JButton button = new JButton("Cliquez ici");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clique OK");
            }
        });
        panel.add(button);

        maFenetre.setContentPane(panel);
        maFenetre.pack();
        maFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
