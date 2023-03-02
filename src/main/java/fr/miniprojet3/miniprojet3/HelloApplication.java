package fr.miniprojet3.miniprojet3;

import fr.miniprojet3.miniprojet3.controller.CarteController;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import fr.miniprojet3.miniprojet3.vue.CarteVue;
import fr.miniprojet3.miniprojet3.vue.GrilleCarteVue;
import fr.miniprojet3.miniprojet3.vue.SelecteurDifficulteVue;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Carte carte;
    private CarteVue carteVue;

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(controlleur->{
            return new HelloController();
        });

        BorderPane borderPane = fxmlLoader.load();
        HBox buttonBox = new SelecteurDifficulteVue();

        borderPane.setTop(buttonBox);
        GridPane gridPane = new GrilleCarteVue();
        gridPane.setVgap(10);
        gridPane.setHgap(10);



        borderPane.setCenter(gridPane);
        // Create the scene
        Scene scene = new Scene(borderPane, 400, 400);
        // Set the stage
        stage.setScene(scene);
        stage.setTitle("Memory Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}