/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Idiomas.Idiomas;
import Modelo.Conexion;
import Modelo.ModeloProyecto;
import Modelo.TareaUsuario;
import Modelo.TareasProyecto;
import Modelo.Usuario;
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
public class ProyectosController implements Initializable {

    TareasProyecto TareasProyecto = new TareasProyecto();
    MenuController menu = new MenuController();
    ArrayList<TareaUsuario> tareasUsuarios = new ArrayList<TareaUsuario>();
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
    private ComboBox<String> cbxTareasProyecto;
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
    @FXML
    private Label lblNoTareasProyecto;
    @FXML
    private Label lblNoIteraciones;
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
    private Label lblNoTarea;
    @FXML
    private TitledPane tlPanelProyecto;
    @FXML
    private AnchorPane ASD;
    @FXML
    private Menu BarMenuNavegarP;
    @FXML
    private Menu BarMenuSistemaP;

    /**
     * Initializes the controller class.
     */
   Idiomas idioma = MenuController.idioma;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        CargarUsuarios();
        cambiarIdioma();
        CargarSupDisponibles();
        CargarTareas();
        cargarTareas(tblEmpleadosDisponibles);
        CargarDepartamentos();
        cbxIteraciones.setItems(options);
        OcultarNo();
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
        table.setItems(TareasProyecto.CargarUsuario(conexion));
        cargarColumnas(table);
    }

    @FXML
    private void Trasladar(MouseEvent event) {
        Usuario persona = tblEmpleadosDisponibles.getSelectionModel().getSelectedItem();
        if(persona != null){
            txtEmpleadoSeleccionado.setText(persona.getIdUsuario());
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

    @FXML
    private void AgregarTarea(ActionEvent event) {
        if(!txtEmpleadoSeleccionado.getText().equals("")){
            tareasUsuarios.add(new TareaUsuario(txtEmpleadoSeleccionado.getText(), cbxTareas.getSelectionModel().getSelectedItem()));
            tblEmpleadosDisponibles.getItems().remove(tblEmpleadosDisponibles.getSelectionModel().getSelectedItem());
            txtEmpleadoSeleccionado.setText("");
            cargarTareasUsuarios();
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
     
}   