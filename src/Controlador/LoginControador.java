/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static javax.management.Query.gt;
import static javax.management.Query.lt;

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
    private ComboBox<String> CbxPreguntaSeguridadRegistrarse;
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
    private PasswordField PfContraseñalogin;

    ObservableList<String> options
            = FXCollections.observableArrayList(
                    "1-Nombre de su primera mascota",
                    "2-Nombre del equipo de deporte favorito",
                    "3-¿Donde encontrar un tesoro pirata?",
                    "4-Super heroe Favorito"
            );
    @FXML
    private PasswordField PsContraseñaCorrecta;
    @FXML
    private PasswordField PfCambiarC1;
    @FXML
    private PasswordField PfCambiarC2;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Pane Pane2;
    @FXML
    private Pane Pane1;
    @FXML
    private Pane Pane3;
    @FXML
    private Button btnConfirmarPane2;
    @FXML
    private TextField TxtRespuestaPane2;
    @FXML
    private TextField txtCedula;
    @FXML
    private Label lblVolvrt;
    @FXML
    private Label LblErrorOlvido1;
    @FXML
    private Label lblCamposIOlvido;
    @FXML
    private Label LblErrorOlvido2;
    @FXML
    private Label LblErrorIgual;
    @FXML
    private Label lblMSReg3;

    public void initialize(URL url, ResourceBundle rb) {

        CbxPreguntaSeguridadRegistrarse.setItems(options);
        CbxPreguntaSeguridadRegistrarse.setTooltip(new Tooltip("Seleccion la pregunta de seguridad"));

    }

    public void setProgramaPrincipal(AdministradorDeProyectosFX ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @FXML
    private void Ingresar(ActionEvent event) {
        String Nombreusuario = TxtNombreUsuario.getText();
        String Contrasena = PfContraseñalogin.getText();
        if (ML.Login(Nombreusuario, Contrasena)) {
            menu.Personas();
            Stage stage = (Stage) BtnIngresar.getScene().getWindow();
            stage.close();
        } else {
            lblASLogin1.setVisible(true);
            lblASLogin2.setVisible(true);
            lblMSLogin1.setVisible(true);
            PfContraseñalogin.setText("");
        }
    }

    @FXML
    private void ValidarCedula(ActionEvent event) {
        int cedula = Integer.parseInt(TxtValidarCedula.getText());
        if (ML.ValidarCedula(cedula) == true) {
            PanelRegistrarse.setVisible(true);
            lblMSReg2.setVisible(false);
        } else {
            lblMSReg2.setVisible(true);
            PanelRegistrarse.setVisible(false);
        }
    }

    @FXML
    private void Registrarse(ActionEvent event) {
        lblMSReg1.setVisible(false);
        lblASReg3.setVisible(false);
        lblASReg5.setVisible(false);
        lblMSReg3.setVisible(false);
        lblASReg2.setVisible(false);

        String NombreUsuario = String.valueOf(txtNombreUsuarioRegistrar.getText());
        String Contrasena = PassFieldContraseñaRegistrarse.getText();
        String Respuesta = txtRespuestaRegistrarse.getText();
        String Contrasena2 = PsContraseñaCorrecta.getText();
        String a = String.valueOf(CbxPreguntaSeguridadRegistrarse.getSelectionModel().getSelectedItem());
        if (ML.ValidarNombreusuario(NombreUsuario) == true && (ValidarIguales(Contrasena, Contrasena2) == true)) {

            int cedula = Integer.parseInt(TxtValidarCedula.getText());
            if (a != "") {
                String[] partes = a.split("-");
                String partes1 = partes[0];
                String partes2 = partes[1];
                if (ML.Registrar(cedula, NombreUsuario, Contrasena, Respuesta, Integer.parseInt(partes1)) == true) {
                    PanelRegistrarse.setVisible(false);
                    TxtValidarCedula.setText("");
                    lblMSReg1.setVisible(false);
                } else {
                    lblMSReg2.setVisible(true);
                    PanelRegistrarse.setVisible(false);
                    TxtValidarCedula.setText("");
                    lblMSReg1.setVisible(true);
                    lblASReg2.setVisible(false);

                }
            }

        } else {
            if (ValidarIguales(Contrasena, Contrasena2) == false) {
                lblMSReg1.setVisible(true);
                lblASReg3.setVisible(true);
                lblASReg5.setVisible(true);
            }
            if (ML.ValidarNombreusuario(NombreUsuario) == false) {
                lblMSReg3.setVisible(true);
                lblASReg2.setVisible(true);
            }

        }
    }

    @FXML
    private void Olvido(MouseEvent event) {
        Pane1.setVisible(false);
        Pane2.setVisible(true);
        lblVolvrt.setVisible(true);
        btnConfirmarPane2.setVisible(true);
        lblASLogin1.setVisible(false);
        lblASLogin2.setVisible(false);
        lblMSLogin1.setVisible(false);
    }

    @FXML
    private void ValidarNumeros(KeyEvent event) {
    }

    @FXML
    private void ConfirmarCambio(ActionEvent event) {
        int Cedula = Integer.parseInt(txtCedula.getText());
        String Contrasena = PfCambiarC1.getText();
        String Contrasena2 = PfCambiarC2.getText();
        if (ValidarIguales(Contrasena, Contrasena2) == true) {
            ML.CambiarContraseña(Contrasena, Cedula);
            Pane2.setVisible(false);
            Pane3.setVisible(false);
            Pane1.setVisible(true);
            TxtRespuestaPane2.setText("");
            txtCedula.setText("");
            txtCedula.setText("");
            PfCambiarC1.setText("");
            PfCambiarC2.setText("");
            LblErrorIgual.setVisible(false);
        } else {
            LblErrorIgual.setVisible(true);
        }
    }

    @FXML
    private void ValidarRespuesta(ActionEvent event) {
        if (!(txtCedula.getText().equals("") || TxtRespuestaPane2.getText().equals(""))) {
            int Cedula = Integer.parseInt(txtCedula.getText());
            String Respuesta = String.valueOf(TxtRespuestaPane2.getText());
            if (ML.ValidarCambioContraseña(Cedula, Respuesta) == true) {
                btnConfirmarPane2.setVisible(false);
                Pane3.setVisible(true);
                LblErrorOlvido1.setVisible(false);
                LblErrorOlvido2.setVisible(false);
                lblCamposIOlvido.setVisible(false);
            }
        } else {
            LblErrorOlvido1.setVisible(true);
            LblErrorOlvido2.setVisible(true);
            lblCamposIOlvido.setVisible(true);
        }

    }

    @FXML
    private void Volver(MouseEvent event) {
        lblVolvrt.setVisible(false);
        Pane1.setVisible(true);
        Pane2.setVisible(false);
        Pane3.setVisible(false);
        TxtRespuestaPane2.setText("");
        txtCedula.setText("");

    }

    private boolean ValidarIguales(String a, String b) {

        if (b.equals(a)) {
            return true;
        }
        return false;
    }
}
