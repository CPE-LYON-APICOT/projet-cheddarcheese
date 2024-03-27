package cheddarcheese;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Player {
    private Item holding;
    private double xPos;
    private double yPos;
    private double speed;
    private char orientation;
    private Pane overlayPane;
    private ImageView image;

    public Player(ImageView image, Pane overlayPane) {
        this.image = image;
        this.xPos = 1 * 64;
        this.yPos = 1 * 64;
        this.speed = 0.2 * 64;
        this.overlayPane = overlayPane;

        overlayPane.getChildren().add(image);
    }

    public double getX(){
        return xPos;
    }

    public double getY(){
        return yPos;
    }

    public void moveDown(){
        this.yPos += speed;
        updateImagePosition();
    }

    public void moveUp(){
        this.yPos -= speed;
        updateImagePosition();
    }

    public void moveRight(){
        this.xPos += speed;
        updateImagePosition();
    }

    public void moveLeft(){
        this.xPos -= speed;
        updateImagePosition();
    }

    private void updateImagePosition() {
        image.setLayoutX(xPos);
        image.setLayoutY(yPos);
    }
}
