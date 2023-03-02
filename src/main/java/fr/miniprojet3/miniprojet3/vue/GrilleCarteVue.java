package fr.miniprojet3.miniprojet3.vue;

import fr.miniprojet3.miniprojet3.controller.CarteController;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.util.*;

public class GrilleCarteVue extends GridPane {

    private CarteVue carteVue;
    private Carte carte;
    private Map<Carte, CarteController> carteControllerMap = new HashMap<>();

    public GrilleCarteVue() {
        super();
        initialiserGrilleCarte();
    }


    public void initialiserGrilleCarte(){


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(i==0){
                    carte = new Carte("file:src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte/faceDePoulpe.jpg");

                }else {
                    carte = new Carte("file:src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte/index.jpg");

                }
                carteVue = new CarteVue(carte);
                CarteController carteController = new CarteController(carte,carteVue);
                carteVue.setOnMouseClicked(event -> {
                    carteController.onCarteClick();
                });
                carteControllerMap.put(carte, carteController);
                this.add(carteVue, i, j);
            }
        }



    }

    @FXML
    public Map<Carte, CarteController> getCarteControllerMap() {
        return carteControllerMap;
    }



}
