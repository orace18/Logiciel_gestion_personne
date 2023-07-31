package io.artcreativity.swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class PersonnePanel extends JPanel implements ActionListener{

    static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private JPanel panelEnregistrement;
    private JTextField nomField;
    private JTextField prenomsField;
    private JTextField adresseField;
    private JTextField telField;
    private JComboBox<Integer> ageBox;
    private final Callback callback;
    public PersonnePanel(Callback callback) {
        super(new BorderLayout());
        this.callback = callback;
        setBorder(new EmptyBorder(10, 10, 10, 10));
        init();
        this.setMinimumSize(new Dimension(300, 300));
        this.setSize(new Dimension(300, 300));
        add(panelEnregistrement, BorderLayout.CENTER);
    }

    private void init() {
        panelEnregistrement = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelEnregistrement, BoxLayout.Y_AXIS);
        panelEnregistrement.setLayout(boxLayout);
        panelEnregistrement.getInsets(new Insets(32, 32, 32, 32));
        TitledBorder border = new TitledBorder(new LineBorder(Color.GREEN), "Formulaire");
        border.getBorderInsets(panelEnregistrement, new Insets(32, 32, 32, 32));
        panelEnregistrement.setBorder(border);

        // Form to nom
        nomField = buildTextFormAndAddToPanel(panelEnregistrement, "Nom");
        prenomsField = buildTextFormAndAddToPanel(panelEnregistrement, "Prenoms");
        adresseField = buildTextFormAndAddToPanel(panelEnregistrement, "Adresse");
        telField = buildTextFormAndAddToPanel(panelEnregistrement, "Telephone");
//        nomField = buildTextFormAndAddToPanel(panelEnregistrement, "Nom");
        Integer[] data = new Integer[100];

        int j = 0;
        for (int i = currentYear; j<100; i--) {
            data[j] = i;
            j++;
        }
        ageBox = buildComboBoxAndAddToPanel(panelEnregistrement,
                "Annee de naissance", data);

        JButton button = new JButton("Enregistrer");
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelButton.add(button);
        panelEnregistrement.add(panelButton);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button.addActionListener(this);
    }

    private JTextField buildTextFormAndAddToPanel(JPanel panel, String labelName) {
        JPanel panelGrid = new JPanel(new GridLayout(2,1));
        JLabel label = new JLabel(labelName);
        label.getInsets(new Insets(8, 16, 8, 16));
        JTextField textField = new JTextField();
        textField.getInsets(new Insets(0, 16, 8, 16));
        panelGrid.add(label);
        panelGrid.add(textField);
        panel.add(panelGrid);

        return textField;
    }

    private <T> JComboBox<T> buildComboBoxAndAddToPanel(JPanel panel,
                                                        String labelName,
                                                        T[] data) {
        JPanel panelGrid = new JPanel(new GridLayout(2,1));
        JLabel label = new JLabel(labelName);
        label.getInsets(new Insets(8, 16, 8, 16));
        JComboBox<T> comboBox = new JComboBox<T>(data);
        comboBox.getInsets(new Insets(0, 16, 8, 16));
        panelGrid.add(label);
        panelGrid.add(comboBox);
        panel.add(panelGrid);

        return comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lastname = nomField.getText();
        String firstname = prenomsField.getText();
        String address = adresseField.getText();
        String phoneNumber = telField.getText();
        Integer birthYear = (Integer) ageBox.getModel().getSelectedItem();
        int age = birthYear==null ? 0 : currentYear-birthYear;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nom : ");
        stringBuilder.append(lastname);
        stringBuilder.append("\n");
        stringBuilder.append("Prenoms : ");
        stringBuilder.append(firstname);
        stringBuilder.append("\n");
        stringBuilder.append("Adresse : ");
        stringBuilder.append(address);
        stringBuilder.append("\n");
        stringBuilder.append("Telephone : ");
        stringBuilder.append(phoneNumber);
        stringBuilder.append("\n");
        stringBuilder.append("Age : ");
        stringBuilder.append(age);
        System.out.println(stringBuilder);
        // TODO: 29/03/2023 Build Person and persist into database

        this.callback.callback(true);
    }
}
