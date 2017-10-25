package Controlador;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.PersonasController;
import Controlador.PersonasController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue
 */
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
           
            FXMLLoader loader = new FXMLLoader(AdministradorDeProyectosFX.class.getResource("/Vista/Personas.fxml"));
            rootPane = loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Personas");
            stagePrincipal.setScene(scene);
            PersonasController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stagePrincipal.show();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
       // Vista.Login lo = new Vista.Login();
        //lo.setVisible(true);
        //System.out.println(AdministradorDeProyectosFX.class.getResource("Vista/Personas.fxml"));
    }
    
}
