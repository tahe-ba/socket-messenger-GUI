module com.example.messengerclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;

    opens com.example.messengerclient to javafx.fxml;
    exports com.example.messengerclient;
}