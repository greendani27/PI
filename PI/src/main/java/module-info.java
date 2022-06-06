module com.example.pi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pi to javafx.fxml;
    exports com.example.pi;
}