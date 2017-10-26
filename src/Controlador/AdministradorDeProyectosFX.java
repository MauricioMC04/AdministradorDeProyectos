package Controlador;

import Controlador.PersonasController;
import Controlador.PersonasController;
import com.sun.javaws.Main;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AdministradorDeProyectosFX extends Application {
    
    private Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override

    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;   
        
        mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(AdministradorDeProyectosFX.class.getResource("/Vista/Login.fxml"));
            rootPane = loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Login");
            stagePrincipal.setScene(scene);
            LoginControador controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stagePrincipal.show();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
