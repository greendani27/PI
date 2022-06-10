package constants;

import com.example.pi.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class constants {

    public static final String USUARIO = "sql11497844";
    public static final String PASSWORD = "XQXDY78wWG";
    public static final String NOMBD = "sql11497844";
    public static final String URL = "jdbc:mysql:// sql11.freesqldatabase.com:3306/"+NOMBD+"?user="+USUARIO+"&password="+PASSWORD;
    public static String sorteo = "";
    public static ArrayList<String> equiposMostrar = new ArrayList<>();

    public static Connection establecerConexion() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cargarVentana(Stage stage, String name, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(name));
        Scene scene = new Scene(fxmlLoader.load(), 320, 320);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
