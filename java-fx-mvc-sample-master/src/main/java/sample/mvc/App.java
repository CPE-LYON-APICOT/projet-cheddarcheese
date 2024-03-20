package sample.mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.mvc.controller.MainController;
import sample.mvc.model.MainModel;
import sample.mvc.view.MainView;

/**
 * App
 */
public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        MainModel model = new MainModel();
        MainController controller = new MainController(primaryStage, model);
        MainView view = new MainView(model, controller);

        Scene scene = new Scene(view, 576, 576);
        primaryStage.setTitle("Cheddar-Cheese");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
