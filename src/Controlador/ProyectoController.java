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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import Idiomas.Idiomas;
import Modelo.Conexion;
import Modelo.EditarProyecto;
import Modelo.ModeloProyecto;
import Modelo.Proyecto;
import Modelo.TareaUsuario;
import Modelo.TareasProyecto;
import Modelo.Usuario;
import Modelo.Usuario_has_Tareas;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class ProyectoController implements Initializable {
 TareasProyecto TareasProyecto = new TareasProyecto();
    MenuController menu = new MenuController();
    ArrayList<TareaUsuario> tareasUsuarios = new ArrayList<TareaUsuario>();
    @FXML
    private MenuBar MbMenu;
    @FXML
    private Menu BarMenuNavegarP;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private Menu BarMenuSistemaP;
    @FXML
    private MenuItem MbCerrarS;
    @FXML
    private Tab tab_AgregarPro;
    @FXML
    private TitledPane tlPanelProyecto;
    @FXML
    private Label lblEmpleadosDisponibles;
    @FXML
    private Label lblEmpleadoSeleccionado;
    @FXML
    private Label lblErrorSeleccionarEmpleado;
    @FXML
    private Label lblTareas;
    @FXML
    private ComboBox<String> cbxTareas;
    @FXML
    private TableView<Usuario> tblEmpleadosDisponibles;
    @FXML
    private TextField txtEmpleadoSeleccionado;
    @FXML
    private Button btnAgregarTarea;
    @FXML
    private Label lblNoTarea;
    @FXML
    private Label lblIteraciones;
    @FXML
    private ComboBox<String> cbxIteraciones;
    @FXML
    private Label lblNoIteraciones;
    @FXML
    private AnchorPane ASD;
    @FXML
    private Label lblNombreProyecto;
    @FXML
    private Label lblCreadoPor;
    @FXML
    private Label lblDepartamento;
    @FXML
    private Label lblFechaInicio;
    @FXML
    private Label lblFechaEntrega;
    @FXML
    private ComboBox<String> txtDepartamento;
    @FXML
    private DatePicker txtDatePickerInicio;
    @FXML
    private DatePicker txtDatePickerFinal;
    @FXML
    private TextField txtNombreProyecto;
    @FXML
    private ComboBox<String> cbxCreadoPor;
    @FXML
    private Label lblTareasProyecto;
    @FXML
    private ComboBox<String> cbxTareasProyecto;
    @FXML
    private Button btnGuardarProyecto;
    @FXML
    private Label lblNoTareasProyecto;
    @FXML
    private Label lblNoCreado;
    @FXML
    private Label lblNoDepartamento;
    @FXML
    private Label lblNoFechaI;
    @FXML
    private Label lblNoFechaE;
    @FXML
    private Label lblNoNombre;
    @FXML
    private Label lblGuardar;
    @FXML
    private Tab tab_EditarPro;
    @FXML
    private Pane pnlEditarProyecto;
    @FXML
    private Label lblNombreP;
    @FXML
    private Label lblSupervisorP;
    @FXML
    private DatePicker DatePickerFechaE;
    @FXML
    private TextField txtSupervisor;
    @FXML
    private Label lblTareasP;
    @FXML
    private TextField txtNombreP;
    @FXML
    private Button btnActualizar;
    @FXML
    private TableView<Proyecto> tblProyectos;
    @FXML
    private TableView<Usuario_has_Tareas> tblTareasProyectos;
    @FXML
    private Label lblFechaE;
    @FXML
    private Rectangle FigRectanguloTarea;
    @FXML
    private RadioButton rbtnNoImplementada;
    @FXML
    private ToggleGroup Estados;
    @FXML
    private RadioButton rbtnImplementada;
    @FXML
    private RadioButton rbtnEnProceso;
    @FXML
    private Label lblEstadosTareasP;
    @FXML
    private ComboBox<String> cbmTareasProyectos;
    @FXML
    private Label lblEmpleadosDisponibles1;
    @FXML
    private ComboBox<String> cmbEmpleadosDisponibles;
    @FXML
    private Label lblIteracionesTarea;
    @FXML
    private ComboBox<String> cmbIteracionesTP;

    /**
     * Initializes the controller class.
     */
    Idiomas idioma = MenuController.idioma;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cambiarIdioma();
        CargarSupDisponibles();
        CargarTareas();
        cargarTareas(tblEmpleadosDisponibles);
        CargarDepartamentos();
        cbxIteraciones.setItems(options);
        OcultarNo();
        
        tblProyectos.getColumns().clear();
        cargarProyectos(tblProyectos);
        NoVer();
//        porDefectoTareas();
//        porDefectoDepartamentos();
        MostrarTareasProyecto(false);
    }    
    
      private void MostrarTareasProyecto(boolean bandera){
        lblTareasP.setVisible(bandera);
        cbmTareasProyectos.setVisible(bandera);
        lblEmpleadosDisponibles.setVisible(bandera);
        cmbEmpleadosDisponibles.setVisible(bandera);
        lblIteracionesTarea.setVisible(bandera);
        cmbIteracionesTP.setVisible(bandera);
        FigRectanguloTarea.setVisible(bandera);
        lblEstadosTareasP.setVisible(bandera);
        rbtnEnProceso.setVisible(bandera);
        rbtnImplementada.setVisible(bandera);
        rbtnNoImplementada.setVisible(bandera);
        lblEmpleadosDisponibles1.setVisible(bandera);
        
    }

     private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    public void cargarColumnasProyecto(TableView<Proyecto> table) {
        TableColumn tblPNombre = new TableColumn(idioma.getProperty("Nombre"));
        tblPNombre.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("Nombre"));
        tblPNombre.setMinWidth(171.25);
        
        TableColumn tblPFechaInicio = new TableColumn(idioma.getProperty("FechaInicio"));
        tblPFechaInicio.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("FechaInicio"));
        tblPFechaInicio.setMinWidth(171.25);
        
        TableColumn tblPDepartamento = new TableColumn(idioma.getProperty("Departamento"));
        tblPDepartamento.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("Departamento"));
        tblPDepartamento.setMinWidth(171.25);
        
      
        
        TableColumn tblPFechaFinal = new TableColumn(idioma.getProperty("FechaFinal"));
        tblPFechaFinal.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("FechaFinal"));
        tblPFechaFinal.setMinWidth(171.25);
        
        TableColumn tblPSupervisor = new TableColumn(idioma.getProperty("Supervisor"));
        tblPSupervisor.setCellValueFactory(new PropertyValueFactory<Proyecto, Integer>("Supervisor"));
        tblPSupervisor.setMinWidth(171.25);
        
        TableColumn tblPAdministrador = new TableColumn(idioma.getProperty("Administrador"));
        tblPAdministrador.setCellValueFactory(new PropertyValueFactory<Proyecto, Integer>("Administrador"));
        tblPAdministrador.setMinWidth(171.25);
        
        table.getColumns().addAll(tblPNombre, tblPFechaInicio, tblPDepartamento, tblPFechaFinal, tblPSupervisor, tblPAdministrador);
    }
