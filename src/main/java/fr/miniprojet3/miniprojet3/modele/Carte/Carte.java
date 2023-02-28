package fr.miniprojet3.miniprojet3.modele.Carte;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Carte {

    private BooleanProperty estRetournee;

    @FXML
    ImageView imageView;

    public Carte(){
        this.imageView = new ImageView();
        this.estRetournee = new SimpleBooleanProperty(false);
    }

   public BooleanProperty getEstRetournee() {
        return estRetournee;
    }

    public void setEstRetournee(BooleanProperty estRetournee) {
        this.estRetournee = estRetournee;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

}
