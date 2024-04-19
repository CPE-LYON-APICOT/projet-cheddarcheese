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

import cheddarcheese.Tiles.Inventory;
import cheddarcheese.Tiles.Tile;

/**
 * JavaFX App
 */
public class App extends Application{

    private static GameManager gm;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane game = new GridPane();
        Pane playerPane = new Pane();
        
        SpriteManager spriteManager = new SpriteManager();

        GameMap map = new GameMap();
        map.loadMap("map");
        Tile mapTiles[][] = map.getTiles();
        
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9; j++) {
                Tile tile = mapTiles[i][j];
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

        Player character = new Player(spriteC, playerPane, mapTiles, (Inventory)mapTiles[8][8]);

        gm = new GameManager(game, playerPane, scene, character, spriteManager);
    }

    static void setRoot(String fxml) throws IOException {
        gm.getScene().setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}