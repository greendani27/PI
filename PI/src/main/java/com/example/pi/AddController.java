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

public class AddController {

    Connection con = establecerConexion();

    @FXML
    TextField txfNombre;
    @FXML
    TextField txfPais;
    @FXML
    TextField txfRanking;

    public void add() {
        if (txfNombre.getText().isEmpty() || txfPais.getText().isEmpty() || txfRanking.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al agregar");
            alert.setContentText("No puede haber campos vacios");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmacion");
            alert.setHeaderText("Confirmacion");
            alert.setContentText("¿Desea añadir mas equipos?");
            alert.showAndWait();

            try {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Equipo (nombre, pais, ranking) VALUES ('" + txfNombre.getText() + "', '" + txfPais.getText() + "', '" + txfRanking.getText() + "')";
                st.executeUpdate(sql);
                Stage stage = (Stage) txfNombre.getScene().getWindow();
                stage.close();

                try {
                    cargarVentana(stage, "Main.fxml","ChampionsL");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error");
                alert2.setHeaderText("Error al insertar");
                alert2.setContentText("No se ha podido insertar el equipo");
                alert2.showAndWait();
            }
        }
    }
}
