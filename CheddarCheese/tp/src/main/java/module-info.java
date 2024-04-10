module cheddarcheese {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens cheddarcheese to javafx.fxml;
    exports cheddarcheese;
}
