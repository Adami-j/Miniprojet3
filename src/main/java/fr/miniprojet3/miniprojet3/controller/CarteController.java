package fr.miniprojet3.miniprojet3.controller;

import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import fr.miniprojet3.miniprojet3.vue.CarteVue;
import javafx.fxml.FXML;


public class CarteController {

    private Carte carte;

    public CarteController(Carte carte) {
        this.carte = carte;

    }

    @FXML
    public void onCarteClick() {
        System.out.println("Carte cliquée, carte : " + carte.getEstRetournee());
    }

    public CarteController getCarteController() {
        return this;
    }

    public void retournerCarte(){
        carte.setEstRetournee(true);
    }


}
