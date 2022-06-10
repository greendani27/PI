package com.example.pi;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

import static constants.constants.*;

public class MainController {

    @FXML
    Button btnAnyadir;

    @FXML
    public void cargarAñadir(){
        try {

            Stage stage = (Stage) btnAnyadir.getScene().getWindow();
            stage.close();

            cargarVentana(stage, "Add.fxml","Añadir");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void realizarSorteo(){
        try {

            Stage stage = (Stage) btnAnyadir.getScene().getWindow();
            stage.close();

            cargarVentana(stage, "Raffle.fxml","Tipo de sorteo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void eliminarEquipo(){
        try {

            Stage stage = (Stage) btnAnyadir.getScene().getWindow();
            stage.close();

            cargarVentana(stage, "Remove.fxml","·Eliminar equipo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void verSorteo() {

        RaffleController raffleController = new RaffleController();
        if (sorteo.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sorteo");
            alert.setHeaderText("No hay sorteo");
            alert.setContentText("No hay sorteo para mostrar");
            alert.showAndWait();
        }else if (sorteo.equals("Grupos")) {
            MostrarResultadosSorteo(raffleController);
        } else if (sorteo.equals("Octavos")) {
            MostrarResultadosSorteo(raffleController);
        } else if (sorteo.equals("Cuartos")) {
            MostrarResultadosSorteo(raffleController);
        } else if (sorteo.equals("Semis")) {
            MostrarResultadosSorteo(raffleController);
        }
    }

    private void MostrarResultadosSorteo(RaffleController raffleController) {
        int contadorY = 1;
        int contadorX = 0;

        GridPane gridPane = new GridPane();

        int numEquipos = equiposMostrar.size();
        for (int i = 0; i < numEquipos; i++) {

            Label label = new Label();
            label.setText(equiposMostrar.get(i)+" ");

            gridPane.add(label, contadorX, contadorY);
            contadorX = contadorX + 2;
            if(contadorX > 3){
                contadorX = 0;
                contadorY++;
            }
        }
        //centro el gridpane
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //creo un boton para volver al menu principal
        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(event -> {
            try {
                Stage stage = (Stage) btnVolver.getScene().getWindow();
                stage.close();

                cargarVentana(stage, "Main.fxml","ChampionsL");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //añado el boton al gridpane
        gridPane.add(btnVolver, 1, contadorY+1);
        GridPane.setHalignment(btnVolver, HPos.CENTER);
        GridPane.setValignment(btnVolver, VPos.CENTER);

        //añado un titulo al gridpane
        Label label = new Label();
        label.setText("Semifinales");
        label.setFont(new Font("Arial", 20));
        label.setStyle("-fx-font-weight: bold");
        gridPane.add(label, 1, 0);

        //por ultimo muestro la ventana
        raffleController.mostrarResultado(btnAnyadir, gridPane);
    }
}
