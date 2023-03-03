package fr.miniprojet3.miniprojet3.vue;

import fr.miniprojet3.miniprojet3.controller.CarteController;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.util.*;

public class GrilleCarteVue extends GridPane {
    private Integer carteColonne;
    private Integer carteLigne;

    private CarteVue carteVue;
    private Carte carte;

    /**
     * @Author : Julien ADAMI
     * Map qui contient les cartes et le controlleur lié à la carte
     */
    private Map<Carte, CarteController> carteControllerMap = new HashMap<>();

    /**
     * @Author : Julien ADAMI
     * Constructeur de la classe GrilleCarteVue qui appelle la méthode d'init de la grille de carte
     * @param carteColonne
     * @param carteLigne
     */
    public GrilleCarteVue(Integer carteColonne, Integer carteLigne) {
        this.carteColonne = carteColonne;
        this.carteLigne = carteLigne;

        initialiserGrilleCarte(carteColonne, carteLigne);

    }

    /**
     * @Author : Julien ADAMI
     * initalise la grille de carte ( nombre de carte en fonction de la difficulté)
     * et ajoute les cartes dans la grille
     * @param carteColonne
     * @param carteLigne
     */
    public void initialiserGrilleCarte(Integer carteColonne, Integer carteLigne) {

        System.out.println(carteColonne+ " "+carteLigne);
        for (int i = 0; i < carteColonne; i++) {
            for (int j = 0; j < carteLigne; j++) {
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
