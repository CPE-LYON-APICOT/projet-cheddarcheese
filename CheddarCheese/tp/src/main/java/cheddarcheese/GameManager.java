package cheddarcheese;

import cheddarcheese.Tiles.InteractTile;
import cheddarcheese.Tiles.ItemHolder;
import cheddarcheese.Tiles.Tile;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameManager {
    private GridPane map;
    private Pane playerPane;
    private Scene scene;
    private Player player;
    private SpriteManager spm;

    public GameManager(GridPane map, Pane playPane, Scene scene, Player character, SpriteManager spm){
        this.map = map;
        this.playerPane = playPane;
        this.scene = scene;
        this.player = character;
        this.spm = spm;

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode keyPressed = event.getCode();

                switch (keyPressed) {
                    case Z:
                        player.moveUp();
                        break;
                    case S:
                        player.moveDown();
                        break;
                    case Q:
                        player.moveLeft();
                        break;
                    case D:
                        player.moveRight();
                        break;
                    case L:
                        interactWithTile();
                        break;
                    case M:
                        interactWithItemHolder();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void interactWithTile() {
        Tile block = player.getFrontBlock();

        if(block instanceof InteractTile) ((InteractTile) block).interact(this);
    }

    public void interactWithItemHolder() {
        Tile block = player.getFrontBlock();

        if (block instanceof ItemHolder && player.getInventory() instanceof ItemHolder) {
            ItemHolder blockInventory = (ItemHolder) block;
            ItemHolder playerInventory = (ItemHolder) player.getInventory();
        
            Item blockItem = blockInventory.getItem();
            Item userItem = playerInventory.getItem();
        
            if (blockItem != null && userItem == null) {
                Item popped = blockInventory.popItem();
                playerInventory.setItem(popped);
                popped.moveToInventory();
            } else if (blockItem == null && userItem != null) {
                Item popped = playerInventory.popItem();
                blockInventory.setItem(popped);
                popped.setXYPos(block.getX(), block.getY());
            } else if (blockItem instanceof BaseForRecipe && userItem instanceof Food) {
                Food foodItem = (Food) playerInventory.popItem();
                ((BaseForRecipe) blockItem).addIngredient(foodItem);
                Food transformedFood = ((BaseForRecipe) blockItem).checkIngredients(foodItem);
                if (transformedFood != null) {
                    transformedFood.setImgView(blockItem.image);
                    blockInventory.setItem(transformedFood);
                }
            }
        }
    }

    public void addItemToMap(Item item, int x, int y) {
        ImageView img = spm.createNewSprite("sprites/" + item.getName() + ".png");
        item.setImgView(img);
        map.add(img, x, y);
    }

    public Scene getScene(){
        return this.scene;
    }

    public Player getPlayer(){
        return this.player;
    }
}
