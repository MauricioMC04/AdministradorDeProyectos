package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController implements Initializable {

    @FXML
    private Button BtnLogin;
    @FXML
    private Button btnPersonas;
    @FXML
    private Button BtnTareasDepartamentos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    public static int Tipo = 0;

    @FXML
    private void Login(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println("no");

        }
        Stage stage = (Stage) BtnLogin.getScene().getWindow();
        stage.close();
    }

    public void Login() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("no");

        }
    }

    @FXML
    public void Personas() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Personas_1.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Usuarios");
            stage.setScene(new Scene(root1));
            stage.setMaximized(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        } catch (Exception e) {
            System.out.println("no");

        }
    }

    public void Proyecto() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Proyectos.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Proyectos");
            stage.setScene(new Scene(root1));
            stage.setMaximized(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        } catch (Exception e) {
            System.out.println("no");

        }
    }

    public void Insertar() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Insertar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Insertar");
            stage.setScene(new Scene(root1));
            stage.setMaximized(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        } catch (Exception e) {
            System.out.println("no");

        }
    }

    public void MisProyectos() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Consultas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Mis Proyectos");
            stage.setScene(new Scene(root1));
            stage.setMaximized(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (Exception e) {
            System.out.println("no");

        }
    }
    
    public void Salir(){
    System.exit(0);
    }

    @FXML
    private void TareasDepartamentos(ActionEvent event) {
    }

}
