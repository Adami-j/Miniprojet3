package fr.miniprojet3.miniprojet3.vue;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class SelecteurDifficulteVue extends HBox {





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

        });
        button2.setOnAction(event -> {
            button.setTextFill(Color.BLACK);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.GREEN);

        });
        button.setOnAction(event -> {

            button.setTextFill(Color.GREEN);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.BLACK);
        });


        this.getChildren().add(button);
        this.getChildren().add(button1);
        this.getChildren().add(button2);
        }
}
