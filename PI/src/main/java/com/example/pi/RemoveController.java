package com.example.pi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static constants.constants.establecerConexion;

public class RemoveController {

    Connection con = establecerConexion();
    @FXML
    TextField txfBorrar;

    @FXML
    public void borrar() {
        if (txfBorrar.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al borrar");
            alert.setContentText("No se ha introducido ningún nombre");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("¿Está seguro de que quiere borrar el equipo?");
            alert.setContentText("El equipo " + txfBorrar.getText() + " será borrado");
            alert.showAndWait();

            try {
                Statement st = con.createStatement();
                String sql = "DELETE FROM Equipo WHERE nombre = '" + txfBorrar.getText() + "'";
                st.executeUpdate(sql);

                Stage stage = (Stage) txfBorrar.getScene().getWindow();
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
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error");
                alert2.setHeaderText("Error al borrar");
                alert2.setContentText("El equipo no existe");
                alert2.showAndWait();
            }
        }
    }
    public void borrarTodo(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Está seguro de que quiere borrar todos los equipos?");
        alert.setContentText("Todos los equipos serán borrados");
        alert.showAndWait();

        try {
            Statement st = con.createStatement();
            String sql = "DELETE FROM Equipo";
            st.executeUpdate(sql);

            Stage stage = (Stage) txfBorrar.getScene().getWindow();
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
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error");
            alert2.setHeaderText("Error al borrar");
            alert2.setContentText("El equipo no existe");
            alert2.showAndWait();
        }
    }
}
