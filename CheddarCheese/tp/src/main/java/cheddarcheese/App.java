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

        String path1 = "sprites/floor.png";
        ImageView sprite1 = spriteManager.createNewSprite(path1);
        game.add(sprite1, 0, 0);

        String path2 = "sprites/floor.png";
        ImageView sprite2 = spriteManager.createNewSprite(path2);
        game.add(sprite2, 1, 0);

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