module com.example.messenger {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;


    opens com.example.messenger to javafx.fxml;
    exports com.example.messenger;
}