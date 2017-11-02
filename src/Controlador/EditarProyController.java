/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.EditarProyecto;
import Modelo.Proyecto;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class EditarProyController implements Initializable {

    @FXML
    private TableView<Proyecto> tblProyectos;
    @FXML
    private Label lblNombreP;
    @FXML
    private Label lblSupervisorP;
    @FXML
    private Label lblDepartamento;
    @FXML
    private Label lblFechaE;
    @FXML
    private Label lblTareasP;
    @FXML
    private TextField txtSupervisor;
    @FXML
    private TextField txtDepartamento;
    @FXML
    private DatePicker DatePickerFechaE;
    @FXML
    private Button btnActualizar;
    @FXML
    private TextField txtNombreP;
    @FXML
    private TextField txtTareas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                tblProyectos.getColumns().clear();
       cargarProyectos(tblProyectos);
       
       NoVer();
       
    }    
    
     MenuController menu = new MenuController();
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();

    public void cargarColumnasProyecto(TableView<Proyecto> table) {
        TableColumn tblPNombre = new TableColumn("Nombre");
        tblPNombre.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("Nombre"));
        tblPNombre.setMinWidth(171.25);

        TableColumn tblPFechaInicio = new TableColumn("FechaInicio");
        tblPFechaInicio.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("FechaInicio"));
        tblPFechaInicio.setMinWidth(171.25);

        TableColumn tblPDepartamento = new TableColumn("Departamento");
        tblPDepartamento.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("Departamento"));
        tblPDepartamento.setMinWidth(171.25);

        TableColumn tblPEstado = new TableColumn("Estado");
        tblPEstado.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("Estado"));
        tblPEstado.setMinWidth(171.25);

        TableColumn tblPFechaFinal = new TableColumn("FechaFinal");
        tblPFechaFinal.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("FechaFinal"));
        tblPFechaFinal.setMinWidth(171.25);

        TableColumn tblPSupervisor = new TableColumn("Supervisor");
        tblPSupervisor.setCellValueFactory(new PropertyValueFactory<Proyecto, Integer>("Supervisor"));
        tblPSupervisor.setMinWidth(171.25);

        TableColumn tblPAdministrador = new TableColumn("Administrador");
        tblPAdministrador.setCellValueFactory(new PropertyValueFactory<Proyecto, Integer>("Administrador"));
        tblPAdministrador.setMinWidth(171.25);

        table.getColumns().addAll(tblPNombre, tblPFechaInicio, tblPDepartamento, tblPEstado, tblPFechaFinal, tblPSupervisor, tblPAdministrador);
    }
    EditarProyecto EP = new EditarProyecto();

    public void cargarProyectos(TableView<Proyecto> table) {
        table.setItems(EP.CargarProyecto(conexion));
        cargarColumnasProyecto(table);
    }

    @FXML
    private void Trasladar(MouseEvent event) {
        Proyecto p = tblProyectos.getSelectionModel().getSelectedItem();
      
        if(p!=null){
            Ver();
            txtNombreP.setText(p.getNombre());
            txtDepartamento.setText(p.getDepartamento());
            txtSupervisor.setText(String.valueOf(p.getSupervisor()));
            //FALTAN LA FECHA DE ENTREGA
            
        }
    }
    
    public void NoVer(){
        txtNombreP.setVisible(false);
        txtDepartamento.setVisible(false);
        txtSupervisor.setVisible(false);
        txtTareas.setVisible(false);
        DatePickerFechaE.setVisible(false);
        txtNombreP.setVisible(false);
        lblTareasP.setVisible(false);
        lblNombreP.setVisible(false);
        lblSupervisorP.setVisible(false);
        lblDepartamento.setVisible(false);
        lblFechaE.setVisible(false);
        btnActualizar.setVisible(false);
 
    }
    
    public void Ver(){
        txtNombreP.setVisible(true);
        txtDepartamento.setVisible(true);
        txtSupervisor.setVisible(true);
        txtTareas.setVisible(true);
        DatePickerFechaE.setVisible(true);
        txtNombreP.setVisible(true);
        lblTareasP.setVisible(true);
        lblNombreP.setVisible(true);
        lblSupervisorP.setVisible(true);
        lblDepartamento.setVisible(true);
        lblFechaE.setVisible(true);
        btnActualizar.setVisible(true);
    }

    
}
