package fr.miniprojet3.miniprojet3.controller;

import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import fr.miniprojet3.miniprojet3.vue.CarteVue;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CarteController {

    private Carte carte;

    private ImageView imageView;
    private CarteVue carteVue;

    public CarteController(Carte carte,CarteVue carteVue) {
        this.carte = carte;
        this.carteVue = carteVue;
    }

    @FXML
    public void onCarteClick() {
        if(!carte.isEstRetournee()){
            System.out.println("Carte cliquée, carte : " + carte.getEstRetournee());
            this.retournerCarte(carteVue);
        }
        System.out.println("Carte cliquée, carte : " + carte.getEstRetournee());

        System.out.println("Carte cliquée, carte : " + carte.getEstRetournee());
    }


    public CarteController getCarteController() {
        return this;
    }

    public void dosCarte(CarteVue carteVue){
        carteVue.setImage(new Image("file:src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte/dos-carte-s10-hearthstone.jpg"));
        carte.setEstRetournee(true);
    }



    public void retournerCarte(CarteVue imageView) {
        imageView.setImage(new Image(carte.getImage()));
        carte.setEstRetournee(true);
    }


}
