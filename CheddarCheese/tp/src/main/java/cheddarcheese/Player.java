package cheddarcheese;

import cheddarcheese.Tiles.InteractTile;
import cheddarcheese.Tiles.Inventory;
import cheddarcheese.Tiles.ItemHolder;
import cheddarcheese.Tiles.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player {
    private Inventory inventory;
    private double xPos;
    private double yPos;
    private double speed;
    private char orientation;
    private Pane overlayPane;
    private ImageView image;
    private Tile tileset[][];

    public Player(ImageView image, Pane overlayPane, Tile tileset[][], Inventory inventory) {
        this.image = image;
        this.xPos = 1 * 64;
        this.yPos = 1 * 64;
        this.speed = 1 * 64;
        this.overlayPane = overlayPane;
        this.tileset = tileset;
        this.inventory = inventory;

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
        orientation = 'S';
        updateImagePosition();
        setImage("char_s1.png");
    }

    public void moveUp(){
        collisionCheck(xPos, yPos - speed);
        orientation = 'N';
        updateImagePosition();
        setImage("char_n1.png");
    }

    public void moveRight(){
        collisionCheck(xPos + speed, yPos);
        orientation = 'E';
        updateImagePosition();
        setImage("char_e1.png");
    }

    public void moveLeft(){
        collisionCheck(xPos - speed, yPos);
        orientation = 'W';
        updateImagePosition();
        setImage("char_w1.png");
    }

    private void updateImagePosition() {
        image.setLayoutX(xPos);
        image.setLayoutY(yPos);
    }

    private void collisionCheck(double nXpos, double nYpos) {
        int tileX = (int) (nXpos / 64); 
        int tileY = (int) (nYpos / 64); 
    
        if(tileset[tileX][tileY].getPath() == "sprites/floor.png"){
            xPos = nXpos;
            yPos = nYpos;
        }
    }

    public void interactWithTile() {
        Tile block = getFrontBlock();

        if(block instanceof InteractTile) ((InteractTile) block).interact(this);
    }

    public void interactWithItemHolder() {
        Tile block = getFrontBlock();

        if(block instanceof ItemHolder){
            if(((ItemHolder) block).getItem() != null && ((ItemHolder) inventory).getItem() == null) {
                Item popped = ((ItemHolder) block).popItem();
                ((ItemHolder) inventory).setItem(popped);
            } else if (((ItemHolder) block).getItem() == null && ((ItemHolder) inventory).getItem() != null) {
                Item popped = ((ItemHolder) inventory).popItem();
                ((ItemHolder) block).setItem(popped);
            }
        } 
    }

    public Inventory getInventory(){
        return inventory;
    }

    private Tile getFrontBlock(){
        int xCoord = (int) xPos/64;
        int yCoord = (int) yPos/64;

        switch (orientation) {
            case 'S':
                yCoord++; 
                break;
            case 'N':
                yCoord--;
                break;
            case 'E':
                xCoord++;
                break;
            case 'W':
                xCoord--;
                break;
            default:
                break;
        }

        Tile block = tileset[xCoord][yCoord];

        return block;
    }

    private void setImage(String filename) {
        Image playerImage = new Image(getClass().getResourceAsStream("sprites/" + filename));
        image.setImage(playerImage);
    }
    
}