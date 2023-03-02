package fr.miniprojet3.miniprojet3.vue;

import fr.miniprojet3.miniprojet3.controller.CarteController;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CarteVue extends ImageView {

    private Carte carte;
    private CarteController carteController;

    public void initialiserCarte(Image image){

    }

    public CarteVue(Carte carte, CarteController carteController) {
        this.carte = carte;
        this.carteController = new CarteController(carte);
        this.setImage(new Image("file:src/main/resources/fr/miniprojet3/miniprojet3/images/dos-carte-s10-hearthstone.jpg"));
        this.setFitWidth(70);
        this.setFitHeight(90);
        this.setOnMouseClicked(mouseEvent -> carteController.onCarteClick());
    }

    public Carte getCarte() {
        return carte;
    }

    public CarteController getCarteController() {
        return carteController;
    }


    public void setOnMouseClicked() {
       carteController.onCarteClick();
    }
}
