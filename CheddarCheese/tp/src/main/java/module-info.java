module cheddarcheese {
    requires javafx.controls;
    requires javafx.fxml;

    opens cheddarcheese to javafx.fxml;
    exports cheddarcheese;
}
