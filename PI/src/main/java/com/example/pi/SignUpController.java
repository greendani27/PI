package com.example.pi;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static constants.constants.cargarVentana;
import static constants.constants.establecerConexion;

public class SignUpController {
    Connection con = establecerConexion();
    @FXML
    TextField txfUsuarioRegistro;
    @FXML
    TextField txfContrasenyaRegistro;

    @FXML
    protected void registrar() {
        if(!txfUsuarioRegistro.getText().equals("") && !txfContrasenyaRegistro.getText().equals("")) {
            try {
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO Usuario (nombre_usuario, contrasenya) VALUES ('" + txfUsuarioRegistro.getText() + "', '" + txfContrasenyaRegistro.getText() + "')");

                Stage stage = (Stage) txfUsuarioRegistro.getScene().getWindow();
                stage.close();

                try {
                    cargarVentana(stage, "Main.fxml","ChampionsL");
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
            cargarVentana(stage, "SignIn.fxml","ChampionsL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
