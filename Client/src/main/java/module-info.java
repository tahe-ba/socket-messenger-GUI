module com.example.messengerclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.example.messengerclient to javafx.fxml;
    exports com.example.messengerclient;
}