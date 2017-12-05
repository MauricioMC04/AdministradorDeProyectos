package Controlador;

import Idiomas.Idiomas;
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
import javafx.scene.input.KeyEvent;
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
    Idiomas idioma = new Idiomas("Prueba");
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

    /*
    Nombre de metodo: initialize
    Parametros: URL url, ResourceBundle rb
    Retorno: Ninguno
    Descripcion: metodo generado por defecto para inicializar
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (MenuController.Tipo == 3) {
            MPersonas.setDisable(true);
            //MProyectos.setDisable(true);
            //MPEdittar.setDisable(true);
            //MPtareas.setDisable(true);
        }
        cambiarIdioma();
        ocultar();
        cargarProyectos(tblProyectos, cedula, rol, conexion);
        ObservableList<String> estados = FXCollections.observableArrayList();
        estados.addAll("No Implementada");
        estados.addAll("En Proceso");
        estados.addAll("Implementada");
        cmbEstados.setItems(estados);
    }
    
    /*
    Nombre de metodo: Personas
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion:
    */
    @FXML
    private void Personas(ActionEvent event) {
    }

    /*
    Nombre de metodo: Proyectos
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Cierra la escena y llama a proyectos de menu
    */
    @FXML
    private void Proyectos(ActionEvent event) {
        menu.Proyecto();
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
    private void Tareas(ActionEvent event) {
        menu.Insertar();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    /*
    Nombre de metodo: EditProyectos
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion:
    */
    @FXML
    private void EditProyectos(ActionEvent event) {
    }

    /*
    Nombre de metodo: CerrarS
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Cierra la escena y llama a login de menu
    */
    @FXML
    private void CerrarS(ActionEvent event) {
        menu.Login();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    /*
    Nombre de metodo: Irproyectos
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion:
    */
    @FXML
    private void Irproyectos(ActionEvent event) {
    }

    /*
    Nombre de metodo: MostrarTareas
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Muestra en la parte derecha de la pantalla la tabla con las tareas y personas que el actor puede ver del
    proyecto seleccionado
    */
    @FXML
    private void MostrarTareas(MouseEvent event) {
        ProyectoConsulta proyecto = tblProyectos.getSelectionModel().getSelectedItem();
        if (proyecto != null) {
            mostrarParteTareas(proyecto);
            cargarTareas(tblTarea, proyecto, cedula, rol, conexion);
        } else {
            ocultar();
        }
    }

    /*
    Nombre de metodo: MostrarTareas
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Carga los proyectos en la tabla dependiendo de la busqueda seleccionada
    */
    private void Buscar(ActionEvent event) {
        if (!txtBusqueda.getText().equals("")) {
            ocultar();
            if (rbtnDepartamento.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnDepartamento.getText(), txtBusqueda.getText(), conexion);
            } else if (rbtnEstado.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnEstado.getText(), txtBusqueda.getText(), conexion);
            } else if (rbtnProyecto.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnProyecto.getText(), txtBusqueda.getText(), conexion);
            } else if (rbtnSupervisor.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnSupervisor.getText(), txtBusqueda.getText(), conexion);
            }
            Vaciar();
        }
    }

    /*
    Nombre de metodo: Editar
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Edita la estado de la tarea seleccionada y vuelve a cargar los datos sobre la tabla
    */
    @FXML
    private void Editar(ActionEvent event) {
        Usuario_has_Tareas tarea = tblTarea.getSelectionModel().getSelectedItem();
        if (tarea != null) {
            datosConsultas.Editar(tarea, cmbEstados.getSelectionModel().getSelectedItem(), conexion);
            ProyectoConsulta proyecto = tblProyectos.getSelectionModel().getSelectedItem();
            mostrarParteTareas(proyecto);
            tblTarea.getColumns().clear();
            cargarTareas(tblTarea, proyecto, cedula, rol, conexion);
        }
    }

    /*
    Nombre de metodo: ocultar
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Oculta la parte derecha donde iran las tareas del proyecto seleccionado
    */
    private void ocultar() {
        lblProyecto.setVisible(false);
        lblDepartamento.setVisible(false);
        lblNombreProyecto.setVisible(false);
        lblNombreDepartamento.setVisible(false);
        cmbEstados.setVisible(false);
        btnEditar.setVisible(false);
        tblTarea.setVisible(false);
        if (rol == 2 || rol == 3) {
            Filtros(false);
        } else {
            Filtros(true);
        }
    }

    /*
    Nombre de metodo: Filtros
    Parametros: boolean bandera
    Retorno: Ninguno
    Descripcion: Muestra o oculta los filtros dependiendo del parametro
    */
    private void Filtros(boolean bandera) {
        rbtnDepartamento.setVisible(bandera);
        rbtnEstado.setVisible(bandera);
        rbtnProyecto.setVisible(bandera);
        rbtnSupervisor.setVisible(bandera);
        txtBusqueda.setVisible(bandera);
    }

    /*
    Nombre de metodo: cargarProyectos
    Parametros: TableView<ProyectoConsulta> table, int cedula, int rol, Connection conexion
    Retorno: Ninguno
    Descripcion: Carga sobre la tabla los proyectos que puede ver el actor
    */
    private void cargarProyectos(TableView<ProyectoConsulta> table, int cedula, int rol, Connection conexion) {
        table.setItems(datosConsultas.CargarProyectos(cedula, rol, conexion));
        if (rol == 3) {
            cargarColumnasEmpleado(table);
        } else {
            cargarColumnas(table);
        }
    }

    /*
    Nombre de metodo: cargarColumnas
    Parametros: TableView<ProyectoConsulta> table
    Retorno: Ninguno
    Descripcion: Carga sobre la tabla las columnas necesarias para ver todo lo relacionado a un proyecto
    */
    private void cargarColumnas(TableView<ProyectoConsulta> table) {
        TableColumn tblCNombre = new TableColumn(idioma.getProperty("Nombre"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Nombre"));
        tblCNombre.setMinWidth(98.42);
        TableColumn tblCDepartamento = new TableColumn(idioma.getProperty("Departamento"));
        tblCDepartamento.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Departamento"));
        tblCDepartamento.setMinWidth(98.42);
        TableColumn tblCFechaI = new TableColumn(idioma.getProperty("FechaInicio"));
        tblCFechaI.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("FechaInicio"));
        tblCFechaI.setMinWidth(98.42);
        TableColumn tblCFechaF = new TableColumn(idioma.getProperty("FechaFinal"));
        tblCFechaF.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("FechaFinal"));
        tblCFechaF.setMinWidth(98.42);
        TableColumn tblCEstado = new TableColumn(idioma.getProperty("Estado"));
        tblCEstado.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Estado"));
        tblCEstado.setMinWidth(98.42);
        TableColumn tblCAdministrador = new TableColumn(idioma.getProperty("Administrador"));
        tblCAdministrador.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Administrador"));
        tblCAdministrador.setMinWidth(98.42);
        TableColumn tblCSupervisor = new TableColumn(idioma.getProperty("Supervisor"));
        tblCSupervisor.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Supervisor"));
        tblCSupervisor.setMinWidth(98.42);
        table.getColumns().addAll(tblCNombre, tblCDepartamento, tblCFechaI, tblCFechaF, tblCAdministrador, tblCSupervisor, tblCEstado);
    }

    /*
    Nombre de metodo: cargarColumnasEmpleado
    Parametros: TableView<ProyectoConsulta> table
    Retorno: Ninguno
    Descripcion: Carga sobre la tabla las columnas necesarias para que un empleado vea un proyecto
    */
    private void cargarColumnasEmpleado(TableView<ProyectoConsulta> table) {
        TableColumn tblCNombre = new TableColumn(idioma.getProperty("Nombre"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Nombre"));
        tblCNombre.setMinWidth(344.5);
        TableColumn tblCDepartamento = new TableColumn(idioma.getProperty("Departamento"));
        tblCDepartamento.setCellValueFactory(new PropertyValueFactory<ProyectoConsulta, String>("Departamento"));
        tblCDepartamento.setMinWidth(344.5);
        table.getColumns().addAll(tblCNombre, tblCDepartamento);
    }

    /*
    Nombre de metodo: mostrarParteTareas
    Parametros: ProyectoConsulta proyecto
    Retorno: Ninguno
    Descripcion: Muestra la parte derecha donde iran las tareas del proyecto seleccionado
    */
    private void mostrarParteTareas(ProyectoConsulta proyecto) {
        lblProyecto.setVisible(true);
        lblDepartamento.setVisible(true);
        lblNombreProyecto.setVisible(true);
        lblNombreDepartamento.setVisible(true);
        tblTarea.setVisible(true);
        lblNombreProyecto.setText(proyecto.getNombre());
        lblNombreDepartamento.setText(proyecto.getDepartamento());
        if (rol == 2 || rol == 3) {
            cmbEstados.setVisible(true);
            btnEditar.setVisible(true);
        } else {
            cmbEstados.setVisible(false);
            btnEditar.setVisible(false);
        }
    }

    /*
    Nombre de metodo: cargarTareas
    Parametros: TableView<Usuario_has_Tareas> table, ProyectoConsulta proyecto, int cedula, int rol, Connection conexion
    Retorno: Ninguno
    Descripcion: Carga las tareas del proyecto seleccionado
    */
    private void cargarTareas(TableView<Usuario_has_Tareas> table, ProyectoConsulta proyecto, int cedula, int rol, Connection conexion) {
        table.setItems(datosConsultas.CargarTareas(proyecto, cedula, rol, conexion));
        cargarColumnasTareas(table);
    }

    /*
    Nombre de metodo: cargarColumnasTareas
    Parametros: TableView<Usuario_has_Tareas> table
    Retorno: Ninguno
    Descripcion: Carga las columas necesarias para ver todo lo relacionado con una tarea en un proyecto
    */
    private void cargarColumnasTareas(TableView<Usuario_has_Tareas> table) {
        TableColumn tblCTarea = new TableColumn(idioma.getProperty("Tarea"));
        tblCTarea.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Tarea"));
        tblCTarea.setMinWidth(177);
        TableColumn tblCEmpleado = new TableColumn(idioma.getProperty("Empleado"));
        tblCEmpleado.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Empleado"));
        tblCEmpleado.setMinWidth(177);
        TableColumn tblCEstado = new TableColumn(idioma.getProperty("Estado"));
        tblCEstado.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Estado"));
        tblCEstado.setMinWidth(177);
        TableColumn tblCIteraciones = new TableColumn(idioma.getProperty("Iteraciones"));
        tblCIteraciones.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Iteraciones"));
        tblCIteraciones.setMinWidth(177);
        table.getColumns().addAll(tblCTarea, tblCEmpleado, tblCEstado, tblCIteraciones);
    }

    /*
    Nombre de metodo: cargarProyectosBusqueda
    Parametros: TableView<ProyectoConsulta> table, int cedula, int rol, String filtro, String dato, Connection conexion
    Retorno: Ninguno
    Descripcion: Carga en la tabla los proyectos dependiendo de la busqueda seleccionada
    */
    private void cargarProyectosBusqueda(TableView<ProyectoConsulta> table, int cedula, int rol, String filtro, String dato, Connection conexion) {
        table.getColumns().clear();
        table.setItems(datosConsultas.CargarProyectosBusqueda(cedula, rol, filtro, dato, conexion));
        cargarColumnas(table);
    }

    /*
    Nombre de metodo: SalirS
    Parametros: ActionEvent event 
    Retorno: Ninguno
    Descripcion: 
    */
    @FXML
    private void SalirS(ActionEvent event) {
    }

    /*
    Nombre de metodo: CargarTodos
    Parametros: ActionEvent event 
    Retorno: Ninguno
    Descripcion: Llama a los metodos que ocultan la parte derecha, vacian los filtros y que cargan todos los proyectos
    en la tabla
    */
    private void CargarTodos(ActionEvent event) {
        tblProyectos.getColumns().clear();
        ocultar();
        cargarProyectos(tblProyectos, cedula, rol, conexion);
        Vaciar();
    }

    /*
    Nombre de metodo: Vaciar
    Parametros: Ninguno 
    Retorno: Ninguno
    Descripcion: Vacia los filtros
    */
    private void Vaciar() {
        txtBusqueda.setText("");
        if (rbtnDepartamento.isSelected()) {
            rbtnDepartamento.setSelected(false);
        }
        if (rbtnEstado.isSelected()) {
            rbtnEstado.setSelected(false);
        }
        if (rbtnProyecto.isSelected()) {
            rbtnProyecto.setSelected(false);
        }
        if (rbtnSupervisor.isSelected()) {
            rbtnSupervisor.setSelected(false);
        }
    }

    /*
    Nombre de metodo: Buscarproyecto
    Parametros: KeyEvent event
    Retorno: Ninguno
    Descripcion: Carga en la tabla los proyectos dependiendo de l busqueda seleccionada 
    */
    @FXML
    private void Buscarproyecto(KeyEvent event) {
        if (!txtBusqueda.getText().equals("")) {
            ocultar();
            if (rbtnDepartamento.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnDepartamento.getText(), txtBusqueda.getText(), conexion);
            } else if (rbtnEstado.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnEstado.getText(), txtBusqueda.getText(), conexion);
            } else if (rbtnProyecto.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnProyecto.getText(), txtBusqueda.getText(), conexion);
            } else if (rbtnSupervisor.isSelected()) {
                cargarProyectosBusqueda(tblProyectos, cedula, rol, rbtnSupervisor.getText(), txtBusqueda.getText(), conexion);
            }
        }else{
            tblProyectos.getColumns().clear();
            ocultar();
            cargarProyectos(tblProyectos, cedula, rol, conexion);
        }
    }
    
    public void cambiarIdioma(){ 
        MPersonas.setText(idioma.getProperty("Personas"));
        MbCerrarS.setText(idioma.getProperty("CerrarSesion"));
        MbMisProyectos.setText(idioma.getProperty("MisProyectos"));      
        lblProyecto.setText(idioma.getProperty("Proyecto"));
        lblDepartamento.setText(idioma.getProperty("Departamento"));
        btnEditar.setText(idioma.getProperty("Editar"));
    }
}