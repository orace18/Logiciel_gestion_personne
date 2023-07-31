package io.artcreativity.swing;

import io.artcreativity.dao.Personne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListePersonnePanel extends JPanel {

    private JFrame frame;
    private TableModel tableModel;
    private List<Personne> personnes = new ArrayList<>();
    public ListePersonnePanel(JFrame frame) {
        super();
        this.frame = frame;
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        loadPersonnes();
        init();
    }

    private void init() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addBtn = new JButton("Ajouter");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "Ajouter de personne", true);
                PersonnePanel personnePanel = new PersonnePanel(new Callback() {
                    @Override
                    public void callback(Object object) {
                        dialog.setVisible(false);
                    }
                });
                JScrollPane scrollPane = new JScrollPane();
                JViewport viewport = new JViewport();
                viewport.setView(personnePanel);
                scrollPane.setViewportView(viewport);
                dialog.setContentPane(scrollPane);
                dialog.pack();
                dialog.setSize(400, 400);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
        panel.add(addBtn);
        panel.setBorder(new EmptyBorder(16, 16, 16, 15));
        this.add(panel);
        buildTable();
    }

    private void buildTable() {
        String[] columns = new String[]{"ID",
        "Nom", "Prenoms", "Adresse", "Telephone", "Age"};
        JTable table = new JTable(convertPersonne(), columns);
//        table.setColumnModel(new DefaultTableColumnModel());
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(table, BorderLayout.CENTER);
        this.add(panel);
    }

    private String[][] convertPersonne() {

        String[][] pp = new String[personnes.size()][6];
        for (int i=0; i<personnes.size(); i++) {
            Personne p = personnes.get(i);
            String[] toStr = new String[6];
            toStr[0] = "" + p.getId();
            toStr[1] = p.getNom();
            toStr[2] = p.getPrenoms();
            toStr[3] = p.getAdresse();
            toStr[4] = p.getTel();
            toStr[5] = p.getAge() + "";
            pp[i] = toStr;
        }

        return pp;
    }

    private void loadPersonnes() {
        Personne p= new Personne();
        p.setId(1);
        p.setNom("TOTO");
        p.setPrenoms("Tata");
        p.setAdresse("Lokossa");
        p.setTel("90909090");
        p.setAge(26);
        personnes.add(p);
    }
}
