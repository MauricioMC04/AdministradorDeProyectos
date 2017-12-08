package Controlador;

import Idiomas.Idiomas;
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
    public static int Cedula=0;
    public static int Tipo =0;
    public static Idiomas idioma = new Idiomas("Prueba");
    @FXML
    private void Login(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Vista.fxml"));
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
            double a =stage.getMaxWidth();
            double b = stage.getMaxHeight();
            stage.setMaxHeight(b);
            stage.setMaxWidth(a);
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
            double a =stage.getMaxWidth();
            double b = stage.getMaxHeight();
            stage.setMaxHeight(b);
            stage.setMaxWidth(a);
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
            stage.setTitle("Proyectos");
            stage.setScene(new Scene(root1));
            double a =stage.getMaxWidth();
            double b = stage.getMaxHeight();
            stage.setMaxHeight(b);
            stage.setMaxWidth(a);
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
            double a =stage.getMaxWidth();
            double b = stage.getMaxHeight();
            stage.setMaxHeight(b);
            stage.setMaxWidth(a);
            stage.setMaximized(true);
            stage.show();

        } catch (Exception e) {
            System.out.println("no");

        }
    }
     
     public void EditarProyectos(){
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/EditarProy.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar Proyectos");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println("no");

        }
     }
     
     public void Idioma(){
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Idiomas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Idioma");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println(e);

        }
     }
     
     

    @FXML
    private void TareasDepartamentos(ActionEvent event) {
    }
    

}
