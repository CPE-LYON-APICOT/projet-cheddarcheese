package sample.mvc.view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.mvc.controller.MainController;
import sample.mvc.model.MainModel;

/**
 * MainView
 */
public class MainView extends StackPane {
    private final MainModel model;
    private final MainController controller;
    private final int SQUARE_SIZE = 64;

    public MainView(MainModel model, MainController controller) {
        this.model = model;
        this.controller = controller;
        initView();
    }

    private void initView() {
        GridPane gridPane = new GridPane();
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                square.setStroke(Color.BLACK);
                square.setFill(Color.WHITE);
                gridPane.add(square, col, row);
            }
        }

        this.getChildren().add(gridPane);
    }

    public void updateMapView(char[][] mapData) {
        
    }
}
