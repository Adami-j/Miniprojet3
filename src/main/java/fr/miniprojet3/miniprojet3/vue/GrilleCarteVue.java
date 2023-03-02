package fr.miniprojet3.miniprojet3.vue;

import fr.miniprojet3.miniprojet3.controller.CarteController;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import javafx.scene.layout.GridPane;

public class GrilleCarteVue extends GridPane {

    private CarteVue carteVue;
    private Carte carte;

    public GrilleCarteVue() {
        super();
        initialiserGrilleCarte();
    }

    public void initialiserGrilleCarte(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                carte = new Carte("file:src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte/faceDePoulpe.jpg");


                carteVue = new CarteVue(carte);
                CarteController carteController = new CarteController(carte,carteVue);
                carteVue.setOnMouseClicked(event -> {
                    carteController.onCarteClick();
                });

                this.add(carteVue, i, j);
            }
        }
    }


}
