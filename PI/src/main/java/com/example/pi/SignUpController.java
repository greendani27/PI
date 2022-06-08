package com.example.pi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static constants.constants.URL;

public class SignUpController {
    @FXML
    TextField txfUsuarioRegistro;
    @FXML
    TextField txfContrasenyaRegistro;

    @FXML
    protected void registrar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(!txfUsuarioRegistro.getText().equals("") && !txfContrasenyaRegistro.getText().equals("")) {
            System.out.println("Usuario: " + txfUsuarioRegistro.getText() + " Contraseña: " + txfContrasenyaRegistro.getText());
            try {
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO Usuario (nombre_usuario, contrasenya) VALUES ('" + txfUsuarioRegistro.getText() + "', '" + txfContrasenyaRegistro.getText() + "')");

                Stage stage = (Stage) txfUsuarioRegistro.getScene().getWindow();
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
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al registrar");
                alert.setContentText("El usuario ya existe");
                alert.showAndWait();
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
        Stage stage = (Stage) txfUsuarioRegistro.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Sign-in.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 320);
            stage.setTitle("ChampionsL");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
