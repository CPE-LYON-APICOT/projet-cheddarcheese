package cheddarcheese;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

abstract public class Item {
    private int xPos;
    private int yPos;
    private String name;
    public ImageView image;
    
    public Item(int xPos, int yPos, String name) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
    }

    public int getXPos() {
        return this.xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
        updateImagePosition();
    }

    public int getYPos() {
        return this.yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
        updateImagePosition();
    }

    public void setXYPos(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        updateImagePosition();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgView(ImageView img){
        this.image = img;
        updateImagePosition();
        setItemImage(this.name);
    }

    public void setItemImage(String filename) {
        Image itemImage = new Image(Item.class.getResourceAsStream("sprites/" + filename + ".png"));
        image.setImage(itemImage);
    }

    public Item xPos(int xPos) {
        setXPos(xPos);
        return this;
    }

    public Item yPos(int yPos) {
        setYPos(yPos);
        return this;
    }

    public Item name(String name) {
        setName(name);
        return this;
    }

    private void updateImagePosition() {
        if (image != null) {
            GridPane.setColumnIndex(image, xPos);
            GridPane.setRowIndex(image, yPos);
        }
    }

    public void moveToInventory(){
        this.xPos = 8;
        this.yPos = 8;
        updateImagePosition();
    }

    public void removeImg(){
        Parent parent = image.getParent();
    
        if (parent instanceof Pane) {
            ((Pane) parent).getChildren().remove(image);
        }
    }
}
