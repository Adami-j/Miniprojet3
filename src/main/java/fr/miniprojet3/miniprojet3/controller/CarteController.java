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
    private boolean estEnCoursDeJeu = false;

    public CarteVue getCarteVue() {
        return carteVue;
    }

    public CarteController(Carte carte, CarteVue carteVue) {
        this.carte = carte;
        this.carteVue = carteVue;
        this.estEnCoursDeJeu=false;

    }


    /**
     * @Author: Julien ADAMI
     * Méthode qui permet de retourner la carte
     * onclickListener
     */
    @FXML
    public void onCarteClick() {

        if(!carte.isEstRetournee()){

            System.out.println("Carte cliquée, carte : " + carte.getEstRetournee());
            this.retournerCarte(carteVue);

        }else {
            this.dosCarte(carteVue);
            System.out.println("Carte déjà retournée");
        }
    }

    public CarteController getCarteController() {
        return this;
    }

    public void dosCarte(CarteVue carteVue){
        carteVue.setImage(new Image("file:src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte/dos-carte-s10-hearthstone.jpg"));
        carte.setEstRetournee(false);
    }



    public void retournerCarte(CarteVue imageView) {
        imageView.setImage(new Image(carte.getImage()));
        carte.setEstRetournee(true);
    }

    public void remouve(){
      this.carteVue.setVisible(false);
    }

    public void setEstEnCoursDeJeu(boolean estEnCoursDeJeu) {
        this.estEnCoursDeJeu = estEnCoursDeJeu;
    }
}
