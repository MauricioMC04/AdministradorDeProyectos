
package Controlador;

import Modelo.Conexion;
import Modelo.DatosPersonas;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PersonasController implements Initializable {

    private AdministradorDeProyectosFX ProgramaPrincipal;
    private DatosPersonas datosPersonas = new DatosPersonas();
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    private String cedula = "";
    MenuController menu = new MenuController();
    @FXML
    private Tab tabAgregar;
    @FXML
    private Pane pnlAgregar;
    @FXML
    private TableView<Usuario>tblAgregar;
    @FXML
    private Label lblCedula;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private Label lblRol;
    @FXML
    private RadioButton rbtnAdministrador;
    @FXML
    private ToggleGroup Roles;
    @FXML
    private RadioButton rbtnSupervisor;
    @FXML
    private RadioButton rbtnEmpleado;
    @FXML
    private Button btnAgregar;
    @FXML
    private Label lblNoCedula;
    @FXML
    private Label lblNoNombre;
    @FXML
    private Label lblNoApellido;
    @FXML
    private Label lblNoRol;
    @FXML
    private Tab tabEliminar;
    @FXML
    private Pane pnlEliminar;
    @FXML
    private TableView<Usuario> tblEliminar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Tab tabEditar;
    @FXML
    private Pane pnlEditar;
    @FXML
    private TableView<Usuario> tblEditar;
    @FXML
    private Label lblNombreEditar;
    @FXML
    private Label lblApellidoEditar;
    @FXML
    private TextField txtNombreEditar;
    @FXML
    private TextField txtApellidoEditar;
    @FXML
    private Button btnEditar;
    @FXML
    private Label lblRolEditar;
    @FXML
    private RadioButton rbtnAdministradorEditar;
    @FXML
    private ToggleGroup RolesEditar;
    @FXML
    private RadioButton rbtnSupervisorEditar;
    @FXML
    private RadioButton rbtnEmpleadoEditar;
    @FXML
    private MenuBar MbMenu;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private MenuItem MbCerrarS;
    @FXML
    private Label lblNoNombreEditar;
    @FXML
    private Label lblNoApellidoEditar;
    @FXML
    private Label lblNoRolEditar;
    @FXML
    private Label lblNoSeleccionaEditar;

    public void setProgramaPrincipal(AdministradorDeProyectosFX ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        porDefecto();
    }    
    
    public void porDefecto(){
        tblAgregar.getColumns().clear();
        tblEliminar.getColumns().clear();
        tblEditar.getColumns().clear();
        cargarPersonas(tblAgregar);
        cargarPersonas(tblEliminar);
        cargarPersonasEditables(tblEditar);
        ocultarLabels();
        vaciar();
    }
    
    public void cargarPersonas(TableView<Usuario> table){
        table.setItems(datosPersonas.CargarPersonas(conexion));
        cargarColumnas(table);
    }
    
    public void cargarColumnas(TableView<Usuario> table){
        TableColumn tblCCedula = new TableColumn("Cedula");
        tblCCedula.setCellValueFactory(new PropertyValueFactory<Usuario, String>("IdUsuario"));
        tblCCedula.setMinWidth(171.25);
	TableColumn tblCNombre = new TableColumn("Nombre");
	tblCNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nombre"));
        tblCNombre.setMinWidth(171.25);
	TableColumn tblCApellido = new TableColumn("Apellido");
        tblCApellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Apellido"));
        tblCApellido.setMinWidth(171.25);
        TableColumn tblCRol = new TableColumn("Rol");
        tblCRol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Rol"));
        tblCRol.setMinWidth(171.25);
        table.getColumns().addAll(tblCCedula, tblCNombre, tblCApellido, tblCRol);
    }
    
    public void cargarPersonasEditables(TableView<Usuario> table){
        table.setItems(datosPersonas.CargarPersonasEditables(conexion));
        cargarColumnas(table);
    }
    
    public void ocultarLabels(){
        lblNoCedula.setVisible(false);
        lblNoNombre.setVisible(false);
        lblNoApellido.setVisible(false);
        lblNoRol.setVisible(false);
        lblNoNombreEditar.setVisible(false);
        lblNoApellidoEditar.setVisible(false);
        lblNoRolEditar.setVisible(false);
        lblNoSeleccionaEditar.setVisible(false);
    }
    
    public void verificarNoSeleccionadosAgregar(){
        if(txtCedula.getText().equals(""))lblNoCedula.setVisible(true);
        if(txtNombre.getText().equals(""))lblNoNombre.setVisible(true);
        if(txtApellido.getText().equals(""))lblNoApellido.setVisible(true);
        if(!rbtnAdministrador.isSelected()){
            if(!rbtnSupervisor.isSelected()){
                if(!rbtnEmpleado.isSelected()){
                    lblNoRol.setVisible(true);
                }
            }
        }
    }
    
    @FXML
    private void Agregar(javafx.event.ActionEvent event) {
        if(txtCedula.getText().equals("") || txtNombre.getText().equals("") ||txtApellido.getText().equals("")){
            verificarNoSeleccionadosAgregar();
        }else{
            if(rbtnAdministrador.isSelected()){
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnAdministrador.getText(), conexion);
                porDefecto();
            }else if(rbtnSupervisor.isSelected()){
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnSupervisor.getText(), conexion);
                porDefecto();
            }else if(rbtnEmpleado.isSelected()){
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnEmpleado.getText(), conexion);
                porDefecto();
            }else{
                verificarNoSeleccionadosAgregar();
            }
        }
    }
    
    public void vaciar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        rbtnAdministrador.setSelected(false);
        rbtnSupervisor.setSelected(false);
        rbtnEmpleado.setSelected(false);
        txtCedula.setText("");
        txtNombreEditar.setText("");
        txtApellidoEditar.setText("");
        rbtnAdministradorEditar.setSelected(false);
        rbtnSupervisorEditar.setSelected(false);
        rbtnEmpleadoEditar.setSelected(false);
    }

    @FXML
    private void Personas(javafx.event.ActionEvent event) {

    }

    @FXML
    private void Proyectos(javafx.event.ActionEvent event) {
        menu.Proyecto();
        Scene scene =MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
        
        
    }

    @FXML
    private void CerrarS(javafx.event.ActionEvent event) {
        menu.Login();
        Scene scene =MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    private void Tareas(javafx.event.ActionEvent event) {
        menu.Insertar();
        Scene scene =MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    private void EditProyectos(javafx.event.ActionEvent event) {
    }

    @FXML
    private void Eliminar(javafx.event.ActionEvent event) {
        Usuario persona = tblEliminar.getSelectionModel().getSelectedItem();
        if(persona != null){
            datosPersonas.EliminarPersona(persona.getIdUsuario(), conexion);
            porDefecto();
        }
    }

    @FXML
    private void Seleccionar(MouseEvent event) {
        Usuario persona = tblEditar.getSelectionModel().getSelectedItem();
        if(persona != null){
            cedula = persona.getIdUsuario();
            txtNombreEditar.setText(persona.getNombre());
            txtApellidoEditar.setText(persona.getApellido());
            if(persona.getRol().equals("Administrador")){
                rbtnAdministradorEditar.setSelected(true);
            }else if(persona.getRol().equals("Supervisor")){
                rbtnSupervisorEditar.setSelected(true);
            }else if(persona.getRol().equals("Empleado")){
                rbtnEmpleado.setSelected(true);
            }
        }
    }
    
    public void verificarNoSeleccionadosEditar(){
        if(txtNombreEditar.getText().equals(""))lblNoNombreEditar.setVisible(true);
        if(txtApellidoEditar.getText().equals(""))lblNoApellidoEditar.setVisible(true);
        if(!rbtnAdministradorEditar.isSelected()){
            if(!rbtnSupervisorEditar.isSelected()){
                if(!rbtnEmpleadoEditar.isSelected()){
                    lblNoRolEditar.setVisible(true);
                }
            }
        }
    }

    @FXML
    private void Editar(javafx.event.ActionEvent event) {
        if(cedula.equals("") || txtNombreEditar.getText().equals("") ||txtApellidoEditar.getText().equals("")){
            verificarNoSeleccionadosEditar();
        }else{
            if(rbtnAdministradorEditar.isSelected()){
                datosPersonas.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnAdministradorEditar.getText(), conexion);
                porDefecto();
                cedula = "";
            }else if(rbtnSupervisorEditar.isSelected()){
                datosPersonas.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnSupervisorEditar.getText(), conexion);
                porDefecto();
                cedula = "";
            }else if(rbtnEmpleadoEditar.isSelected()){
                datosPersonas.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnEmpleadoEditar.getText(), conexion);
                porDefecto();
                cedula = "";
            }else{
                verificarNoSeleccionadosEditar();
            }
        }
    }
}
