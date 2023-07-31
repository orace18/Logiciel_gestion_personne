package io.artcreativity.swing;

import javax.swing.*;

public class SwingTest {

    public static void main(String[] args) {

        JFrame maFenetre = new JFrame();
        maFenetre.setTitle("Ma fenetre");
        ListePersonnePanel personnePanel = new ListePersonnePanel(maFenetre);
        JScrollPane scrollPane = new JScrollPane();
        JViewport viewport = new JViewport();
        viewport.setView(personnePanel);
        scrollPane.setViewportView(viewport);
        maFenetre.setContentPane(scrollPane);
        maFenetre.pack();
        maFenetre.setSize(400, 600);
        maFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setVisible(true);
    }
}
