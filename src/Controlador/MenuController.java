
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


public class MenuController implements Initializable {

    @FXML
    private Button BtnLogin;
    @FXML
    private Button btnPersonas;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

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

    @FXML
    private void Personas(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/Personas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Usuarios");
            stage.setScene(new Scene(root1));
            stage.show();
            
        } catch (Exception e) {
            System.out.println("no");

        }
        Stage stage = (Stage) BtnLogin.getScene().getWindow();
        stage.close();
       }
    
}