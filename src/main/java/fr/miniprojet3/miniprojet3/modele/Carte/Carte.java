package fr.miniprojet3.miniprojet3.modele.Carte;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Carte {

    private BooleanProperty estRetournee;
    private String image;


    public Carte(String image){
        this.image = image;
        this.estRetournee = new SimpleBooleanProperty(false);
    }

   public BooleanProperty getEstRetournee() {
        return estRetournee;
    }

    public void setEstRetournee(BooleanProperty estRetournee) {
        this.estRetournee = estRetournee;
    }


}
