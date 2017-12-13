/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Idiomas.Idiomas;
import Modelo.Conexion;
import Modelo.EditarProyecto;
import Modelo.InsertarTareas;
import Modelo.Tarea;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class TareasController implements Initializable {

    private InsertarTareas InsertarT = new InsertarTareas();
    MenuController menu = new MenuController();
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    Idiomas idioma = MenuController.idioma;
    EditarProyecto E = new EditarProyecto();
    
    @FXML
    private Tab tabTareasAsignadas;
    @FXML
    private Button btnTAceptar;
    @FXML
    private Label lblTNombreTareas;
    @FXML
    private TextField txtTNombreTarea;
    @FXML
    private Label lblTErrorLetras;
    @FXML
    private Label lblTErrorInformacion;
    @FXML
    private TextArea txtATDescipcion;
    @FXML
    private Label lblTSErrorNombre;
    @FXML
    private Label lblTSErrorDescripcion;
    @FXML
    private Label lblTDescripcion;
    @FXML
    private Tab EditarTareaTab;
    @FXML
    private Pane pnlEditarTarea;
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
    private MenuBar MbMenu;
    @FXML
    private Menu BarMenuNavegar;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private Menu BarMenuSistema;
    @FXML
    private MenuItem MbCerrarS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cambiarIdioma();
        lblTErrorInformacion.setVisible(false);
        lblTErrorLetras.setVisible(false);
        lblTSErrorDescripcion.setVisible(false);
        lblTSErrorNombre.setVisible(false);
        porDefectoTareas();
    }    

    @FXML
    private void Aceptar(ActionEvent event) {
        InsertarT.InsertarTarea(txtTNombreTarea.getText(), txtATDescipcion.getText(), conexion);
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

    @FXML
    private void Personas(ActionEvent event) {
        menu.Login();
        CodigoR();
    }

    @FXML
    private void Proyectos(ActionEvent event) {
        menu.Login();
        CodigoR();
    }

    @FXML
    private void Tareas(ActionEvent event) {
    }

    @FXML
    private void EditProyectos(ActionEvent event) {
        menu.Login();
        CodigoR();
    }

    @FXML
    private void CerrarS(ActionEvent event) {
        menu.Login();
        CodigoR();
    }
    
    private void CodigoR(){
        Scene scene =MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }
    
    public void cambiarIdioma(){   
        lblTNombreTareas.setText(idioma.getProperty("NombreTarea"));
        lblTErrorLetras.setText(idioma.getProperty("SolLetras"));
        lblTDescripcion.setText(idioma.getProperty("Descripcion"));
        lblTErrorInformacion.setText(idioma.getProperty("FaltaInfo"));
        btnTAceptar.setText(idioma.getProperty("Acep"));
        BarMenuSistema.setText(idioma.getProperty("Sistema"));
        BarMenuNavegar.setText(idioma.getProperty("Navegar"));
        tabTareasAsignadas.setText(idioma.getProperty("TareaAsig"));
        lblBuscarTarea.setText(idioma.getProperty("Buscar"));
        lblNombreTarea.setText(idioma.getProperty("NombreTarea"));
        lblDescripcion.setText(idioma.getProperty("Descripcion"));
        btnEditarTarea.setText(idioma.getProperty("Editar"));
        btnEliminarTarea.setText(idioma.getProperty("Eliminar"));
        EditarTareaTab.setText(idioma.getProperty(""));
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
        TableColumn tblCNombre = new TableColumn(idioma.getProperty("Nombre"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<Tarea, String>("Nombre"));
        tblCNombre.setMinWidth(367.5);
        TableColumn tblCDescripcion = new TableColumn(idioma.getProperty("Descripcion"));
        tblCDescripcion.setCellValueFactory(new PropertyValueFactory<Tarea, String>("Descripcion"));
        tblCDescripcion.setMinWidth(367.5);
        table.getColumns().addAll(tblCNombre, tblCDescripcion);
    }
}
