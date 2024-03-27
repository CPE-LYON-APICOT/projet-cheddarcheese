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
        ImageView imageView = new ImageView();

        // Créer une mise en page pour contenir l'ImageView
        GridPane root = new GridPane();
        root.getChildren().add(imageView);

        // Créer une scène avec la mise en page et la montrer
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Image Display");
        stage.show();

        // Utiliser la classe ImageController pour afficher l'image
        SpriteManager imageController = new SpriteManager();
        imageController.afficherImage(imageView);
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