package fr.miniprojet3.miniprojet3.vue;

import fr.miniprojet3.miniprojet3.modele.Carte.Carte;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CarteVue extends StackPane {

    private Carte carte;
    private Rectangle background;
    private ImageView icone;

    public CarteVue(Carte carte){
        this.carte = carte;
        this.background = new Rectangle(100, 100);
        this.background.setStroke(Color.BLACK);
        this.icone = new ImageView(carte.getImage());
    }


    public void setCarteRetournee(boolean retournee) {
        this.carte.setEstRetournee(retournee);
        this.background.setVisible(retournee);
        this.icone.setVisible(retournee);
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Carte getCarte() {
        return carte;
    }

}
