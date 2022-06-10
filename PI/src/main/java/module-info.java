module com.example.pi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pi to javafx.fxml;
    exports com.example.pi;
}