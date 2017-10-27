/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.ModeloProyecto;
import Modelo.TareasProyecto;
import Modelo.Usuario;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class ProyectosController implements Initializable {

    TareasProyecto TP = new TareasProyecto();
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
    private ComboBox<String> txtDepartamento;
    @FXML
    private ComboBox<String> cbxTareas;
    @FXML
    private DatePicker txtDatePickerInicio;
    @FXML
    private DatePicker txtDatePickerFinal;
    @FXML
    private TextField txtNombreProyecto;
    @FXML
    private ComboBox<String> cbxCreadoPor;
    @FXML
    private Button btnGuardarProyecto;
    @FXML
    private ComboBox<String> cbxIteraciones;
    @FXML
    private MenuBar MbMenu;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private MenuItem MbCerrarS;
    @FXML
    private Label lblTareasProyecto;
    @FXML
    private ComboBox<?> cbxTareasProyecto;
    @FXML
    private Label lblEmpleadosDisponibles;
    @FXML
    private Label lblEmpleadoSeleccionado;
    @FXML
    private Label lblErrorSeleccionarEmpleado;
    @FXML
    private TableView<Usuario> tblEmpleadosDisponibles;
    @FXML
    private TextField txtEmpleadoSeleccionado;
    @FXML
    private Button btnAgregarTarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CargarUsuarios();
        CargarTareas();
        cargarTareas(tblEmpleadosDisponibles);
        CargarDepartamentos();
        cbxIteraciones.setItems(options);
    }

    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();

    @FXML
    private void Personas(ActionEvent event) {
        menu.Personas();
        Scene scene = MbMenu.getScene();
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

    ObservableList<String> options
            = FXCollections.observableArrayList("1", "2", "3", "4", "5");

    @FXML
    private void CerrarS(ActionEvent event) {
        menu.Login();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }
    public ObservableList<String> modelo = FXCollections.observableArrayList();
    public ObservableList<String> modelo1 = FXCollections.observableArrayList();
    public ObservableList<String> modelo2 = FXCollections.observableArrayList();
   public String Estado= "XXXX";

    ModeloProyecto MP = new ModeloProyecto();

    public void CargarUsuarios() {
        modelo.addAll(MP.CargarUsuarios(conexion));
        cbxCreadoPor.setItems(modelo);

    }
    public String cedulaf=MP.CedulaU;
    public void InsertarProyecto() {
        
        MP.InsertarProyecto(txtNombreProyecto.getText(), String.valueOf(txtDatePickerInicio.getValue()),
                txtDepartamento.getSelectionModel().getSelectedItem(), Estado, Integer.parseInt(cbxIteraciones.getSelectionModel().getSelectedItem()), String.valueOf(txtDatePickerFinal.getValue()),cedulaf, conexion);
    }

    public void CargarTareas() {
        modelo1.addAll(MP.CargarTareas(conexion));
        cbxTareas.setItems(modelo1);
    }

    public void CargarDepartamentos() {
        modelo2.addAll(MP.CargarDepartamentos(conexion));
        txtDepartamento.setItems(modelo2);
    }
  

    public void cargarColumnas(TableView<Usuario> table) {
        TableColumn tblCCedula = new TableColumn("Cedula");
        tblCCedula.setCellValueFactory(new PropertyValueFactory<Usuario, String>("IdUsuario"));
        tblCCedula.setMinWidth(171.25);

        TableColumn tblCNombre = new TableColumn("Nombre");
        tblCNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nombre"));
        tblCNombre.setMinWidth(171.25);

        TableColumn tblCApellido = new TableColumn("Apellido");
        tblCApellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Apellido"));
        tblCApellido.setMinWidth(171.25);

        table.getColumns().addAll(tblCCedula, tblCNombre, tblCApellido);
    }

    public void cargarTareas(TableView<Usuario> table) {
        table.setItems(TP.CargarUsuario(conexion));
        cargarColumnas(table);
    }

    @FXML
    private void Trasladar(MouseEvent event) {
        Usuario persona = tblEmpleadosDisponibles.getSelectionModel().getSelectedItem();
        txtEmpleadoSeleccionado.setText(persona.getIdUsuario() + " " + persona.getNombre());

    }

    @FXML
    private void Guardar(ActionEvent event) {
        InsertarProyecto();
    }

}
