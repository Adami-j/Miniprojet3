package fr.miniprojet3.miniprojet3;

import javafx.beans.property.SimpleStringProperty;

import java.io.File;
import java.util.ArrayList;

public class RecupDossierUtil {

    private SimpleStringProperty path;

    public static ArrayList<String> getAllFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File directory = new File(path);
        // Vérifie si le chemin donné correspond à un répertoire
        if (directory.isDirectory()) {
            File[] listOfFiles = directory.listFiles();
            // Parcourt tous les fichiers du répertoire et ajoute leurs noms à la liste
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    files.add(file.getName());
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        String path = "src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte";
        ArrayList<String> files = getAllFiles(path);
        // Affiche le nom de tous les fichiers du répertoire
        for (String file : files) {
            System.out.println(file);
        }
    }



}
