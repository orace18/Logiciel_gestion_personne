package io.artcreativity.swing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MaFenetre extends JFrame {

    public MaFenetre() {
        this.setContentPane(makeBorder());
        this.pack();
    }

    private JPanel makeBorder() {
        JPanel monPanel = new JPanel(new BorderLayout());

        JLabel geiLabel = new JLabel("Salut GEI-IT");
        Font geiFont = new Font("Courier New", Font.BOLD, 30);
        geiLabel.setFont(geiFont);
        geiLabel.setForeground(Color.CYAN);
        monPanel.add(geiLabel, BorderLayout.NORTH);

        JLabel pooLabel = new JLabel("POO Java");
        monPanel.add(pooLabel, BorderLayout.SOUTH);

        monPanel.add(makeFlow(), BorderLayout.WEST);

        monPanel.add(makeGrid(), BorderLayout.CENTER);

        monPanel.add(makeBox(), BorderLayout.EAST);
        return monPanel;
    }

    private JPanel makeFlow() {
        JPanel panelFlow = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("Texte 1");
        label1.getInsets(new Insets(16, 16, 16, 16));
        panelFlow.add(label1);

        JLabel label2 = new JLabel("Texte 2");
        label2.getInsets(new Insets(16, 16, 16, 16));
        panelFlow.add(label2);

        JLabel label3 = new JLabel("Texte 3");
        label3.getInsets(new Insets(16, 16, 16, 16));
        panelFlow.add(label3);

        JLabel label4 = new JLabel("Texte 4");
        label4.getInsets(new Insets(16, 16, 16, 16));
        panelFlow.add(label4);

        JLabel label5 = new JLabel("Texte 5");
        label5.getInsets(new Insets(16, 16, 16, 16));
        panelFlow.add(label5);

        panelFlow.setMinimumSize(new Dimension(200, 200));
        return panelFlow;
    }

    private JPanel makeGrid() {
        JPanel panel = new JPanel();

        panel.add(new JLabel("Grid 11"));
        panel.add(new JLabel("Grid 12"));
        panel.add(new JLabel("Grid 13"));
        panel.add(new JLabel("Grid 14"));
        panel.add(new JLabel("Grid 21"));
        panel.add(new JLabel("Grid 22"));
        panel.add(new JLabel("Grid 23"));
        panel.add(new JLabel("Grid 24"));
        panel.add(new JLabel("Grid 30"));

        panel.setLayout(new GridLayout(4, 4, 20, 20));
        panel.setMinimumSize(new Dimension(200, 200));
        return panel;
    }

    private JPanel makeBox() {
        JPanel panelBox = new JPanel();
        BoxLayout box = new BoxLayout(panelBox, BoxLayout.Y_AXIS);
        panelBox.setLayout(box);

        panelBox.add(new JLabel("BoxLine 11"));
        panelBox.add(new JLabel("BoxLine 12"));
        panelBox.add(new JLabel("BoxLine 13"));
        panelBox.add(new JLabel("BoxLine 14"));
        panelBox.add(new JLabel("BoxLine 21"));
        panelBox.add(new JLabel("BoxLine 22"));
        panelBox.add(new JLabel("BoxLine 23"));
        panelBox.add(new JLabel("BoxLine 24"));
        JLabel label1 = new JLabel("<html><boby style='padding:16px; !important'>Texte 1</body></html>");
//        label1.getInsets(new Insets(16, 16, 16, 16));
        JPanel panelFlow = new JPanel(new FlowLayout());
//        panelFlow.add(label1);
        panelBox.add(label1);

        panelBox.getInsets(new Insets(32, 32, 32, 32));
        panelBox.setBorder(new TitledBorder("Box Panel"));
        return panelBox;
    }
}
