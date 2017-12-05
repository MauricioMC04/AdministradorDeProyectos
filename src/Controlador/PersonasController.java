package Controlador;

import Idiomas.Idiomas;
import Modelo.Conexion;
import Modelo.DatosPersonas;
import Modelo.Usuario;
import Modelo.EditarProyecto;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PersonasController implements Initializable {

    private DatosPersonas datosPersonas = new DatosPersonas();
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    private String cedula = "";
    MenuController menu = new MenuController();
    Idiomas idioma = new Idiomas("Prueba");
    @FXML
    private Tab tabAgregar;
    @FXML
    private Pane pnlAgregar;
    @FXML
    private TableView<Usuario> tblAgregar;
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
    @FXML
    private MenuItem MbMisProyectos;
    @FXML
    private TextField txtBusquedaEliminar;
    @FXML
    private Label lblBuscarEliminar;
    @FXML
    private Label lblBuscarEditar;
    @FXML
    private TextField txtBusquedaEditar;

    /*
    Nombre de metodo: initialize
    Parametros: URL url, ResourceBundle rb
    Retorno: Ninguno
    Descripcion: metodo generado por defecto para inicializar
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cambiarIdioma();
        porDefecto();
    }

    /*
    Nombre de metodo: porDefecto
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Metodo que restaura las condiciones de la ventana
    */
    public void porDefecto() {
        tblAgregar.getColumns().clear();
        tblEliminar.getColumns().clear();
        tblEditar.getColumns().clear();
        cargarPersonas(tblAgregar);
        cargarPersonas(tblEliminar);
        cargarPersonasEditables(tblEditar);
        ocultarLabels();
        vaciar();
    }
    
    /*
    Nombre de metodo: cargarPersonas
    Parametros: TableView<Usuario> table
    Retorno: Ninguno
    Descripcion: Carga en la tabla las personas del sistema
    */
    public void cargarPersonas(TableView<Usuario> table) {
        table.setItems(datosPersonas.CargarPersonas(conexion));
        cargarColumnas(table);
    }

    /*
    Nombre de metodo: cargarColumnas
    Parametros: TableView<Usuario> table
    Retorno: Ninguno
    Descripcion: Carga en la tabla las columnas necesarias para ver las personas del sistema
    */
    public void cargarColumnas(TableView<Usuario> table) {
        TableColumn tblCCedula = new TableColumn(idioma.getProperty("Cedula"));
        tblCCedula.setCellValueFactory(new PropertyValueFactory<Usuario, String>("IdUsuario"));
        tblCCedula.setMinWidth(171.25);
        TableColumn tblCNombre = new TableColumn(idioma.getProperty("Nombre"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nombre"));
        tblCNombre.setMinWidth(171.25);
        TableColumn tblCApellido = new TableColumn(idioma.getProperty("Apellido"));
        tblCApellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Apellido"));
        tblCApellido.setMinWidth(171.25);
        TableColumn tblCRol = new TableColumn(idioma.getProperty("Rol"));
        tblCRol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Rol"));
        tblCRol.setMinWidth(171.25);
        table.getColumns().addAll(tblCCedula, tblCNombre, tblCApellido, tblCRol);
    }

    /*
    Nombre de metodo: cargarPersonasEditables
    Parametros: TableView<Usuario> table
    Retorno: Ninguno
    Descripcion: Carga en la tabla las personas que se pueden editar
    */
    public void cargarPersonasEditables(TableView<Usuario> table) {
        table.setItems(datosPersonas.CargarPersonasEditables(conexion));
        cargarColumnas(table);
    }

    /*
    Nombre de metodo: ocultarLabels
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Oculta los labels que representan datos faltantes
    */
    public void ocultarLabels() {
        lblNoCedula.setVisible(false);
        lblNoNombre.setVisible(false);
        lblNoApellido.setVisible(false);
        lblNoRol.setVisible(false);
        lblNoNombreEditar.setVisible(false);
        lblNoApellidoEditar.setVisible(false);
        lblNoRolEditar.setVisible(false);
        lblNoSeleccionaEditar.setVisible(false);
    }

    /*
    Nombre de metodo: verificarNoSeleccionadosAgregar
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Verifica los datos faltantes en la parte de agregar
    */
    public void verificarNoSeleccionadosAgregar() {
        if (txtCedula.getText().equals("")) {
            lblNoCedula.setVisible(true);
        }
        if (txtNombre.getText().equals("")) {
            lblNoNombre.setVisible(true);
        }
        if (txtApellido.getText().equals("")) {
            lblNoApellido.setVisible(true);
        }
        if (!rbtnAdministrador.isSelected()) {
            if (!rbtnSupervisor.isSelected()) {
                if (!rbtnEmpleado.isSelected()) {
                    lblNoRol.setVisible(true);
                }
            }
        }
    }

    /*
    Nombre de metodo: Agregar
    Parametros: javafx.event.ActionEvent event
    Retorno: Ninguno
    Descripcion: Agrega la persona al sistema y restaura la ventana
    */
    @FXML
    private void Agregar(javafx.event.ActionEvent event) {
        if (txtCedula.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("")) {
            verificarNoSeleccionadosAgregar();
        } else {
            if (rbtnAdministrador.isSelected()) {
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnAdministrador.getText(), conexion);
                porDefecto();
            } else if (rbtnSupervisor.isSelected()) {
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnSupervisor.getText(), conexion);
                porDefecto();
            } else if (rbtnEmpleado.isSelected()) {
                datosPersonas.InsertarPersonaNueva(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnEmpleado.getText(), conexion);
                porDefecto();
            } else {
                verificarNoSeleccionadosAgregar();
            }
        }
    }

    /*
    Nombre de metodo: vaciar
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Vacia los campos de datos
    */
    public void vaciar() {
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

    /*
    Nombre de metodo: Personas
    Parametros: javafx.event.ActionEvent event
    Retorno: Ninguno
    Descripcion:
    */
    @FXML
    private void Personas(javafx.event.ActionEvent event) {

    }

    /*
    Nombre de metodo: Proyectos
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Cierra la escena y llama a proyectos de menu
    */
    @FXML
    private void Proyectos(javafx.event.ActionEvent event) {
        menu.Proyecto();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();

    }

    /*
    Nombre de metodo: CerrarS
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Cierra la escena y llama a login de menu
    */
    @FXML
    private void CerrarS(javafx.event.ActionEvent event) {
        menu.Login();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    /*
    Nombre de metodo: Tareas
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Cierra la escena y llama a insertar de menu
    */
    @FXML
    private void Tareas(javafx.event.ActionEvent event) {
        menu.Insertar();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    /*
    Nombre de metodo: EditProyectos
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Cierra la escena y llama a EditarProyectos de menu
    */
    @FXML
    private void EditProyectos(javafx.event.ActionEvent event) {
          menu.EditarProyectos();
        Scene scene =MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();        
    }

    /*
    Nombre de metodo: Eliminar
    Parametros: javafx.event.ActionEvent event
    Retorno: Ninguno
    Descripcion: Elimina a la persona seleccionada
    */
    @FXML
    private void Eliminar(javafx.event.ActionEvent event) {
        Usuario persona = tblEliminar.getSelectionModel().getSelectedItem();
        if (persona != null) {
            datosPersonas.EliminarPersona(persona.getIdUsuario(), conexion);
            porDefecto();
        }
    }

    /*
    Nombre de metodo: Seleccionar
    Parametros: MouseEvent event
    Retorno: Ninguno
    Descripcion: Carga los datos de la persona seleccionada
    */
    @FXML
    private void Seleccionar(MouseEvent event) {
        Usuario persona = tblEditar.getSelectionModel().getSelectedItem();
        if (persona != null) {
            cedula = persona.getIdUsuario();
            txtNombreEditar.setText(persona.getNombre());
            txtApellidoEditar.setText(persona.getApellido());
            if (persona.getRol().equals("Administrador")) {
                rbtnAdministradorEditar.setSelected(true);
            } else if (persona.getRol().equals("Supervisor")) {
                rbtnSupervisorEditar.setSelected(true);
            } else if (persona.getRol().equals("Empleado")) {
                rbtnEmpleado.setSelected(true);
            }
        }
    }

    /*
    Nombre de metodo: verificarNoSeleccionadosEditar
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Verifica los datos faltantes en la parte de editar
    */
    public void verificarNoSeleccionadosEditar() {
        if (txtNombreEditar.getText().equals("")) {
            lblNoNombreEditar.setVisible(true);
        }
        if (txtApellidoEditar.getText().equals("")) {
            lblNoApellidoEditar.setVisible(true);
        }
        if (!rbtnAdministradorEditar.isSelected()) {
            if (!rbtnSupervisorEditar.isSelected()) {
                if (!rbtnEmpleadoEditar.isSelected()) {
                    lblNoRolEditar.setVisible(true);
                }
            }
        }
    }

    /*
    Nombre de metodo: Editar
    Parametros: javafx.event.ActionEvent event
    Retorno: Ninguno
    Descripcion: Edita a la persona
    */
    @FXML
    private void Editar(javafx.event.ActionEvent event) {
        if (cedula.equals("") || txtNombreEditar.getText().equals("") || txtApellidoEditar.getText().equals("")) {
            verificarNoSeleccionadosEditar();
        } else {
            if (rbtnAdministradorEditar.isSelected()) {
                datosPersonas.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnAdministradorEditar.getText(), conexion);
                porDefecto();
                cedula = "";
            } else if (rbtnSupervisorEditar.isSelected()) {
                datosPersonas.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnSupervisorEditar.getText(), conexion);
                porDefecto();
                cedula = "";
            } else if (rbtnEmpleadoEditar.isSelected()) {
                datosPersonas.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnEmpleadoEditar.getText(), conexion);
                porDefecto();
                cedula = "";
            } else {
                verificarNoSeleccionadosEditar();
            }
        }
    }

    /*
    Nombre de metodo: Irproyectos
    Parametros: javafx.event.ActionEvent event
    Retorno: Ninguno
    Descripcion: Cierra la escena y llama a MisProyectos de menu
    */
    @FXML
    private void Irproyectos(javafx.event.ActionEvent event) {
        menu.MisProyectos();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    /*
    Nombre de metodo: CargarTodosEliminar
    Parametros: KeyEvent event
    Retorno: Ninguno
    Descripcion: Restaura el estado de la vista
    */
    @FXML
    private void CargarTodosEliminar(KeyEvent event) {
        if(txtBusquedaEliminar.getText().equals("")){
            porDefecto();
        }else{
            tblEliminar.getColumns().clear();
            cargarBusquedaEliminar(tblEliminar, txtBusquedaEliminar.getText());
        }
    }

    /*
    Nombre de metodo: BuscarEliminar
    Parametros: KeyEvent event
    Retorno: Ninguno
    Descripcion: Llama al metodo que carga las personas de la busqueda en la tabla
    */
    private void BuscarEliminar(KeyEvent event) {
        if(!txtBusquedaEliminar.getText().equals("")){
             
        }
    }
    /*
    Nombre de metodo: CargarTodosEditar
    Parametros: KeyEvent event
    Retorno: Ninguno
    Descripcion: Restaura el estado de la vista
    */
    @FXML
    private void CargarTodosEditar(KeyEvent event) {
        if(txtBusquedaEditar.getText().equals("")){
            porDefecto();
        }else{
            tblEditar.getColumns().clear();
            cargarBusquedaEditar(tblEditar, txtBusquedaEditar.getText()); 
        }
    }

    /*
    Nombre de metodo: BuscarEditar
    Parametros: KeyEvent event
    Retorno: Ninguno
    Descripcion: Llama al metodo que carga las personas de la busqueda en la tabla
    */
    private void BuscarEditar(KeyEvent event) {
        if(!txtBusquedaEditar.getText().equals("")){
            
        }
    }
    
    /*
    Nombre de metodo: cargarBusquedaEliminar
    Parametros: TableView<Usuario> table, String busqueda
    Retorno: Ninguno
    Descripcion: Carga en la tabla las personas segun la busqueda
    */
    private void cargarBusquedaEliminar(TableView<Usuario> table, String busqueda){
        table.setItems(datosPersonas.CargarBusquedaEliminar(conexion, busqueda));
        cargarColumnas(table);
    }
    
    /*
    Nombre de metodo: cargarBusquedaEditar
    Parametros: TableView<Usuario> table, String busqueda
    Retorno: Ninguno
    Descripcion: Carga en la tabla las personas segun la busqueda
    */
    private void cargarBusquedaEditar(TableView<Usuario> table, String busqueda){
        table.setItems(datosPersonas.CargarBusquedaEditar(conexion, busqueda));
        cargarColumnas(table);
    }
    
    public void cambiarIdioma(){ 
        tabAgregar.setText(idioma.getProperty("AgregarPersonas"));
        lblCedula.setText(idioma.getProperty("Cedula"));
        lblNombre.setText(idioma.getProperty("Nombre"));
        lblApellido.setText(idioma.getProperty("Apellido"));
        rbtnAdministrador.setText(idioma.getProperty("Administrador"));
        rbtnSupervisor.setText(idioma.getProperty("Supervisor"));
        rbtnEmpleado.setText(idioma.getProperty("Empleado"));
        btnAgregar.setText(idioma.getProperty("Agregar"));
        tabEliminar.setText(idioma.getProperty("EliminarPersonas"));
        btnEliminar.setText(idioma.getProperty("Eliminar"));
        tabEditar.setText(idioma.getProperty("EditarPersonas"));
        lblNombreEditar.setText(idioma.getProperty("Nombre"));
        lblApellidoEditar.setText(idioma.getProperty("Apellido"));
        btnEditar.setText(idioma.getProperty("Editar"));
        lblRolEditar.setText(idioma.getProperty("Rol"));
        rbtnAdministradorEditar.setText(idioma.getProperty("Administrador"));
        rbtnSupervisorEditar.setText(idioma.getProperty("Supervisor"));
        rbtnEmpleadoEditar.setText(idioma.getProperty("Empleado"));
        MPersonas.setText(idioma.getProperty("Personas"));
        MbCerrarS.setText(idioma.getProperty("CerrarSesion"));
        MbMisProyectos.setText(idioma.getProperty("MisProyectos"));
        lblBuscarEliminar.setText(idioma.getProperty("Buscar"));
        lblBuscarEditar.setText(idioma.getProperty("Buscar"));
    }
}
