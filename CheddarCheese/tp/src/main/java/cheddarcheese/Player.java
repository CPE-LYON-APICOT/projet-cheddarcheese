package cheddarcheese;

import cheddarcheese.Tiles.Floor;
import cheddarcheese.Tiles.Tile;
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
    private Tile tileset[][];

    public Player(ImageView image, Pane overlayPane, Tile tileset[][]) {
        this.image = image;
        this.xPos = 1 * 64;
        this.yPos = 1 * 64;
        this.speed = 0.2 * 64;
        this.overlayPane = overlayPane;
        this.tileset = tileset;

        overlayPane.getChildren().add(image);
        updateImagePosition();
    }

    public double getX(){
        return xPos;
    }

    public double getY(){
        return yPos;
    }

    public void moveDown(){
        collisionCheck(xPos, yPos + speed);
        updateImagePosition();
    }

    public void moveUp(){
        collisionCheck(xPos, yPos - speed);
        updateImagePosition();
    }

    public void moveRight(){
        collisionCheck(xPos + speed, yPos);
        updateImagePosition();
    }

    public void moveLeft(){
        collisionCheck(xPos - speed, yPos);
        updateImagePosition();
    }

    private void updateImagePosition() {
        image.setLayoutX(xPos);
        image.setLayoutY(yPos);
    }

    private void collisionCheck(double nXpos, double nYpos) {
        int tileX = (int) Math.floor(nXpos)/64;
        int tileY = (int) Math.floor(nYpos)/64;
    
        if (tileset[tileX][tileY].getPath() == "sprites/floor.png") {
            xPos = nXpos;
            yPos = nYpos;
        }
    }
}
