package fr.miniprojet3.miniprojet3;

import fr.miniprojet3.miniprojet3.controller.CarteController;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import fr.miniprojet3.miniprojet3.vue.CarteVue;
import fr.miniprojet3.miniprojet3.vue.GrilleCarteVue;
import fr.miniprojet3.miniprojet3.vue.SelecteurDifficulteVue;
import javafx.application.Application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {


    private SimpleStringProperty path;

    private CarteController carteController1;
    private CarteController carteController2;

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
        Button button3 = new Button("Chemin des images");
        button3.setOnAction(event ->{
            DirectoryChooser directoryChooser = new DirectoryChooser();
            // Affiche le dialogue de sélection de dossier
            File selectedDirectory = directoryChooser.showDialog(stage);
            this.path.set(selectedDirectory.getAbsolutePath());
        });
        buttonBox.getChildren().add(button3);

        borderPane.setTop(buttonBox);
        GridPane gridPane;

         gridPane = new GrilleCarteVue();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        ObservableList<Carte> cartesCliques = FXCollections.observableArrayList(new ArrayList<Carte>());



        // Ajoutez un ListChangeListener à la liste pour détecter les changements
        cartesCliques.addListener((ListChangeListener<Carte>) change -> {

            if (cartesCliques.size() == 2) {
                Carte carte1 = cartesCliques.get(0);
                Carte carte2 = cartesCliques.get(1);

                CarteVue carteVue1 = ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte1).getCarteVue();
                CarteVue carteVue2 = ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte2).getCarteVue();

                if (carte1.equals(carte2)) {
                    // les deux cartes sont identiques, traitement à effectuer

                    ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte1).remouve();

                    ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte2).remouve();

                    System.out.println("identique ETAPE2");


                } else  if(!carte1.equals(carte2)){
                    // les deux cartes sont différentes, traitement à effectuer
                    ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte1).dosCarte(carteVue1);
                    System.out.println(carte1.toString()+carte2.toString());
                    ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte2).dosCarte(carteVue2);
                    System.out.println("Pas identique");



                }
                cartesCliques.removeAll(carte1,carte2);
            }
        });

        EventHandler<MouseEvent> eventHandler = event -> {
            CarteVue carteCliquee = (CarteVue) event.getSource();
            System.out.println("Etape1");
            cartesCliques.add(carteCliquee.getCarte());
        };

        for (int i = 0; i < gridPane.getChildren().size(); i++) {
            CarteVue carteVue = (CarteVue) gridPane.getChildren().get(i);
            Carte carte = carteVue.getCarte();
            carteVue.addEventHandler(MouseEvent.MOUSE_PRESSED, eventHandler);
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
