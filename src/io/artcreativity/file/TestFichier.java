package io.artcreativity.file;

import io.artcreativity.exceptions.MyException;

public class TestFichier {

    public static void main(String[] args) {
        GestionDeFichiers gestionDeFichiers = new GestionDeFichiers();
        String contenu = null;
        try {
            contenu = gestionDeFichiers.lecture("/Users/zgera/IdeaProjects/PriseEnMain/src/lorem.txt");
            System.out.println(contenu);
            contenu += "\nFin";
            gestionDeFichiers.ecriture("/Users/zgera/IdeaProjects/PriseEnMain/src/lorem2.txt", contenu);
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }


    }
}
