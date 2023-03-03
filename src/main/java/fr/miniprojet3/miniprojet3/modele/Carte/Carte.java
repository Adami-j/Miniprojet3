package fr.miniprojet3.miniprojet3.modele.Carte;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.Objects;

public class Carte {

    private BooleanProperty estRetournee;
    private String image;


    /**
     * @Author : Julien ADAMI
     * Constructeur de la classe Carte
     * qui contient le chemin de l'image et un boolean pour savoir si la carte est retournée
     * @param image
     */
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

    public boolean isEstRetournee() {
        return estRetournee.get();
    }

    public BooleanProperty estRetourneeProperty() {
        return estRetournee;
    }

    public void setEstRetournee(boolean estRetournee) {
        this.estRetournee.set(estRetournee);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {

        Carte carte = (Carte) o;
        return  Objects.equals(image, carte.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estRetournee, image);
    }

    @Override
    public String toString() {
        return "Carte{" +
                "estRetournee=" + estRetournee +
                ", image='" + image + '\'' +
                '}';
    }
}
