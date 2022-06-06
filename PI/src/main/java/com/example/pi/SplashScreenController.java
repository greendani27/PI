package com.example.pi;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public class SplashScreenController {

    final int tiempoEspera = 15;
    @FXML
    private ProgressBar progressBar;

    // Hacer que el progressBar avance de 0 a 100 en 10 segundos
    public void cargar() {
        /*new Thread() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(tiempoEspera);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setProgress(i / 100.0);
                }
            }
        }.start();*/

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(tiempoEspera);
                progressBar.setProgress(i / 100.0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}