//    EditarProyecto EP = new EditarProyecto();
    
    public void cargarProyectos(TableView<Proyecto> table) {
        table.setItems(E.CargarProyecto(conexion));
        cargarColumnasProyecto(table);
    }
    
    @FXML
    private void Trasladar(MouseEvent event) {
        Proyecto p = tblProyectos.getSelectionModel().getSelectedItem();
         
        if (p != null) {
          
            Ver();
            txtNombreP.setText(p.getNombre());
            txtSupervisor.setText(String.valueOf(p.getSupervisor()));
            
            //FALTAN LA FECHA DE ENTREGA
            cargarTareasProyecto(tblTareasProyectos, p, conexion);
        }
    }
    EditarProyecto E = new EditarProyecto();
     private void cargarTareasProyecto(TableView<Usuario_has_Tareas> table, Proyecto proyecto, Connection conexion) {
        table.setItems(E.CargarTareas(proyecto,  conexion));
        cargarColumnasTareasProyecto(table);
    }
     
     private void cargarColumnasTareasProyecto(TableView<Usuario_has_Tareas> table) {
        TableColumn tblCTarea = new TableColumn(idioma.getProperty("Tarea"));
        tblCTarea.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Tarea"));
        tblCTarea.setMinWidth(160);
        
        TableColumn tblCEmpleado = new TableColumn(idioma.getProperty("Empleado"));
        tblCEmpleado.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Empleado"));
        tblCEmpleado.setMinWidth(160);
        TableColumn tblCEstado = new TableColumn(idioma.getProperty("Estado"));
        tblCEstado.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Estado"));
        tblCEstado.setMinWidth(113);
        TableColumn tblCIteraciones = new TableColumn(idioma.getProperty("Iteraciones"));
        tblCIteraciones.setCellValueFactory(new PropertyValueFactory<Usuario_has_Tareas, String>("Iteraciones"));
        tblCIteraciones.setMinWidth(80);
        table.getColumns().addAll(tblCTarea, tblCEmpleado, tblCEstado, tblCIteraciones);
    }
     
    public void ActualizaProyecto() {
        Proyecto p = tblProyectos.getSelectionModel().getSelectedItem();
        String N = p.getNombre();
        String D = p.getDepartamento();
        E.EditarProyecto(txtNombreP.getText(), txtSupervisor.getText(), N, D, conexion);
        ActualizarTabla(tblProyectos);
        Refrescar();
    }

    public void ActualizarTabla(TableView<Proyecto> table) {
        table.setItems(E.CargarProyecto(conexion));
        
    }

    public void Refrescar() {
        txtNombreP.setText("");
        txtSupervisor.setText("");
        
    }
    
    public void NoVer() {
        txtNombreP.setVisible(false);
        txtSupervisor.setVisible(false);
        DatePickerFechaE.setVisible(false);
        txtNombreP.setVisible(false);
        lblNombreP.setVisible(false);
        lblSupervisorP.setVisible(false);
        lblFechaE.setVisible(false);
        btnActualizar.setVisible(false);
        tblTareasProyectos.setVisible(false);
        lblEmpleadosDisponibles1.setVisible(false);
        
    }
    
    public void Ver() {
        txtNombreP.setVisible(true);
        txtSupervisor.setVisible(true);
        DatePickerFechaE.setVisible(true);
        txtNombreP.setVisible(true);
        lblNombreP.setVisible(true);
        lblSupervisorP.setVisible(true);
        lblFechaE.setVisible(true);
        btnActualizar.setVisible(true);
        tblTareasProyectos.setVisible(true);
    }
    
    
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
    
      ObservableList<String> options
            = FXCollections.observableArrayList("1", "2", "3", "4", "5");

    @FXML
    private void Tareas(ActionEvent event) {
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
    
     public ObservableList<Usuario> modelo = FXCollections.observableArrayList();
    public ObservableList<String> modelo1 = FXCollections.observableArrayList();
    public ObservableList<String> modelo2 = FXCollections.observableArrayList();
    public String Estado= "XXXX";
    public int EstadoTarea = 1; 
    public int n = 0;
    private Usuario us;

    public void setUs(Usuario us) {
        this.us = us;
    }
    
     ModeloProyecto MP = new ModeloProyecto();

    

    public void InsertarProyecto() {
        int cedula1 = MenuController.Cedula;
        String a =  String.valueOf(cbxCreadoPor.getSelectionModel().getSelectedItem());
        String[] partes = a.split(" - ");
        String partes1= partes[0];
        String partes2= partes[1];
        MP.InsertarProyecto(txtNombreProyecto.getText(), String.valueOf(txtDatePickerInicio.getValue()),
        txtDepartamento.getSelectionModel().getSelectedItem(), Estado, 
        String.valueOf(txtDatePickerFinal.getValue()),Integer.parseInt(partes1),cedula1 , conexion); 
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
        TableColumn tblCCedula = new TableColumn(idioma.getProperty("Cedula"));
        tblCCedula.setCellValueFactory(new PropertyValueFactory<Usuario, String>("IdUsuario"));
        tblCCedula.setMinWidth(171.25);

        TableColumn tblCNombre = new TableColumn(idioma.getProperty("Nombre"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nombre"));
        tblCNombre.setMinWidth(171.25);

        TableColumn tblCApellido = new TableColumn(idioma.getProperty("Apellido"));
        tblCApellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Apellido"));
        tblCApellido.setMinWidth(171.25);

        table.getColumns().addAll(tblCCedula, tblCNombre, tblCApellido);
    }

    public void cargarTareas(TableView<Usuario> table) {
        table.setItems(TareasProyecto.CargarUsuario(conexion));
        cargarColumnas(table);
    }

    

    @FXML
    private void AgregarTarea(ActionEvent event) {
          if(!txtEmpleadoSeleccionado.getText().equals("")){
            tareasUsuarios.add(new TareaUsuario(txtEmpleadoSeleccionado.getText(), cbxTareas.getSelectionModel().getSelectedItem()));
            tblEmpleadosDisponibles.getItems().remove(tblEmpleadosDisponibles.getSelectionModel().getSelectedItem());
            txtEmpleadoSeleccionado.setText("");
            cargarTareasUsuarios();
        }
    }

    @FXML
    private void Guardar(ActionEvent event) {
        if(MostrarError()==false){
            InsertarProyecto();
            insertarUsuarioTarea();
            RefrescarCampos();
            CargarSupDisponibles();
            cbxTareasProyecto.getItems().clear();
        }
           
    }
    
    private void cargarTareasUsuarios(){
        cbxTareasProyecto.getItems().clear();
        ObservableList<String> tareas = FXCollections.observableArrayList();
        for(int i = 0; i < tareasUsuarios.size(); i++){
            tareas.addAll(tareasUsuarios.get(i).getIdUsuario() + " - " + tareasUsuarios.get(i).getNombreTarea());
        }
        cbxTareasProyecto.setItems(tareas);
        
    }

    @FXML
    private void EditarProyectoEnBase(ActionEvent event) {
                ActualizaProyecto();

    }

    @FXML
    private void TrasladarTP(MouseEvent event) {
        Usuario_has_Tareas Us_Ta = tblTareasProyectos.getSelectionModel().getSelectedItem();
        
        if (Us_Ta != null) {
            MostrarTareasProyecto(true);
            
        }
    }
    
     public void OcultarNo() {
        lblNoNombre.setVisible(false);
        lblNoCreado.setVisible(false);
        lblNoTareasProyecto.setVisible(false);
        lblNoDepartamento.setVisible(false);
        lblNoFechaE.setVisible(false);
        lblNoFechaI.setVisible(false);
        lblNoIteraciones.setVisible(false);
        lblGuardar.setVisible(false);

    }
    public boolean MostrarError() {
        
        if (txtNombreProyecto.getText().isEmpty()) {
            lblNoNombre.setVisible(true);
            return true;
        }
        
//        if (cbxCreadoPor.getSelectionModel().getSelectedItem().getIdUsuario().isEmpty() &&
//                cbxCreadoPor.getSelectionModel().getSelectedItem().getNombreUsuario().isEmpty()) {
//            lblNoCreado.setVisible(true); 
//            return true;
//        }
      

//        if(cbxTareasProyecto.getSelectionModel().getSelectedItem().isEmpty())lblNoTareasProyecto.setVisible(true);
        if (txtDepartamento.getSelectionModel().isEmpty()) {
            lblNoDepartamento.setVisible(true);
            return true;
        }
        

        if (cbxIteraciones.getSelectionModel().getSelectedItem().isEmpty()) {
            lblNoIteraciones.setVisible(true);
            return true;
        }
    return false;
          
//        if(txtDatePickerInicio.getValue().equals(""))lblNoFechaI.setVisible(true);
//        if(txtDatePickerFinal.getValue().)lblNoFechaE.setVisible(true);
    }
    
    public void RefrescarCampos(){
        txtNombreProyecto.setText("");
     
    }
    
   private void insertarUsuarioTarea(){
        String a =  String.valueOf(cbxTareasProyecto.getSelectionModel().getSelectedItem());
        String[] partes = a.split(" - ");
        String partes1= partes[0];
        String partes2= partes[1];
        
        for(int i = 0; i < tareasUsuarios.size(); i++){
            MP.InsertarTareaUsuario(txtNombreProyecto.getText(), txtDepartamento.getSelectionModel().getSelectedItem(),
            tareasUsuarios.get(i).getNombreTarea(), Integer.parseInt(tareasUsuarios.get(i).getIdUsuario()), EstadoTarea,
                    Integer.parseInt(cbxIteraciones.getSelectionModel().getSelectedItem()) ,conexion);
        }
       
   }
   
   private void CargarSupDisponibles(){
       cbxCreadoPor.getItems().clear();
        ObservableList<String> Sup = FXCollections.observableArrayList();
        for(int i = 0; i < MP.CargarUsuarios1(conexion).size(); i++){
            Sup.addAll(MP.CargarUsuarios1(conexion).get(i).getIdUsuario() + " - " + MP.CargarUsuarios1(conexion).get(i).getNombre());
        }
        
        cbxCreadoPor.setItems(Sup);
 
   }
   
    public void cambiarIdioma(){
        
       lblNombreProyecto.setText(idioma.getProperty("NomProyecto"));
       lblCreadoPor.setText(idioma.getProperty("SupervisadorPor"));
       lblDepartamento.setText(idioma.getProperty("Dep"));
       lblTareasProyecto.setText(idioma.getProperty("TareasProy"));
       lblFechaInicio.setText(idioma.getProperty("FInicial"));
       lblFechaEntrega.setText(idioma.getProperty("FEntrega"));
       lblTareas.setText(idioma.getProperty("Tareas"));
       lblIteraciones.setText(idioma.getProperty("Iteraciones"));
       btnGuardarProyecto.setText(idioma.getProperty("Guardar"));
       lblEmpleadosDisponibles.setText(idioma.getProperty("EmpleadosDisponibles"));
       lblEmpleadoSeleccionado.setText(idioma.getProperty("EmpSelec"));
       lblErrorSeleccionarEmpleado.setText(idioma.getProperty("SelecEmp"));
       btnAgregarTarea.setText(idioma.getProperty("AgreTarea"));
       tlPanelProyecto.setText(idioma.getProperty("AgregProy"));
       BarMenuSistemaP.setText(idioma.getProperty("Sistema"));
       BarMenuNavegarP.setText(idioma.getProperty("Navegar"));
    }

    @FXML
    private void TrasladarE(MouseEvent event) {
         Usuario persona = tblEmpleadosDisponibles.getSelectionModel().getSelectedItem();
        if(persona != null){
            txtEmpleadoSeleccionado.setText(persona.getIdUsuario());
        }    
    }
    
    
}
