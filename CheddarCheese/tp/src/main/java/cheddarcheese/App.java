package cheddarcheese;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import cheddarcheese.Tiles.Inventory;
import cheddarcheese.Tiles.Tile;

/**
 * JavaFX App
 */
public class App extends Application implements Observer{

    private static GameManager gm;
    private static int boardX = 12;
    private static int boardY = 12;

    @SuppressWarnings("deprecation")
    @Override
    public void start(Stage stage) throws IOException {

     

        GridPane game = new GridPane();
        Pane playerPane = new Pane();
        
        SpriteManager spriteManager = new SpriteManager();

        GameMap map = new GameMap(boardX, boardY);
        map.loadMap("map");
        Tile mapTiles[][] = map.getTiles();
        
        for(int i = 0; i < boardX;i++){
            for(int j = 0; j < boardY; j++) {
                Tile tile = mapTiles[i][j];
                ImageView spriteN = spriteManager.createNewSprite(tile.getPath());
                game.add(spriteN, tile.getX(), tile.getY());
            }
        }

        Scene scene = new Scene(new Group(game, playerPane), boardX * 64, boardY * 64);
        stage.setScene(scene);
        stage.setTitle("Cheddar Cheese");
        stage.show();

        String pathC = "sprites/char_s1.png";
        ImageView spriteC = spriteManager.createNewSprite(pathC);

        Player character = Player.getInstance(spriteC, playerPane, mapTiles, (Inventory)mapTiles[boardX-1][boardY-1]);

        gm = new GameManager(game, playerPane, scene, character, spriteManager, boardX-1, boardY-1);
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

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}