
package Controlador;

import Modelo.Conexion;
import Modelo.DatosPersonas;
import Modelo.PersonaObservable;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;


public class PersonasController implements Initializable {

    private AdministradorDeProyectosFX ProgramaPrincipal;
    private DatosPersonas datosPersonas = new DatosPersonas();
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    
    @FXML
    private ToggleGroup Roles; 
    @FXML
    private ToggleGroup RolesEditar;
    @FXML
    private Tab tabAgregar;
    @FXML
    private Pane pnlAgregar;
    @FXML
    private TableView<PersonaObservable> tblAgregar;
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
    private RadioButton rbtnSupervisor;
    @FXML
    private RadioButton rbtnEmpleado;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnMenuAgregar;
    @FXML
    private Tab tabEliminar;
    @FXML
    private Pane pnlEliminar;
    @FXML
    private TableView<PersonaObservable> tblEliminar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnMenuEliminar;
    @FXML
    private Tab tabEditar;
    @FXML
    private Pane pnlEditar;
    @FXML
    private TableView<PersonaObservable> tblEditar;
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
    private Button btnMenuEditar;
    @FXML
    private Label lblRolEditar;
    @FXML
    private RadioButton rbtnAdministradorEditar;
    @FXML
    private RadioButton rbtnSupervisorEditar;
    @FXML
    private RadioButton rbtnEmpleadoEditar;
    @FXML
    private Label lblNoCedula;
    @FXML
    private Label lblNoNombre;
    @FXML
    private Label lblNoApellido;
    @FXML
    private Label lblNoRol;

    public void setProgramaPrincipal(AdministradorDeProyectosFX ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarPersonas(tblAgregar);
        cargarPersonas(tblEliminar);
        cargarPersonasEditables(tblEditar);
        ocultarLabelsAgregar();
    }    
    
    public void cargarPersonas(TableView<PersonaObservable> table){
        table.setItems(datosPersonas.CargarPersonas(conexion));
        cargarColumnas(table);
    }
    
    public void cargarColumnas(TableView<PersonaObservable> table){
        TableColumn tblCCedula = new TableColumn("Cedula");
        tblCCedula.setCellValueFactory(new PropertyValueFactory<PersonaObservable, String>("IdUsuario"));
        tblCCedula.setMinWidth(171.25);
	TableColumn tblCNombre = new TableColumn("Nombre");
	tblCNombre.setCellValueFactory(new PropertyValueFactory<PersonaObservable, String>("Nombre"));
        tblCNombre.setMinWidth(171.25);
	TableColumn tblCApellido = new TableColumn("Apellido");
        tblCApellido.setCellValueFactory(new PropertyValueFactory<PersonaObservable, String>("Apellido"));
        tblCApellido.setMinWidth(171.25);
        TableColumn tblCRol = new TableColumn("Rol");
        tblCRol.setCellValueFactory(new PropertyValueFactory<PersonaObservable, String>("Rol"));
        tblCRol.setMinWidth(171.25);
        table.getColumns().addAll(tblCCedula, tblCNombre, tblCApellido, tblCRol);
    }
    
    public void cargarPersonasEditables(TableView<PersonaObservable> table){
        table.setItems(datosPersonas.CargarPersonasEditables(conexion));
        cargarColumnas(table);
    }
    
    public void ocultarLabelsAgregar(){
        lblNoCedula.setVisible(false);
        lblNoNombre.setVisible(false);
        lblNoApellido.setVisible(false);
        lblNoRol.setVisible(false);
    }
    
    public void verificarNoSeleccionados(){
        if(txtCedula.getText().equals(""))lblNoCedula.setVisible(true);
        if(txtNombre.getText().equals(""))lblNoCedula.setVisible(true);
        if(txtApellido.getText().equals(""))lblNoCedula.setVisible(true);
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
            verificarNoSeleccionados();
        }else{
            if(rbtnAdministrador.isSelected()){
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnAdministrador.getText(), conexion);
            }else if(rbtnSupervisor.isSelected()){
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnSupervisor.getText(), conexion);
            }else if(rbtnEmpleado.isSelected()){
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnEmpleado.getText(), conexion);
            }else{
                verificarNoSeleccionados();
            }
        }
    }
}
