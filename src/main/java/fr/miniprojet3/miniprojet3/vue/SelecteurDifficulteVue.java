package fr.miniprojet3.miniprojet3.vue;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class SelecteurDifficulteVue extends HBox {

    private StringProperty nombreLigne = new SimpleStringProperty();
    private StringProperty nombreColonne = new SimpleStringProperty();

    public SelecteurDifficulteVue() {
      initialiserSelecteurDifficulte();
      this.setSpacing(10);

    }

    public void initialiserSelecteurDifficulte(){
        Button button = new Button("Facile");
        Button button1 = new Button("Moyen");
        Button button2 = new Button("Difficile");
        Button button3 = new Button("Charger des images");

        button1.setOnAction(event -> {
            button.setTextFill(Color.BLACK);
            button1.setTextFill(Color.GREEN);
            button2.setTextFill(Color.BLACK);
            nombreLigne.set("4");
            nombreColonne.set("4");
            System.out.println(nombreColonne.get());

        });
        button2.setOnAction(event -> {
            button.setTextFill(Color.BLACK);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.GREEN);
            nombreLigne.set("6");
            nombreColonne.set("6");

        });
        button.setOnAction(event -> {

            button.setTextFill(Color.GREEN);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.BLACK);
            nombreLigne.set("2");
            nombreColonne.set("2");
        });


        this.getChildren().add(button);
        this.getChildren().add(button1);
        this.getChildren().add(button2);
        }

    public String getNombreLigne() {
        return nombreLigne.get();
    }

    public StringProperty nombreLigneProperty() {
        return nombreLigne;
    }

    public void setNombreLigne(String nombreLigne) {
        this.nombreLigne.set(nombreLigne);
    }

    public String getNombreColonne() {
        return nombreColonne.get();
    }

    public StringProperty nombreColonneProperty() {
        return nombreColonne;
    }

    public void setNombreColonne(String nombreColonne) {
        this.nombreColonne.set(nombreColonne);
    }
}
