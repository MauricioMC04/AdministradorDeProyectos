/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class LoginControador implements Initializable {
Modelo.ModeloLogin ML = new Modelo.ModeloLogin();
   private AdministradorDeProyectosFX ProgramaPrincipal;
    @FXML
    private Pane Login;
    @FXML
    private Button BtnIngresar;
    @FXML
    private Label lblOContraseña;
    @FXML
    private TextField TxtNombreUsuario;
    @FXML
    private Label lblNUsuario;
    @FXML
    private Label lblCont;
    @FXML
    private TextField TxtContraseña;
    @FXML
    private Label lblASLogin1;
    @FXML
    private Label lblASLogin2;
    @FXML
    private Label lblMSLogin1;
    @FXML
    private Label lblNumCedula;
    @FXML
    private TextField TxtValidarCedula;
    @FXML
    private Button btnValidarCedula;
    @FXML
    private Label lblASReg1;
    @FXML
    private Pane PanelRegistrarse;
    @FXML
    private Label lblRNusuario;
    @FXML
    private TextField txtNombreUsuarioRegistrar;
    @FXML
    private Label lblRCont;
    @FXML
    private PasswordField PassFieldContraseñaRegistrarse;
    @FXML
    private Label lblRContras;
    @FXML
    private ComboBox<?> CbxPreguntaSeguridadRegistrarse;
    @FXML
    private Label lblSPregunta;
    @FXML
    private Label lblRespuesta;
    @FXML
    private TextField txtRespuestaRegistrarse;
    @FXML
    private Label lblASReg2;
    @FXML
    private Label lblASReg3;
    @FXML
    private Label lblASReg4;
    @FXML
    private Label lblASReg5;
    @FXML
    private Label lblASReg6;
    @FXML
    private Button btnRegistrarse;
    @FXML
    private Label lblMSReg1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    

    
    public void setProgramaPrincipal(AdministradorDeProyectosFX ProgramaPrincipal) {
    this.ProgramaPrincipal = ProgramaPrincipal;
    }
    @FXML
    private void Ingresar(ActionEvent event) {
       String Nombreusuario = TxtNombreUsuario.getText();
       String Contrasena = TxtContraseña.getText();
        ML.Login(Nombreusuario, Contrasena);
    }

    @FXML
    private void ValidarCedula(ActionEvent event) {
        
    }

    @FXML
    private void Registrarse(ActionEvent event) {
        
    }
    
}
