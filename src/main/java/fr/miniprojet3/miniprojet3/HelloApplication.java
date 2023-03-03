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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {


    private SimpleStringProperty path;

    private int carteColonne;
    private int carteLigne;
    private int nombreCarte;
    private GridPane gridPane;
    private Label score;
    private Label temps;
    private int scoreInt;


    @Override
    public void init() throws Exception {

    }

    /**
     * @Author : Julien ADAMI
     * @param stage
     * méthode qui fait office de vue principale
     * Ajoute les boutons
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        score = new Label("Score : 0");
        temps = new Label("Temps : 0");
        //initialisation de la fenetre
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(controlleur->{
            return new HelloController();
        });

        BorderPane borderPane = fxmlLoader.load();
        AtomicReference<AtomicReference<Label>> label = null;


        //ajout de la hbox qui contient les boutons de selection de difficultés
        HBox buttonBox = new SelecteurDifficulteVue();
        Button button3 = new Button("Chemin des images");
        button3.setOnAction(event ->{
            DirectoryChooser directoryChooser = new DirectoryChooser();
            // Affiche la boite de sélection d'un fichier
            File selectedDirectory = directoryChooser.showDialog(stage);
            this.path.set(selectedDirectory.getAbsolutePath());

        });

        buttonBox.getChildren().add(button3);

        borderPane.setTop(buttonBox);
        AtomicInteger nombreColonne = new AtomicInteger(((SelecteurDifficulteVue) buttonBox).nombreColonneProperty().getValue());
        AtomicInteger nombreLigne = new AtomicInteger(((SelecteurDifficulteVue) buttonBox).nombreLigneProperty().getValue());

        gridPane = new GrilleCarteVue(nombreColonne.get(), nombreLigne.get());

        ObservableList<Carte> cartesCliques = FXCollections.observableArrayList(new ArrayList<Carte>());
        HBox hBox = new HBox();

        Button restart = new Button("Restart");
        carteColonne = nombreColonne.get();
        carteLigne = nombreLigne.get();
        restart.setOnAction(event ->{
            nombreColonne.set(((SelecteurDifficulteVue) buttonBox).nombreColonneProperty().getValue());
            nombreLigne.set(((SelecteurDifficulteVue) buttonBox).nombreLigneProperty().getValue());
            gridPane.getChildren().clear();
            gridPane = new GrilleCarteVue(nombreColonne.get(), nombreLigne.get());
            gridPane.setVgap(10);
            gridPane.setHgap(10);
            cartesCliques.clear();
            borderPane.setCenter(gridPane);
        });

        nombreCarte=carteColonne*carteLigne;
        hBox.getChildren().add(score);
        hBox.getChildren().add(temps);
        hBox.getChildren().add(restart);

        borderPane.setBottom(hBox);


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

            cartesCliques.addListener((ListChangeListener<Carte>) change -> {

                if (cartesCliques.size() == 3) {
                    Carte carte1 = cartesCliques.get(0);
                    Carte carte2 = cartesCliques.get(1);
                    Carte carte3 = cartesCliques.get(2);
                    CarteController carteController1 = ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte1);
                    CarteController carteController2 = ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte2);
                    CarteController carteController3 = ((GrilleCarteVue) gridPane).getCarteControllerMap().get(carte3);

                    CarteVue carteVue1 = carteController1.getCarteVue();
                    CarteVue carteVue2 = carteController2.getCarteVue();
                    CarteVue carteVue3 = carteController3.getCarteVue();

                   ;
                    carteController1.setEstEnCoursDeJeu(true);
                    carteController2.setEstEnCoursDeJeu(true);
                    if (carte1.equals(carte2)&& carte1.hashCode() != carte2.hashCode() && carte3!=null) {
                        // les deux cartes sont identiques, traitement à effectuer
                        carteController1.retournerCarte(carteVue2);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        carteController1.remouve();

                        carteController2.remouve();
                        System.out.println(nombreCarte);
                        nombreCarte-=2;
                        System.out.println(nombreCarte);
                        System.out.println("identique ETAPE2");
                        if(nombreCarte<=0){
                            stage.close();
                        }
                    scoreInt+=2;

                    } else  if(!carte1.equals(carte2)){
                        // les deux cartes sont différentes, traitement à effectuer
                        System.out.println("Pas identique"+ carte1.toString()+carte2.toString()+"\n");
                        carteController1.dosCarte(carteVue1);
                        carteController1.dosCarte(carteVue2);
                        System.out.println("Pas identique"+ carte1.toString()+carte2.toString()+"\n");
                        scoreInt-=2;
                    }else {
                        carteController1.dosCarte(carteVue1);
                       carteController2.dosCarte(carteVue2);
                    }
                    carteController1.setEstEnCoursDeJeu(false);
                    carteController2.setEstEnCoursDeJeu(false);
                    cartesCliques.removeAll(carte1,carte2);

                }
            });

        // Ajoutez un ListChangeListener à la liste pour détecter les changements



        borderPane.setCenter(gridPane);
        // Create the scene
        Scene scene = new Scene(borderPane);

        // Set the stage
        stage.setScene(scene);
        stage.setTitle("Memory Game");
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}
