package cheddarcheese;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane game = new GridPane();
        
        SpriteManager spriteManager = new SpriteManager();

        String path0 = "sprites/floor.png";
        String path1 = "sprites/floor.png";
        String path2 = "sprites/floor.png";
        String path3 = "sprites/floor.png";
        String path4 = "sprites/floor.png";
        String path5 = "sprites/floor.png";
        String path6 = "sprites/floor.png";
        String path8 = "sprites/floor.png";
        String path9 = "sprites/floor.png";
        String pathN = path0;
        //ImageView sprite1 = spriteManager.createNewSprite(path1);
        //game.add(sprite1, 0, 0);

        //String path2 = "sprites/floor.png";
        //ImageView sprite2 = spriteManager.createNewSprite(path2);
        //game.add(sprite2, 1, 0);

        GameMap map = new GameMap();
        map.loadMap("map");
        int mapTiles[][] = map.getTiles();

        for(int i = 0; i< 9;i++){
            for(int j = 0; i < 9; j++){
                switch(mapTiles[i][j]){
                    case 0 : pathN = path0;
                    case 1 : pathN = path1;
                    case 2 : pathN = path2;
                    case 3 : pathN = path3;
                    case 4 : pathN = path4;
                    case 5 : pathN = path5;
                    case 6 : pathN = path6;
                    case 8 : pathN = path8;
                    case 9 : pathN = path9;
                    default : pathN = path0;
                }
                ImageView spriteN = spriteManager.createNewSprite(pathN);
                game.add(spriteN, i, j);
            }
        }

        Scene scene = new Scene(game, 9 * 64, 9 * 64);
        stage.setScene(scene);
        stage.setTitle("Cheddar Cheese");
        stage.show();
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