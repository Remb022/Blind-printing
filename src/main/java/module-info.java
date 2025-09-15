module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    exports com.example.demo;

    opens com.example.demo to javafx.fxml;
    opens com.example.demo.layouts to javafx.fxml;
    opens com.example.demo.view to javafx.fxml;
    opens com.example.demo.components to javafx.fxml;
    exports com.example.demo.databases;
    opens com.example.demo.databases to javafx.fxml;
    opens com.example.demo.activity to javafx.fxml;
}
