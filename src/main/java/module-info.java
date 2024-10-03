module org.example.istock2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.istock2 to javafx.fxml;
    exports org.example.istock2;

    exports org.example.istock2.controllers;
    opens org.example.istock2.controllers to javafx.fxml;
}