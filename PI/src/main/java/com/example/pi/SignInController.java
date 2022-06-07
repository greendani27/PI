package com.example.pi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignInController {
    @FXML
    TextField txfUsuarioInicio;
    @FXML
    TextField txfContrasenyaInicio;

    @FXML
    protected void registrar() {

            //Connection con = DriverManager.getConnection("jdbc:mysql://iescristobaldemonroy.duckdns.org:" + PUERTO + "/" + NOMBD + "?useSSL=false", USUARIO, PASSWORD);

        if(!txfUsuarioInicio.getText().equals("") && !txfContrasenyaInicio.getText().equals("")) {
            //todo comprobar que existe ya el usuario, insertar
            System.out.println("Usuario: " + txfUsuarioInicio.getText() + " Contraseña: " + txfContrasenyaInicio.getText());

            Stage stage = (Stage) txfUsuarioInicio.getScene().getWindow();
            stage.close();

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                stage.setTitle("ChampionsL");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se han rellenado todos los campos");
            alert.showAndWait();
        }
    }

    @FXML
    protected void Redirigir() {
        Stage stage = (Stage) txfUsuarioInicio.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("SignUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 320);
            stage.setTitle("ChampionsL");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
