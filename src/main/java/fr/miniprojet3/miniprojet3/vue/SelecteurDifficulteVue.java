package fr.miniprojet3.miniprojet3.vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class SelecteurDifficulteVue extends HBox {

    private IntegerProperty nombreLigne = new SimpleIntegerProperty(2);
    private IntegerProperty nombreColonne = new SimpleIntegerProperty(2);

    public SelecteurDifficulteVue() {
        initialiserSelecteurDifficulte();
        this.setSpacing(10);

    }

    /**
     * @Author: Julien ADAMI
     * Méthode qui initalise 3 boutons avec 3 difficultés
     * et leur setOnAction qui permet de changer la valeur des propriétés nombreLigne et nombreColonne
     * qui sont ajoutés à la Hbox
     */
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
