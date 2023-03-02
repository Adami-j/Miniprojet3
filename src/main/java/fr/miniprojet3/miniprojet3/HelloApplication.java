package fr.miniprojet3.miniprojet3;

import fr.miniprojet3.miniprojet3.controller.CarteController;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import fr.miniprojet3.miniprojet3.vue.CarteVue;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                carte = new Carte("file:src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte/faceDePoulpe.jpg");


                carteVue = new CarteVue(carte);
                CarteController carteController = new CarteController(carte,carteVue);
                carteVue.setOnMouseClicked(event -> {
                    carteController.onCarteClick();
                });

                gridPane.add(carteVue, i, j);
            }
        }

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