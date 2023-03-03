package fr.miniprojet3.miniprojet3.vue;
import fr.miniprojet3.miniprojet3.modele.Carte.Carte;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CarteVue extends ImageView {

    private Carte carte;


    /**
     * @Author : Julien ADAMI
     * Constructeur de la classe CarteVue qui contient une carte
     * et qui assigne l'imageview à la carte de dos
     * @param carte
     */
    public CarteVue(Carte carte) {
        this.carte = carte;
        this.setImage(new Image("file:src/main/resources/fr/miniprojet3/miniprojet3/images/imagesCarte/dos-carte-s10-hearthstone.jpg"));
        this.setFitWidth(150);
        this.setFitHeight(170);

    }

    public Carte getCarte() {
        return carte;
    }


}
