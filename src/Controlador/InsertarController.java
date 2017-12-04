/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Idiomas.Idiomas;
import Modelo.Conexion;
import Modelo.InsertarDepartamento;
import Modelo.InsertarTareas;
import java.awt.TextArea;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InsertarController implements Initializable {

    private InsertarTareas InsertarT = new InsertarTareas();
    private InsertarDepartamento InsertarD = new InsertarDepartamento();
    MenuController menu = new MenuController();
    
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();

    private TextField txtTNombreTareas;
    @FXML
    private javafx.scene.control.TextArea txtATDescipcion;
    @FXML
    private Button btnTAceptar;
    private TextField txtDNombreDepartamento;
    @FXML
    private Tab tabTareasAsignadas;
    @FXML
    private Label lblTNombreTareas;
    @FXML
    private Label lblTErrorLetras;
    @FXML
    private Label lblTErrorInformacion;
    @FXML
    private Label lblTSErrorNombre;
    @FXML
    private Label lblTSErrorDescripcion;
    @FXML
    private Label lblTDescripcion;
    @FXML
    private TextField txtTNombreTarea;
    @FXML
    private TextField txtTNombreDep;
    @FXML
    private Button Aceptar;
    @FXML
    private MenuBar MbMenu;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private MenuItem MbCerrarS;
    @FXML
    private Label lblNombreDep;
    @FXML
    private Menu BarMenuNavegar;
    @FXML
    private Menu BarMenuSistema;
    @FXML
    private Tab tabDepartamentos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblTErrorInformacion.setVisible(false);
        lblTErrorLetras.setVisible(false);
        lblTSErrorDescripcion.setVisible(false);
        lblTSErrorNombre.setVisible(false);
        
        

    }

    @FXML
    private void Aceptar(ActionEvent event) {

        InsertarT.InsertarTarea(txtTNombreTarea.getText(), txtATDescipcion.getText(), conexion);
    }

    @FXML
    private void Agregar(ActionEvent event) {

        InsertarD.InsertarDepartamento(txtTNombreDep.getText(), conexion);
    }

    @FXML
    private void Personas(ActionEvent event) {
        menu.Login();
        CodigoR();
    }

    @FXML
    private void Proyectos(ActionEvent event) {
        menu.Login();
        CodigoR();
        
    }

    @FXML
    private void Tareas(ActionEvent event) {
    }

    @FXML
    private void EditProyectos(ActionEvent event) {
         menu.Login();
        CodigoR();
        
      
    }

    @FXML
    private void CerrarS(ActionEvent event) {
        menu.Login();
        CodigoR();
        
    }
    
    private void CodigoR(){
    Scene scene =MbMenu.getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
    }
    
     public void cambiarIdioma(String nombreIdioma){
        
        Idiomas idioma=new Idiomas(nombreIdioma);
        
       lblTNombreTareas.setText(idioma.getProperty("NombreTarea"));
       lblTErrorLetras.setText(idioma.getProperty("SolLetras"));
       lblTDescripcion.setText(idioma.getProperty("Descripcion"));
       lblTErrorInformacion.setText(idioma.getProperty("FaltaInfo"));
       btnTAceptar.setText(idioma.getProperty("Acep"));
       lblNombreDep.setText(idioma.getProperty("NomDep"));
       Aceptar.setText(idioma.getProperty("Acep"));
       BarMenuSistema.setText(idioma.getProperty("Sistema"));
       BarMenuNavegar.setText(idioma.getProperty("Navegar"));
       tabTareasAsignadas.setText(idioma.getProperty("TareaAsig"));
       tabDepartamentos.setText(idioma.getProperty("Dep"));
    }

}
