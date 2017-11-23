/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Departamento;
import Modelo.EditarProyecto;
import Modelo.Proyecto;
import Modelo.Tarea;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private Pane pnlEditarProyecto;
    @FXML
    private Pane pnlEditarTarea;
    @FXML
    private Pane pnlEditarDepartamento;
    @FXML
    private Label lblBuscarTarea;
    @FXML
    private TextField txtBusquedaTarea;
    @FXML
    private TableView<Tarea> tblTareas;
    @FXML
    private Label lblNombreTarea;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Button btnEditarTarea;
    @FXML
    private Button btnEliminarTarea;
    @FXML
    private TextArea txtDescripcionTarea;
    @FXML
    private TextField txtNombreTarea;
    @FXML
    private TableView<Departamento> tblDepartamentos;
    @FXML
    private Label lblBuscarDepartamento;
    @FXML
    private TextField txtBusquedaDepartamento;
    @FXML
    private Label lblNombreDepartamento;
    @FXML
    private TextField txtNombreDepartamento;
    @FXML
    private Button btnEditarDepartamento;
    @FXML
    private Button btnEliminarDepartamento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblProyectos.getColumns().clear();
        cargarProyectos(tblProyectos);
        NoVer();
        porDefectoTareas();
        porDefectoDepartamentos();
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
        
        if (p != null) {
            Ver();
            txtNombreP.setText(p.getNombre());
            txtDepartamento.setText(p.getDepartamento());
            txtSupervisor.setText(String.valueOf(p.getSupervisor()));
            //FALTAN LA FECHA DE ENTREGA

        }
    }
    EditarProyecto E = new EditarProyecto();
    
    public void ActualizaProyecto() {
        Proyecto p = tblProyectos.getSelectionModel().getSelectedItem();
        String N = p.getNombre();
        String D = p.getDepartamento();
        E.EditarProyecto(txtNombreP.getText(), txtDepartamento.getText(), txtSupervisor.getText(), N, D, conexion);
        ActualizarTabla(tblProyectos);
        Refrescar();
    }

    public void ActualizarTabla(TableView<Proyecto> table) {
        table.setItems(EP.CargarProyecto(conexion));
        
    }

    public void Refrescar() {
        txtNombreP.setText("");
        txtDepartamento.setText("");
        txtSupervisor.setText("");
        
    }
    
    public void NoVer() {
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
    
    public void Ver() {
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
    
    @FXML
    private void EditarProyectoEnBase(ActionEvent event) {
        ActualizaProyecto();
    }

    /*
    Nombre de metodo: BuscarTarea
    Parametros: KeyEvent event
    Retorno: Ninguno
    Descripcion: Carga las tareas segun la busqueda
    */
    @FXML
    private void BuscarTarea(KeyEvent event) {
        tblTareas.getColumns().clear();
        if(txtBusquedaTarea.getText().equals("")){
            porDefectoTareas();
        }else{
            MostrarParteTarea(false);
            CargarTareas(tblTareas, conexion, txtBusquedaTarea.getText());
        }
    }

    /*
    Nombre de metodo: EditarTarea
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Llama al metodo para editar la tarea seleccionada
    */
    @FXML
    private void EditarTarea(ActionEvent event) {
        Tarea tarea = tblTareas.getSelectionModel().getSelectedItem();
        if(tarea != null){
            if(!txtNombreTarea.getText().equals("") && !txtDescripcionTarea.getText().equals("")){
                E.EditarTarea(tarea, txtNombreTarea.getText(), txtDescripcionTarea.getText(), conexion);
                porDefectoTareas();
            }
        }
    }

    /*
    Nombre de metodo: EliminarTarea
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Llama al metodo para eliminar la tarea seleccionada
    */
    @FXML
    private void EliminarTarea(ActionEvent event) {
        Tarea tarea = tblTareas.getSelectionModel().getSelectedItem();
        if(tarea != null){
            E.EliminarTarea(tarea, conexion);
            porDefectoTareas();
        }
    }

    /*
    Nombre de metodo: BuscarDepartamento
    Parametros: KeyEvent event
    Retorno: Ninguno
    Descripcion: Carga los departamentos segun la busqueda
    */
    @FXML
    private void BuscarDepartamento(KeyEvent event) {
        tblDepartamentos.getColumns().clear();
        if(txtBusquedaDepartamento.getText().equals("")){
            porDefectoDepartamentos();
        }else{
            MostrarParteDepartamentos(false);
            CargarDepartamentos(tblDepartamentos, conexion, txtBusquedaDepartamento.getText());
        }
    }

    /*
    Nombre de metodo: EditarDepartamento
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Llama al metodo para editar el departamento seleccionado
    */
    @FXML
    private void EditarDepartamento(ActionEvent event) {
        Departamento departamento = tblDepartamentos.getSelectionModel().getSelectedItem();
        if(departamento != null){
            if(!txtNombreDepartamento.getText().equals("")){
                E.EditarDepartamento(departamento, txtNombreDepartamento.getText(), conexion);
                porDefectoDepartamentos();
            }
        }
    }

    /*
    Nombre de metodo: EliminarDepartamento
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Llama al metodo para eliminar el departamento seleccionado
    */
    @FXML
    private void EliminarDepartamento(ActionEvent event) {
        Departamento departamento = tblDepartamentos.getSelectionModel().getSelectedItem();
        if(departamento != null){
            E.EliminarDepartamento(departamento, conexion);
            porDefectoDepartamentos();
        }
    }
    
    /*
    Nombre de metodo: porDefectoTareas
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Restaura la vista de Tareas
    */
    private void porDefectoTareas(){
        MostrarParteTarea(false);
        tblTareas.getColumns().clear();
        CargarTareas(tblTareas, conexion, "Ninguna");
    }
    
    /*
    Nombre de metodo: MostrarParteTarea
    Parametros: boolean bandera
    Retorno: Ninguno
    Descripcion: Muestra u oculta la parte de editar una tarea
    */
    private void MostrarParteTarea(boolean bandera){
        lblNombreTarea.setVisible(bandera);
        txtNombreTarea.setVisible(bandera);
        lblDescripcion.setVisible(bandera);
        txtDescripcionTarea.setVisible(bandera);
        btnEditarTarea.setVisible(bandera);
        btnEliminarTarea.setVisible(bandera);
    }
    
    /*
    Nombre de metodo: CargarTareas
    Parametros: TableView<Tarea> table, Connection conexion, String busqueda
    Retorno: Ninguno
    Descripcion: Carga en la tabla las tareas que se pueden editar
    */
    private void CargarTareas(TableView<Tarea> table, Connection conexion, String busqueda){
        table.setItems(E.CargarTareas(busqueda, conexion));
        cargarColumnasTareas(table);
    }
    
    /*
    Nombre de metodo: cargarColumnasTareas
    Parametros: TableView<Tarea> table
    Retorno: Ninguno
    Descripcion: Carga las columnas en la tabla para mostrar las tareas
    */
    private void cargarColumnasTareas(TableView<Tarea> table) {
        TableColumn tblCNombre = new TableColumn("Nombre");
        tblCNombre.setCellValueFactory(new PropertyValueFactory<Tarea, String>("Nombre"));
        tblCNombre.setMinWidth(367.5);
        TableColumn tblCDescripcion = new TableColumn("Descripcion");
        tblCDescripcion.setCellValueFactory(new PropertyValueFactory<Tarea, String>("Descripcion"));
        tblCDescripcion.setMinWidth(367.5);
        table.getColumns().addAll(tblCNombre, tblCDescripcion);
    }

    /*
    Nombre de metodo: MostrarTarea
    Parametros: MouseEvent event
    Retorno: Ninguno
    Descripcion: Muestra la informacion de la tarea seleccionada
    */
    @FXML
    private void MostrarTarea(MouseEvent event) {
        Tarea tarea = tblTareas.getSelectionModel().getSelectedItem();
        if(tarea != null){
            MostrarParteTarea(true);
            txtNombreTarea.setText(tarea.getNombre());
            txtDescripcionTarea.setText(tarea.getDescripcion());
        }else{
            MostrarParteTarea(false);
        }
    }

    /*
    Nombre de metodo: MostrarDepartamento
    Parametros: MouseEvent event
    Retorno: Ninguno
    Descripcion: Muestra la informacion del departamento seleccionado
    */
    @FXML
    private void MostrarDepartamento(MouseEvent event) {
        Departamento departamento = tblDepartamentos.getSelectionModel().getSelectedItem();
        if(departamento != null){
            MostrarParteDepartamentos(true);
            txtNombreDepartamento.setText(departamento.getNombre());
        }else{
            MostrarParteDepartamentos(false);
        }
    }
    
    /*
    Nombre de metodo: porDefectoDepartamentos
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Restaura la vista de Departamentos
    */
    private void porDefectoDepartamentos(){
        MostrarParteDepartamentos(false);
        tblDepartamentos.getColumns().clear();
        CargarDepartamentos(tblDepartamentos, conexion, "Ninguna");
    }
    
    /*
    Nombre de metodo: MostrarParteDepartamentos
    Parametros: boolean bandera
    Retorno: Ninguno
    Descripcion: Muestra u oculta la parte para editar departamentos
    */
    private void MostrarParteDepartamentos(boolean bandera){
        lblNombreDepartamento.setVisible(bandera);
        txtNombreDepartamento.setVisible(bandera);
        btnEditarDepartamento.setVisible(bandera);
        btnEliminarDepartamento.setVisible(bandera);
    }
    
    /*
    Nombre de metodo: CargarDepartamentos
    Parametros: TableView<Departamento> table, Connection conexion, String busqueda
    Retorno: Ninguno
    Descripcion: Cargar en la tabla los departamentos que se pueden editar 
    */
     private void CargarDepartamentos(TableView<Departamento> table, Connection conexion, String busqueda){
        table.setItems(E.CargarDepartamentos(busqueda, conexion));
        cargarColumnasDepartamentos(table);
    }
    
    /*
    Nombre de metodo: cargarColumnasDepartamentos
    Parametros: TableView<Departamento> table
    Retorno: Ninguno
    Descripcion: Cargar las columnas en la tabla para mostrar los departamentos 
    */
    private void cargarColumnasDepartamentos(TableView<Departamento> table) {
        TableColumn tblCNombre = new TableColumn("Nombre");
        tblCNombre.setCellValueFactory(new PropertyValueFactory<Departamento, String>("Nombre"));
        tblCNombre.setMinWidth(601);
        table.getColumns().addAll(tblCNombre);
    }
}
