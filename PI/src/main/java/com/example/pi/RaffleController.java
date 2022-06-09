package com.example.pi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static constants.constants.URL;

public class RaffleController {

    @FXML
    Button btnCuartos;
    Connection con = null;
    String sql;
    ArrayList<String> lista = new ArrayList<>();

    @FXML
    public void CargarFaseGrupos() {

        try {
            con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement st = con.createStatement();
            String sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 32;
            while (rs.next()) {
                if(numEquipos == rs.getInt(1)){

                    try {
                        Stage stage = (Stage) btnCuartos.getScene().getWindow();
                        stage.close();

                        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("FaseGrupos.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                        stage = new Stage();
                        stage.setTitle("Fase de grupos");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al realizar el sorteo");
                    alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                    alert.showAndWait();

                    Stage stage = (Stage) btnCuartos.getScene().getWindow();
                    stage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                    stage = new Stage();
                    stage.setTitle("Inicio");
                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void CargarOctavos() {

        try {
            con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement st = con.createStatement();
            sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 16;
            while (rs.next()) {
                if(numEquipos == rs.getInt(1)){
                    try {
                        Stage stage = (Stage) btnCuartos.getScene().getWindow();
                        stage.close();

                        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Octavos.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                        stage = new Stage();
                        stage.setTitle("Octavos de final");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al realizar el sorteo");
                    alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                    alert.showAndWait();

                    Stage stage = (Stage) btnCuartos.getScene().getWindow();
                    stage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                    stage = new Stage();
                    stage.setTitle("Inicio");
                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CargarCuartos() {

        try {
            con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement st = con.createStatement();
            sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 8;
            while (rs.next()) {
               if(numEquipos == rs.getInt(1)){
                   try {
                       Stage stage = (Stage) btnCuartos.getScene().getWindow();
                       stage.close();

                       FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Cuartos.fxml"));
                       Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                       stage = new Stage();
                       stage.setTitle("Cuartos de final");
                       stage.setScene(scene);
                       stage.show();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               } else {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error");
                   alert.setHeaderText("Error al realizar el sorteo");
                   alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                   alert.showAndWait();

                   Stage stage = (Stage) btnCuartos.getScene().getWindow();
                   stage.close();

                   FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
                   Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                   stage = new Stage();
                   stage.setTitle("Inicio");
                   stage.setScene(scene);
                   stage.show();
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void CargarSemis() {
        try {
            con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement st = con.createStatement();
            sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 4;
            while (rs.next()) {
                if(numEquipos == rs.getInt(1)){
                    Statement st2 = con.createStatement();
                    String sql2 = "SELECT * FROM Equipo";
                    ResultSet rs2 = st2.executeQuery(sql2);

                    for (int i = 0; i < numEquipos; i++) {
                        rs2.next();
                        lista.add(rs2.getString(1));
                        System.out.println(lista.get(i));
                    }

                    try {
                        Stage stage = (Stage) btnCuartos.getScene().getWindow();
                        stage.close();

                        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Semis.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                        stage = new Stage();
                        stage.setTitle("Semifinales");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al realizar el sorteo");
                    alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                    alert.showAndWait();

                    Stage stage = (Stage) btnCuartos.getScene().getWindow();
                    stage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                    stage = new Stage();
                    stage.setTitle("Inicio");
                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
