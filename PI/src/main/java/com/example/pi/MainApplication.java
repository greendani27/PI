package com.example.pi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Splash-Screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("ChampionsL");
        stage.setScene(scene);
        stage.show();

        //todo va raro
        SplashScreenController controller = fxmlLoader.getController();
        controller.cargar();
        stage.close();

        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("SignUp.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 320);
        stage.setTitle("ChampionsL");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}