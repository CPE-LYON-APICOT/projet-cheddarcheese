module cheddarcheese {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens cheddarcheese to javafx.fxml;
    exports cheddarcheese;
}
