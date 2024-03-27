package cheddarcheese;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Player {
    Item holding;
    double xPos;
    double yPos;
    char orientation;
    ImageView image;


    public Player(ImageView image) {
        this.image = image;
    }

    public void reloadSpriteAtPos(GridPane gp, int x, int y){
        gp.add(image, x, y);
    }
}
