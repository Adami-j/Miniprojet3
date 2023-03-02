package fr.miniprojet3.miniprojet3.vue;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SelecteurDifficulteVue extends HBox {





    public SelecteurDifficulteVue() {
      initialiserSelecteurDifficulte();
      this.setSpacing(10);

    }

    public void initialiserSelecteurDifficulte(){
        Button button = new Button("Facile");
        Button button1 = new Button("Moyen");
        Button button2 = new Button("Difficile");
        button1.setOnAction(event -> {
            button.setTextFill(Color.BLACK);
            button1.setTextFill(Color.GREEN);
            button2.setTextFill(Color.BLACK);
            System.out.println("Moyen");
        });
        button2.setOnAction(event -> {
            button.setTextFill(Color.BLACK);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.GREEN);
            System.out.println("Difficile");
        });
        button.setOnAction(event -> {
            System.out.println("Facile");
            button.setTextFill(Color.GREEN);
            button1.setTextFill(Color.BLACK);
            button2.setTextFill(Color.BLACK);
        });
        this.getChildren().add(button);
        this.getChildren().add(button1);
        this.getChildren().add(button2);
        }
}
