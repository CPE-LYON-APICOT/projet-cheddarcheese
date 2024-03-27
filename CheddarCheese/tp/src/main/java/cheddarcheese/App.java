package cheddarcheese;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

import cheddarcheese.Tiles.Tile;
import cheddarcheese.Tiles.Floor;
import cheddarcheese.Tiles.FoodboxClosed;
import cheddarcheese.Tiles.Inventory;
import cheddarcheese.Tiles.Wall;
import cheddarcheese.Tiles.Table;
import cheddarcheese.Tiles.Bin;
import cheddarcheese.Tiles.CuttingTable;
import cheddarcheese.Tiles.Deposit;

/**
 * JavaFX App
 */
public class App extends Application{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane game = new GridPane();
        Pane playerPane = new Pane();
        
        SpriteManager spriteManager = new SpriteManager();

        Floor floor = new Floor("Floor", "sprites/floor.png", 0, 0);
        Wall wall = new Wall("Wall", "sprites/wall.png", 0, 0);
        Table table = new Table("Table", "sprites/table.png", 0, 0);
        CuttingTable cuttingTable = new CuttingTable("CuttingTable", "sprites/cutting_table.png", 0, 0);
        Deposit deposit = new Deposit("Deposit", "sprites/deposit.png", 0, 0);
        Bin bin = new Bin("Bin", "sprites/bin.png", 0, 0);
        FoodboxClosed foodboxClosed = new FoodboxClosed("FoodboxClosed", "sprites/foodbox_closed.png", 0, 0);
        Inventory inventory = new Inventory("Inventory", "sprites/inventory.png", 0, 0);

        GameMap map = new GameMap();
        map.loadMap("map");
        int mapTiles[][] = map.getTiles();
        
        /*
         * Generate the map
         */
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9; j++) {

                Tile tile = new Tile("Tile", floor.getPath(), i, j);
                
                switch(mapTiles[i][j]) {
                    case 0: tile.setPath(floor.getPath()); break;
                    case 1: tile.setPath(wall.getPath()); break;
                    case 2: tile.setPath(table.getPath()); break;
                    case 3: tile.setPath(cuttingTable.getPath()); break;
                    case 4: tile.setPath(deposit.getPath()); break;
                    case 5: tile.setPath(bin.getPath()); break;
                    case 6: tile.setPath(foodboxClosed.getPath()); break;
                    case 8: tile.setPath(inventory.getPath()); break;
                    case 9: tile.setPath(floor.getPath()); break;
                }
                ImageView spriteN = spriteManager.createNewSprite(tile.getPath());
                game.add(spriteN, tile.getX(), tile.getY());
            }
        }

        Scene scene = new Scene(new Group(game, playerPane), 9 * 64, 9 * 64);
        stage.setScene(scene);
        stage.setTitle("Cheddar Cheese");
        stage.show();

        String pathC = "sprites/char_s1.png";
        ImageView spriteC = spriteManager.createNewSprite(pathC);

        Player character = new Player(spriteC, playerPane);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            KeyCode keyPressed = event.getCode();

            switch (keyPressed) {
                case Z:
                    character.moveUp();
                    break;
                case S:
                    character.moveDown();
                    break;
                case Q:
                    character.moveLeft();
                    break;
                case D:
                    character.moveRight();
                    break;
                default:
                    break;
            }
        }
    });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}