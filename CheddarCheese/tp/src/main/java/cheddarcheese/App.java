package cheddarcheese;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane game = new GridPane();
        
        SpriteManager spriteManager = new SpriteManager();

        String path0 = "sprites/floor.png";
        String path1 = "sprites/wall.png";
        String path2 = "sprites/table.png";
        String path3 = "sprites/cutting_table.png";
        String path4 = "sprites/deposit.png";
        String path5 = "sprites/bin.png";
        String path6 = "sprites/foodbox_closed.png";
        String path8 = "sprites/inventory.png";
        String path9 = "sprites/floor.png";
        String pathN = path0;

        int FPS = 60;
        double interval = 1000000000/FPS;
        double nextInterval = System.nanoTime() + interval;

        GameMap map = new GameMap();
        map.loadMap("map");
        int mapTiles[][] = map.getTiles();

        for(int i = 0; i< 9;i++){
            for(int j = 0; j < 9; j++){
                switch(mapTiles[i][j]){
                    case 0: pathN = path0; break;
                    case 1: pathN = path1; break;
                    case 2: pathN = path2; break;
                    case 3: pathN = path3; break;
                    case 4: pathN = path4; break;
                    case 5: pathN = path5; break;
                    case 6: pathN = path6; break;
                    case 8: pathN = path8; break;
                    case 9: pathN = path9; break;
                }
                ImageView spriteN = spriteManager.createNewSprite(pathN);
                game.add(spriteN, i, j);
            }
        }

        Scene scene = new Scene(game, 9 * 64, 9 * 64);
        stage.setScene(scene);
        stage.setTitle("Cheddar Cheese");
        stage.show();

        String pathC = "sprites/char_s1.png";
        ImageView spriteC = spriteManager.createNewSprite(pathC);

        Player character = new Player(spriteC);
        character.reloadSpriteAtPos(game, 1, 1);
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