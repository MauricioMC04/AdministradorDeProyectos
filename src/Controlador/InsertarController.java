/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;


public class InsertarController implements Initializable {
    
    private InsertarTareas InsertarT = new InsertarTareas();
    private InsertarDepartamento InsertarD = new InsertarDepartamento();
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    
    private TextField txtTNombreTareas;
    @FXML
    private javafx.scene.control.TextArea txtATDescipcion;
    @FXML
    private Button btnTAceptar;
    @FXML
    private TextField txtDNombreDepartamento;
    @FXML
    private Button btnDAceptar;
    @FXML
    private Tab tabTareasAsignadas;
    @FXML
    private Button btnTMenu;
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
    private Tab tabDepartamentos;
    @FXML
    private Button btnDMenu;
    @FXML
    private Label lblDNombreDepartamento;
    @FXML
    private Label lblDErrorInformacion;
    @FXML
    private Label lblDErrorLetras;
    @FXML
    private TextField txtTNombreTarea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    
    
    private void AgregarTarea(javafx.event.ActionEvent event){
    
        InsertarT.InsertarTarea(txtTNombreTareas.getText(), txtATDescipcion.getText(), conexion);
    }
    
    private void AgregarDepartamento(javafx.event.ActionEvent event){
        
        InsertarD.InsertarDepartamento(txtDNombreDepartamento.getText(), conexion);
    }

    @FXML
    private void Aceptar(ActionEvent event) {
        
        InsertarT.InsertarTarea(txtTNombreTarea.getText(), txtATDescipcion.getText(), conexion);
    }

    @FXML
    private void Agregar(ActionEvent event) {
        
        InsertarD.InsertarDepartamento(txtDNombreDepartamento.getText(), conexion);
    }
    
}
