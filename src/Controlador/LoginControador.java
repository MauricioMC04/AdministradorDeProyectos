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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class LoginControador implements Initializable {

    Modelo.ModeloLogin ML = new Modelo.ModeloLogin();
    AdministradorDeProyectosFX AFX = new AdministradorDeProyectosFX();
    MenuController menu = new MenuController();
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
    @FXML
    private Label lblMSReg2;
    @FXML
    private TabPane PanelLogin;
    @FXML
    private ChoiceBox<?> CbPreguntaRegistrar;
    @FXML
    private PasswordField PfContraseñalogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblASLogin1.setVisible(false);
        lblASLogin2.setVisible(false);
        lblMSLogin1.setVisible(false);
        lblMSReg2.setVisible(false);
        lblMSReg1.setVisible(false);
        lblASReg1.setVisible(false);
        lblASReg2.setVisible(false);
        lblASReg3.setVisible(false);
        lblASReg4.setVisible(false);
        lblASReg5.setVisible(false);
        lblASReg6.setVisible(false);
        PanelRegistrarse.setVisible(false);

    }

    public void setProgramaPrincipal(AdministradorDeProyectosFX ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @FXML
    private void Ingresar(ActionEvent event) {
        String Nombreusuario = TxtNombreUsuario.getText();
        String Contrasena = PfContraseñalogin.getText();
       if( ML.Login(Nombreusuario, Contrasena)){
        menu.Personas();
        Stage stage = (Stage) BtnIngresar.getScene().getWindow();
        stage.close();
       }
    }

    @FXML
    private void ValidarCedula(ActionEvent event) {
        int cedula = Integer.parseInt(TxtValidarCedula.getText());
        if (ML.ValidarCedula(cedula) == true) {
            PanelRegistrarse.setVisible(true);
        } else {
            lblMSReg2.setVisible(true);
        }
    }

    @FXML
    private void Registrarse(ActionEvent event) {
        int cedula = Integer.parseInt(TxtValidarCedula.getText());
        String NombreUsuario = String.valueOf(txtNombreUsuarioRegistrar.getText());
        String Contrasena = PassFieldContraseñaRegistrarse.getText();
        String Pregunta = txtRespuestaRegistrarse.getText();

        ML.Registrar(cedula, NombreUsuario, Contrasena, Pregunta);
    }
    @FXML
    private void Olvido(MouseEvent event) {
    }

}
