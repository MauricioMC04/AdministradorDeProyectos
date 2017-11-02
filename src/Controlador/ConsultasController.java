package Controlador;

import Modelo.Conexion;
import Modelo.DatosConsultas;
import Modelo.Proyecto;
import Modelo.ProyectoConsulta;
import Modelo.Usuario;
import Modelo.Usuario_has_Tareas;
import java.net.URL;
import java.sql.Connection;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConsultasController implements Initializable {

    DatosConsultas datosConsultas = new DatosConsultas();
    MenuController menu = new MenuController();
    int rol = MenuController.Tipo;
    int cedula = MenuController.Cedula;
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    @FXML
    private MenuBar MbMenu;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private MenuItem MbCerrarS;
    @FXML
    private MenuItem MbMisProyectos;
    @FXML
    private MenuItem MbSalirS;
    @FXML
    private TableView<ProyectoConsulta> tblProyectos;
    @FXML
    private RadioButton rbtnSupervisor;
    @FXML
    private RadioButton rbtnDepartamento;
    @FXML
    private RadioButton rbtnEstado;
    @FXML
    private Button btnBusqueda;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private Label lblProyecto;
    @FXML
    private Label lblDepartamento;
    @FXML
    private Label lblNombreProyecto;
    @FXML
    private Label lblNombreDepartamento;
    @FXML
    private TableView<Usuario_has_Tareas> tblTarea;
    @FXML
    private ToggleGroup rbtngFiltros;
    @FXML
    private RadioButton rbtnProyecto;
    @FXML
    private ComboBox<String> cmbEstados;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnCargarTodos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (MenuController.Tipo == 3) {
            MPersonas.setDisable(true);
            //MProyectos.setDisable(true);
            //MPEdittar.setDisable(true);
            //MPtareas.setDisable(true);
        }
        ocultar();
        cargarProyectos(tblProyectos, cedula, rol, conexion);
        ObservableList<String> estados = FXCollections.observableArrayList();
        estados.addAll("No Implementada");
        estados.addAll("En Proceso");
        estados.addAll("Implementada");
        cmbEstados.setItems(estados);
    }

    @FXML
    private void Personas(ActionEvent event) {
    }

    @FXML
    private void Proyectos(ActionEvent event) {
        menu.Proyecto();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    private void Tareas(ActionEvent event) {
        menu.Insertar();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    private void EditProyectos(ActionEvent event) {
    }

    @FXML
    private void CerrarS(ActionEvent event) {
        menu.Login();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }


    @FXML
    private void Irproyectos(ActionEvent event) {
    }

    @FXML
    private void MostrarTareas(MouseEvent event) {
        ProyectoConsulta proyecto = tblProyectos.getSelectionModel().getSelectedItem();
        if(proyecto != null){
            mostrarParteTareas(proyecto);
            cargarTareas(tblTarea, proyecto , cedula, rol, conexion);
        }else{
            ocultar();
        }
    }

    @FXML
    private void Buscar(ActionEvent event) {
        if(!txtBusqueda.getText().equals("")){
            ocultar();
            if(rbtnDepartamento.isSelected()){
                cargarProyectosBusqueda(tblProyectos, cedula, rol,rbtnDepartamento.getText(), txtBusqueda.getText(), conexion);
            }else if(rbtnEstado.isSelected()){
                cargarProyectosBusqueda(tblProyectos, cedula, rol,rbtnEstado.getText(), txtBusqueda.getText(), conexion);
            }else if(rbtnProyecto.isSelected()){
                cargarProyectosBusqueda(tblProyectos, cedula, rol,rbtnProyecto.getText(), txtBusqueda.getText(), conexion);
            }else if(rbtnSupervisor.isSelected()){
                cargarProyectosBusqueda(tblProyectos, cedula, rol,rbtnSupervisor.getText(), txtBusqueda.getText(), conexion);
            }
            Vaciar();
        }
    }

    @FXML
    private void Editar(ActionEvent event) {
        Usuario_has_Tareas tarea = tblTarea.getSelectionModel().getSelectedItem();
        if(tarea != null){
            datosConsultas.Editar(tarea, cmbEstados.getSelectionModel().getSelectedItem(), conexion);
            ProyectoConsulta proyecto = tblProyectos.getSelectionModel().getSelectedItem();
            mostrarParteTareas(proyecto);
            tblTarea.getColumns().clear();
            cargarTareas(tblTarea, proyecto , cedula, rol, conexion);
        }
    }
    
    private void ocultar(){
        lblProyecto.setVisible(false);
        lblDepartamento.setVisible(false);
        lblNombreProyecto.setVisible(false);
        lblNombreDepartamento.setVisible(false);
        cmbEstados.setVisible(false);
        btnEditar.setVisible(false);
        tblTarea.setVisible(false);
        if(rol == 2 || rol == 3){
            Filtros(false);
        }else{
            Filtros(true);
        }
    }
    
    private void Filtros(boolean bandera){
        rbtnDepartamento.setVisible(bandera);
        rbtnEstado.setVisible(bandera);
        rbtnProyecto.setVisible(bandera);
        rbtnSupervisor.setVisible(bandera);
        txtBusqueda.setVisible(bandera);
        btnBusqueda.setVisible(bandera);
        btnCargarTodos.setVisible(bandera);
    }
    
    private void cargarProyectos(TableView<ProyectoConsulta> table, int cedula, int rol, Connection conexion){
        table.setItems(datosConsultas.CargarProyectos(cedula, rol, conexion));
        if(rol == 3){
            cargarColumnasEmpleado(table);
        }else{
            cargarColumnas(table, rol);
        } 
    }
    
    private void cargarColumnas(TableView<ProyectoConsulta> table, int rol) {
        TableColumn tblCNombre = new TableColumn("Nombre");
        tblCNombre.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Nombre"));
        tblCNombre.setMinWidth(98.42);
        TableColumn tblCDepartamento = new TableColumn("Departamento");
        tblCDepartamento.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Departamento"));
        tblCDepartamento.setMinWidth(98.42);
        TableColumn tblCFechaI = new TableColumn("Fecha Inicio");
        tblCFechaI.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("FechaInicio"));
        tblCFechaI.setMinWidth(98.42);
        TableColumn tblCFechaF = new TableColumn("Fecha Final");
        tblCFechaF.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("FechaFinal"));
        tblCFechaF.setMinWidth(98.42);
        TableColumn tblCEstado = new TableColumn("Estado");
        tblCEstado.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Estado"));
        tblCEstado.setMinWidth(98.42);
        TableColumn tblCAdministrador = new TableColumn("Administrador");
        tblCAdministrador.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Administrador"));
        tblCAdministrador.setMinWidth(98.42);
        TableColumn tblCSupervisor = new TableColumn("Supervisor");
        tblCSupervisor.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Supervisor"));
        tblCSupervisor.setMinWidth(98.42);
        table.getColumns().addAll(tblCNombre, tblCDepartamento, tblCFechaI, tblCFechaF, tblCAdministrador, tblCSupervisor, tblCEstado);
    }
    
    private void cargarColumnasEmpleado(TableView<ProyectoConsulta> table) {
        TableColumn tblCNombre = new TableColumn("Nombre");
        tblCNombre.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Nombre"));
        tblCNombre.setMinWidth(344.5);
        TableColumn tblCDepartamento = new TableColumn("Departamento");
        tblCDepartamento.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Departamento"));
        tblCDepartamento.setMinWidth(344.5);
        table.getColumns().addAll(tblCNombre, tblCDepartamento);
    }
    
    private void mostrarParteTareas(ProyectoConsulta proyecto){
        lblProyecto.setVisible(true);
        lblDepartamento.setVisible(true);
        lblNombreProyecto.setVisible(true);
        lblNombreDepartamento.setVisible(true);
        tblTarea.setVisible(true);
        lblNombreProyecto.setText(proyecto.getNombre());
        lblNombreDepartamento.setText(proyecto.getDepartamento());
        if(rol == 2 || rol == 3){
            cmbEstados.setVisible(true);
            btnEditar.setVisible(true);
        }else{
            cmbEstados.setVisible(false);
            btnEditar.setVisible(false);
        }
    }
    
    private void cargarTareas(TableView<Usuario_has_Tareas> table, ProyectoConsulta proyecto ,int cedula, int rol, Connection conexion){
        table.setItems(datosConsultas.CargarTareas(proyecto, cedula, rol, conexion));
        cargarColumnasTareas(table);
    }

    private void cargarColumnasTareas(TableView<Usuario_has_Tareas> table) {
        TableColumn tblCTarea = new TableColumn("Tarea");
        tblCTarea.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Tarea"));
        tblCTarea.setMinWidth(177);
        TableColumn tblCEmpleado = new TableColumn("Empleado");
        tblCEmpleado.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Empleado"));
        tblCEmpleado.setMinWidth(177);
        TableColumn tblCEstado = new TableColumn("Estado");
        tblCEstado.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Estado"));
        tblCEstado.setMinWidth(177);
        TableColumn tblCIteraciones = new TableColumn("Iteraciones");
        tblCIteraciones.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Iteraciones"));
        tblCIteraciones.setMinWidth(177);
        table.getColumns().addAll(tblCTarea, tblCEmpleado, tblCEstado, tblCIteraciones);
    }
    
    private void cargarProyectosBusqueda(TableView<ProyectoConsulta> table, int cedula, int rol, String filtro, String dato, Connection conexion){
        table.getColumns().clear();
        table.setItems(datosConsultas.CargarProyectosBusqueda(cedula, rol, filtro, dato, conexion));
        cargarColumnas(table, rol); 
    }

    @FXML
    private void SalirS(ActionEvent event) {
    }

    @FXML
    private void CargarTodos(ActionEvent event) {
        tblProyectos.getColumns().clear();
        ocultar();
        cargarProyectos(tblProyectos, cedula, rol, conexion);
        Vaciar();
    }
    
    private void Vaciar(){
        txtBusqueda.setText("");
        if(rbtnDepartamento.isSelected())rbtnDepartamento.setSelected(false);
        if(rbtnEstado.isSelected())rbtnEstado.setSelected(false);
        if(rbtnProyecto.isSelected())rbtnProyecto.setSelected(false);
        if(rbtnSupervisor.isSelected())rbtnSupervisor.setSelected(false);
    }
}
