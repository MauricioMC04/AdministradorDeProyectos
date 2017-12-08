/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Idiomas.Idiomas;
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
    @FXML
    private Button Idioma;
    @FXML
    private ComboBox<String> cmbIdiomas;
  Idiomas idioma = MenuController.idioma;
    public void initialize(URL url, ResourceBundle rb) {
        cambiarIdioma();
        CbxPreguntaSeguridadRegistrarse.setItems(options);
        CbxPreguntaSeguridadRegistrarse.setTooltip(new Tooltip("Seleccione la pregunta de seguridad"));
        CargarIdiomas();
    }
    
    
    public void cambiarIdioma(){
    BtnIngresar.setText(idioma.getProperty("Ingreso")); 
    Idioma.setText(idioma.getProperty("Idioma")); 
    lblOContraseña.setText(idioma.getProperty("Idioma")); 
    TxtNombreUsuario.setPromptText(idioma.getProperty("NombreUsuario"));
   PfContraseñalogin.setPromptText(idioma.getProperty("Contra"));
   lblNumCedula.setText(idioma.getProperty("Cedula"));
   btnValidarCedula.setText(idioma.getProperty("Acep"));
   lblNumCedula.setText(idioma.getProperty("Cedula"));
   lblRNusuario.setText(idioma.getProperty("NombreUsuario"));
   lblRCont.setText(idioma.getProperty("Contra"));
   lblRContras.setText(idioma.getProperty("Contra"));
   lblSPregunta.setText(idioma.getProperty("PreguntaSeguridad"));
   lblRespuesta.setText(idioma.getProperty("Respuesta"));
   
   
    }
    

    public void setProgramaPrincipal(AdministradorDeProyectosFX ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @FXML
/*
    Nombre de metodo: Ingresar
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Ingresa al sistema, valida que tipo de usuario es que el ingreso y setea la variable global
    */
    private void Ingresar(ActionEvent event) {
        String Nombreusuario = TxtNombreUsuario.getText();
        String Contrasena = PfContraseñalogin.getText();
        Stage stage = (Stage) BtnIngresar.getScene().getWindow();
        int resultado = ML.Login(Nombreusuario, Contrasena);
        switch (resultado) {
            case 1:
                MenuController.Tipo = 1;
                menu.Personas();
                lblASLogin1.setVisible(true);
                lblASLogin2.setVisible(true);
                lblMSLogin1.setVisible(true);
                PfContraseñalogin.setText("");
                break;
            case 2:
                MenuController.Tipo = 2;
                menu.MisProyectos();
                break;
            case 3:
            MenuController.Tipo = 3;
                menu.MisProyectos();
                break;
            case 4:
                lblASLogin1.setVisible(true);
                lblASLogin2.setVisible(true);
                lblMSLogin1.setVisible(true);
                PfContraseñalogin.setText("");
                break;
        }
        stage.close();
    }


//private void Ingresar(ActionEvent event) {
//        String Nombreusuario = TxtNombreUsuario.getText();
//        String Contrasena = PfContraseñalogin.getText();
//        if (ML.Login(Nombreusuario, Contrasena) == 1) {
//           MenuController.Tipo = 1;
//            menu.Personas();
//            Stage stage = (Stage) BtnIngresar.getScene().getWindow();
//            stage.close();
//        } else {
//            if (ML.Login(Nombreusuario, Contrasena) == 2) {
//                MenuController.Tipo = 2;
//                menu.MisProyectos();
//                Stage stage = (Stage) BtnIngresar.getScene().getWindow();
//                stage.close();
//            } else {
//
//                if (ML.Login(Nombreusuario, Contrasena) == 3) {
//                    MenuController.Tipo = 3;
//                    menu.MisProyectos();
//                    Stage stage = (Stage) BtnIngresar.getScene().getWindow();
//                    stage.close();
//                } else {
//                    lblASLogin1.setVisible(true);
//                    lblASLogin2.setVisible(true);
//                    lblMSLogin1.setVisible(true);
//                    PfContraseñalogin.setText("");
//                }
//            }
//        }
//    }
//    
    
    @FXML
    /*
    Nombre de metodo: ValidarCedula
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Verifica los datos insertados para registrarse
    */
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

        /*
    Nombre de metodo: Registrarse
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Verifica e inserta los datos proporcionados por el usuario
    */
        
        
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
        /*
    Nombre de metodo: Olvido
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Muestra el panel correspondiente a la accion de olvidar contraseña
    */

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
        /*
    Nombre de metodo: ConfirmarCambio
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Verifica los para realizar un cambio en la contraseña
    */

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
/*
    Nombre de metodo: ValidarRespuesta
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Verifica la respuesta proporcionada por el usuario para cambiar la contraseña
    */
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

    @FXML
    private void Idioma(ActionEvent event) {
        menu.Idioma();
        Scene scene = Idioma.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
        
    }

    /*
    Nombre de metodo: CargarIdiomas
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Carga sobre el comboBox los idiomas disponibles 
    */
    public void CargarIdiomas(){
        cmbIdiomas.getItems().clear();
        cmbIdiomas.setItems(ML.CargarIdiomas());
    }

    /*
    Nombre de metodo: CambioIdioma
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Cambia la variable static segun el idioma seleccionado
    */
    @FXML
    private void CambioIdioma(ActionEvent event) {
        String idioma = cmbIdiomas.getSelectionModel().getSelectedItem();
        if(idioma != null && !idioma.equals("")){
            MenuController.idioma = new Idiomas(idioma);
        }
    }
}