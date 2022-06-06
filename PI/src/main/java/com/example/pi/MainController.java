package com.example.pi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    Button btnAnyadir;

    @FXML
    public void cargarAñadir(){
        try {

            Stage stage = (Stage) btnAnyadir.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Add.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage = new Stage();
            stage.setTitle("Añadir");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void realizarSorteo(){
        try {

            Stage stage = (Stage) btnAnyadir.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Raffle.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage = new Stage();
            stage.setTitle("Tipo de sorteo");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void eliminarEquipo(){
        try {

            Stage stage = (Stage) btnAnyadir.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Remove.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage = new Stage();
            stage.setTitle("Eliminar");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //todo hacer la pantalla de visualizacion y añadirla aqui
    @FXML
    public void verSorteo(){
        try {

            Stage stage = (Stage) btnAnyadir.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Add.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage = new Stage();
            stage.setTitle("Resultados del sorteo");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
