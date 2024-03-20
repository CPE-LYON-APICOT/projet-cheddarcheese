package sample.mvc.view;

import javafx.scene.layout.StackPane;
import sample.mvc.controller.MainController;
import sample.mvc.model.MainModel;

/**
 * MainView
 */
public class MainView extends StackPane {
    private final MainModel model;
    private final MainController controller;

    public MainView(MainModel model, MainController controller) {
        this.model = model;
        this.controller = controller;
    }
}
