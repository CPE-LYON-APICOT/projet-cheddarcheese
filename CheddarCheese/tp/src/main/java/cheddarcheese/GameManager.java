package cheddarcheese;

import cheddarcheese.Foods.BaseForRecipe;
import cheddarcheese.Foods.Food;
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

import java.util.ArrayList;
import java.util.List;
import cheddarcheese.Foods.Interfaces.Recette;
import cheddarcheese.Foods.Interfaces.Recettes;
import cheddarcheese.Foods.Bread;
import java.util.Random;

public class GameManager {
    private GridPane map;
    private Pane playerPane;
    private Scene scene;
    private Player player;
    private SpriteManager spm;
    private Recette curRecipe;
    private List<Recette> recipes;
    private List<ImageView> imgRecipe;
    private int invPosX;
    private int invPosY;

    public GameManager(GridPane map, Pane playPane, Scene scene, Player character, SpriteManager spm, int invPosX, int invPosY){
        this.map = map;
        this.playerPane = playPane;
        this.scene = scene;
        this.player = character;
        this.spm = spm;
        this.invPosX = invPosX;
        this.invPosY = invPosY;

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

        imgRecipe = new ArrayList<>();

        for(int i = 0; i < invPosX; i ++){
            imgRecipe.add(null);
        }

        recipes = getRecipesFromAnnotation(Bread.class);
        selectRandomRecipe();
    }

    //Get recipes included in the Bread class' @Recettes annotation
    private static List<Recette> getRecipesFromAnnotation(Class<?> clazz) {
        List<Recette> recipes = new ArrayList<>();
        
        Recettes recettesAnnotation = clazz.getAnnotation(Recettes.class);
        if (recettesAnnotation != null) {
            Recette[] recetteAnnotations = recettesAnnotation.value();
            for (Recette recette : recetteAnnotations) {
                recipes.add(recette);
            }
        }
        
        return recipes;
    }

    //Select a random recipe to be displayed
    public void selectRandomRecipe(){
        Random rand = new Random();
        int index = rand.nextInt(recipes.size());
        curRecipe = recipes.get(index);
        int posX;

        for(int i = 0; i < invPosX; i++){
            if(imgRecipe.get(i) != null) {
                map.getChildren().remove(imgRecipe.get(i));
            } 
        }

        ImageView img = spm.createNewSprite("sprites/" + curRecipe.transformsTo().getSimpleName() + ".png");
        map.add(img, 0 , invPosY);
        imgRecipe.set(0, img);

        ImageView breadImg = spm.createNewSprite("sprites/Bread.png");
        map.add(breadImg, 1 , invPosY);
        imgRecipe.set(1, breadImg);

        posX = 2;
        for(Class<?> ingredient : curRecipe.ingredients()) {
            ImageView ingredientImg = spm.createNewSprite("sprites/" + ingredient.getSimpleName() + ".png");
            map.add(ingredientImg, posX, invPosY);
            imgRecipe.set(posX, ingredientImg);
            posX++;
        }

        ImageView topImg = spm.createNewSprite("sprites/" + curRecipe.top().getSimpleName() + ".png");
        map.add(topImg, posX, invPosY);
        imgRecipe.set(posX, topImg);
    }

    public void interactWithTile() {
        Tile block = player.getFrontBlock();

        if(block instanceof InteractTile) ((InteractTile) block).interact(this);
    }

    //Item interactions with a tile that can hold an item
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
                popped.moveToInventory(invPosX, invPosY);
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

    //Visually add an item to the map
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

    public Class<?> getRecipeResult(){
        return this.curRecipe.transformsTo();
    }
}
