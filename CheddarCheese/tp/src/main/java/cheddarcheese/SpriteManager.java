package cheddarcheese;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteManager {

    /**
     * Créé un sprite selon un path d'image donné
     * @param path
     * @return
     */
    public ImageView createNewSprite(String path) {
        Image image = new Image(getClass().getResourceAsStream(path));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        return imageView;
    }
}