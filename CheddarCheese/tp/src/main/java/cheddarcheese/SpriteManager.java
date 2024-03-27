package cheddarcheese;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteManager {

    public void afficherImage(ImageView imageView) {
        Image image = new Image(getClass().getResourceAsStream("sprites/tomato.png"));

        imageView.setImage(image);
    }
}