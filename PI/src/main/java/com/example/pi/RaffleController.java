package com.example.pi;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static constants.constants.*;

public class RaffleController {

    @FXML
    Button btnCuartos;

    Connection con = establecerConexion();

    String sql;

    ArrayList<String> lista = new ArrayList<>();
    ArrayList<String> eliminatoria = new ArrayList<>();

    int random;

    @FXML
    public void CargarFaseGrupos() {
        sorteo = "Grupos";
        equiposMostrar.clear();

        try {
            //compruebo que el numero de equipos sea correcto
            Statement st = con.createStatement();
            sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 32;
            while (rs.next()) {
                if(numEquipos == rs.getInt(1)){
                    int contadorY = 1;
                    int contadorX = 0;

                    GridPane gridPane = new GridPane();
                    Statement st2 = con.createStatement();
                    String sql2 = "SELECT * FROM Equipo";
                    ResultSet rs2 = st2.executeQuery(sql2);

                    //cargo los equipos en una lista
                    for (int i = 0; i < numEquipos; i++) {
                        rs2.next();
                        lista.add(rs2.getString(1));
                    }

                    //Creo un label para cada equipo y los añado al gridpane tras sortearlos
                    for (int i = 0; i < numEquipos; i++) {

                        random = (int) (Math.random() * lista.size());
                        eliminatoria.add(lista.get(random));
                        if(equiposMostrar.size() < numEquipos){
                            equiposMostrar.add(eliminatoria.get(i));
                        }
                        lista.remove(random);

                        Label label = new Label();
                        label.setText(eliminatoria.get(i)+" ");

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
                    label.setText("Fase de grupos");
                    label.setFont(new Font("Arial", 20));
                    label.setStyle("-fx-font-weight: bold");
                    gridPane.add(label, 1, 0);

                    //por ultimo muestro la ventana
                    mostrarResultado(btnCuartos, gridPane);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al realizar el sorteo");
                    alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                    alert.showAndWait();

                    Stage stage = (Stage) btnCuartos.getScene().getWindow();
                    stage.close();

                    cargarVentana(stage, "Main.fxml","ChampionsL");
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void CargarOctavos() {
        sorteo = "Octavos";
        equiposMostrar.clear();

        try {
            //compruebo que el numero de equipos sea correcto
            Statement st = con.createStatement();
            sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 16;
            while (rs.next()) {
                if(numEquipos == rs.getInt(1)){
                    int contadorY = 1;
                    int contadorX = 0;

                    GridPane gridPane = new GridPane();
                    Statement st2 = con.createStatement();
                    String sql2 = "SELECT * FROM Equipo";
                    ResultSet rs2 = st2.executeQuery(sql2);

                    //cargo los equipos en una lista
                    for (int i = 0; i < numEquipos; i++) {
                        rs2.next();
                        lista.add(rs2.getString(1));
                    }

                    //Creo un label para cada equipo y los añado al gridpane
                    for (int i = 0; i < numEquipos; i++) {
                        random = (int) (Math.random() * lista.size());
                        eliminatoria.add(lista.get(random));
                        if(equiposMostrar.size() < numEquipos){
                            equiposMostrar.add(eliminatoria.get(i));
                        }
                        lista.remove(random);

                        Label label = new Label();
                        label.setText(eliminatoria.get(i)+" ");

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
                    label.setText("Octavos de final");
                    label.setFont(new Font("Arial", 20));
                    label.setStyle("-fx-font-weight: bold");
                    gridPane.add(label, 1, 0);

                    //por ultimo muestro la ventana
                    mostrarResultado(btnCuartos, gridPane);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al realizar el sorteo");
                    alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                    alert.showAndWait();

                    Stage stage = (Stage) btnCuartos.getScene().getWindow();
                    stage.close();

                    cargarVentana(stage, "Main.fxml","ChampionsL");
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CargarCuartos() {
        sorteo = "Cuartos";
        equiposMostrar.clear();

        try {
            //compruebo que el numero de equipos sea correcto
            Statement st = con.createStatement();
            sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 8;
            while (rs.next()) {
                if(numEquipos == rs.getInt(1)){
                    int contadorY = 1;
                    int contadorX = 0;

                    GridPane gridPane = new GridPane();
                    Statement st2 = con.createStatement();
                    String sql2 = "SELECT * FROM Equipo";
                    ResultSet rs2 = st2.executeQuery(sql2);

                    //cargo los equipos en una lista
                    for (int i = 0; i < numEquipos; i++) {
                        rs2.next();
                        lista.add(rs2.getString(1));
                    }
                    //cargo los equipos en una lista de eliminatoria ya sorteados
                    for (int i = 0; i < numEquipos; i++) {
                        random = (int) (Math.random() * lista.size());
                        eliminatoria.add(lista.get(random));
                        if(equiposMostrar.size() < numEquipos){
                            equiposMostrar.add(eliminatoria.get(i));
                        }
                        lista.remove(random);

                        //Creo un label para cada equipo y los añado al gridpane
                        Label label = new Label();
                        label.setText(eliminatoria.get(i)+" ");

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

                    gridPane.add(btnVolver, 1, contadorY+1);
                    GridPane.setHalignment(btnVolver, HPos.CENTER);
                    GridPane.setValignment(btnVolver, VPos.CENTER);

                    //añado un titulo al gridpane
                    Label label = new Label();
                    label.setText("Cuartos de final");
                    label.setFont(new Font("Arial", 20));
                    label.setStyle("-fx-font-weight: bold");
                    gridPane.add(label, 1, 0);

                    //por ultimo muestro la ventana
                    mostrarResultado(btnCuartos, gridPane);

                } else {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error");
                   alert.setHeaderText("Error al realizar el sorteo");
                   alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                   alert.showAndWait();

                   Stage stage = (Stage) btnCuartos.getScene().getWindow();
                   stage.close();

                   cargarVentana(stage, "Main.fxml","ChampionsL");
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void CargarSemis() {
        equiposMostrar.clear();
        sorteo = "Semis";

        try {

            //compruebo que el numero de equipos sea correcto
            Statement st = con.createStatement();
            sql = "SELECT COUNT(*) FROM Equipo";
            ResultSet rs = st.executeQuery(sql);

            int numEquipos = 4;
            while (rs.next()) {
                if(numEquipos == rs.getInt(1)){
                    int contadorY = 1;
                    int contadorX = 0;

                    GridPane gridPane = new GridPane();
                    Statement st2 = con.createStatement();
                    String sql2 = "SELECT * FROM Equipo";
                    ResultSet rs2 = st2.executeQuery(sql2);

                    //cargo los equipos en una lista
                    for (int i = 0; i < numEquipos; i++) {
                        rs2.next();
                        lista.add(rs2.getString(1));
                    }

                    //cargo los equipos en una lista de eliminatoria ya sorteados
                    for (int i = 0; i < numEquipos; i++) {
                        random = (int) (Math.random() * lista.size());
                        eliminatoria.add(lista.get(random));
                        if(equiposMostrar.size() < numEquipos){
                            equiposMostrar.add(eliminatoria.get(i));
                        }
                        lista.remove(random);

                        //Creo un label para cada equipo y los añado al gridpane
                        Label label = new Label();
                        label.setText(eliminatoria.get(i)+" ");

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
                    mostrarResultado(btnCuartos, gridPane);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al realizar el sorteo");
                    alert.setContentText("No coincide el numero de equipos añadidos: "+rs.getInt(1)+" con el numero de equipos necesarios: "+numEquipos);
                    alert.showAndWait();

                    Stage stage = (Stage) btnCuartos.getScene().getWindow();
                    stage.close();

                    cargarVentana(stage, "Main.fxml","ChampionsL");
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarResultado(Button btnCuartos, GridPane gridPane) {
        Stage stage = (Stage) btnCuartos.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(gridPane, 320, 320);
        stage.setTitle("ChampionsL");
        stage.setScene(scene);
        stage.show();
    }
}
