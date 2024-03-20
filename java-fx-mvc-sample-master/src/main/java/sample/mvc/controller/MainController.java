package sample.mvc.controller;

import javafx.stage.Stage;
import sample.mvc.model.MainModel;

/**
 * MainController
 */
public class MainController {
    private final MainModel model;

    public MainController(Stage stage, MainModel model) {
        this.model = model;
    }
}
