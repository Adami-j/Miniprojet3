package fr.miniprojet3.miniprojet3.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class SelecteurDifficulteVue extends HBox {

    private IntegerProperty nombreLigne = new SimpleIntegerProperty(3);
    private IntegerProperty nombreColonne = new SimpleIntegerProperty(3);


    public SelecteurDifficulteVue() {
        initialiserSelecteurDifficulte();
        this.setSpacing(10);

    }

    public void initialiserSelecteurDifficulte() {
        Button button = new Button("Facile");
        Button button1 = new Button("Moyen");
        Button button2 = new Button("Difficile");


        button1.setOnAction(event -> {
            button.setTextFill(Color.BLACK);
            button1.setTextFill(Color.GREEN);
            button2.setTextFill(Color.BLACK);
            nombreLigne.set(3);
            nombreColonne.set(3);
        });
        button2.setOnAction(event -> {
            button.setTextFill(Color.BLACK);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.GREEN);
            nombreLigne.set(4);
            nombreColonne.set(4);
        });
        button.setOnAction(event -> {

            button.setTextFill(Color.GREEN);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.BLACK);
            nombreLigne.set(2);
            nombreColonne.set(2);
        });


        this.getChildren().add(button);
        this.getChildren().add(button1);
        this.getChildren().add(button2);
    }

    public int getNombreLigne() {
        return nombreLigne.get();
    }

    public IntegerProperty nombreLigneProperty() {
        return nombreLigne;
    }

    public void setNombreLigne(int nombreLigne) {
        this.nombreLigne.set(nombreLigne);
    }

    public int getNombreColonne() {
        return nombreColonne.get();
    }

    public IntegerProperty nombreColonneProperty() {
        return nombreColonne;
    }

    public void setNombreColonne(int nombreColonne) {
        this.nombreColonne.set(nombreColonne);
    }
}
