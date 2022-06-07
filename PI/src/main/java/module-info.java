module com.example.pi {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens com.example.pi to javafx.fxml;
    exports com.example.pi;
}