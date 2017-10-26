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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class ProyectosController implements Initializable {
MenuController menu = new MenuController();
    @FXML
    private Label lblNombreProyecto;
    @FXML
    private Label lblCreadoPor;
    @FXML
    private Label lblIteraciones;
    @FXML
    private Label lblDepartamento;
    @FXML
    private Label lblFechaInicio;
    @FXML
    private Label lblFechaEntrega;
    @FXML
    private Label lblTareas;
    @FXML
    private ComboBox<?> txtDepartamento;
    @FXML
    private ComboBox<?> cbxTareas;
    @FXML
    private DatePicker txtDatePickerInicio;
    @FXML
    private DatePicker txtDatePickerFinal;
    @FXML
    private TextField txtNombreProyecto;
    @FXML
    private ComboBox<?> cbxCreadoPor;
    @FXML
    private Button btnGuardarProyecto;
    @FXML
    private ComboBox<?> cbxIteraciones;
    @FXML
    private MenuBar MbMenu;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private MenuItem MbCerrarS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Personas(ActionEvent event) {
         menu.Personas();
      Scene scene =MbMenu.getScene();
      Stage stage = (Stage) scene.getWindow();
      stage.close(); 
    }

    @FXML
    private void Proyectos(ActionEvent event) {
    }

    @FXML
    private void Tareas(ActionEvent event) {
    }

    @FXML
    private void EditProyectos(ActionEvent event) {
    }

    @FXML
    private void Departamentos(ActionEvent event) {
    }

    @FXML
    private void CerrarS(ActionEvent event) {
          menu.Login();
        Scene scene =MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
        
    }
    
    
    
}
