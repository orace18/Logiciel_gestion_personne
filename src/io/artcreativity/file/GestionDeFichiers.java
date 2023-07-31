package io.artcreativity.file;

import io.artcreativity.exceptions.MyException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class GestionDeFichiers {

    public String lecture(String cheminDuFichier) throws MyException {
        StringBuilder contenu = new StringBuilder();

        File monFichier = new File(cheminDuFichier);
        try {
            FileInputStream inputStream = new FileInputStream(monFichier);
            int c;
            byte[] reader = new byte[1024];
            while((c=inputStream.read(reader))>-1) {
                contenu.append(new String(reader, StandardCharsets.UTF_8));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new MyException("Le fichier : " + monFichier.getName() + " n'existe pas.");
        } catch (IOException e) {
            throw new MyException("Impossible d'acceder au contenu du fichier : " + monFichier.getName() + ".");
        }

        return contenu.toString();
    }

    public void ecriture(String cheminDuFichier, String contenu) throws MyException {
        File monFichier = new File(cheminDuFichier);

        try {
            FileOutputStream outputStream = new FileOutputStream(monFichier);
            outputStream.write(contenu.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new MyException("Le fichier : " + monFichier.getName() + " n'existe pas.");
        } catch (IOException e) {
            throw new MyException("Impossible d'ecrire le contenu dans le fichier : " + monFichier.getName() + ".");
        }
    }
}
