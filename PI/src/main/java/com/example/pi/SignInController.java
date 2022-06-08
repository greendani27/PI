package com.example.pi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
import java.io.IOException;

import static constants.constants.URL;

public class SignInController {
    @FXML
    TextField txfUsuarioInicio;
    @FXML
    TextField txfContrasenyaInicio;

    @FXML
    protected void registrar() {

        Connection con = null;
        try {
            con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(!txfUsuarioInicio.getText().equals("") && !txfContrasenyaInicio.getText().equals("")) {
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE nombre_usuario = ? AND contrasenya = ?");
                ps.setString(1, txfUsuarioInicio.getText());
                ps.setString(2, txfContrasenyaInicio.getText());
                ResultSet rs = ps.executeQuery();

                if (rs.next()){
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
                    alert.setHeaderText("Error al iniciar sesión");
                    alert.setContentText("El usuario no existe");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
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
