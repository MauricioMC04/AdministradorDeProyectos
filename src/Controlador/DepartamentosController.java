/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Idiomas.Idiomas;
import Modelo.Conexion;
import Modelo.Departamento;
import Modelo.EditarProyecto;
import Modelo.InsertarDepartamento;
import Modelo.InsertarTareas;
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
public class DepartamentosController implements Initializable {

    private InsertarDepartamento InsertarD = new InsertarDepartamento();
    MenuController menu = new MenuController();
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    Idiomas idioma = MenuController.idioma;
    EditarProyecto E = new EditarProyecto();
    
    @FXML
    private Tab tabDepartamentos;
    @FXML
    private Label lblNombreDep;
    @FXML
    private TextField txtTNombreDep;
    @FXML
    private Button Aceptar;
    @FXML
    private Tab EditarDepartamentoTab;
    @FXML
    private Pane pnlEditarDepartamento;
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
        porDefectoDepartamentos();
    }    

    @FXML
    private void Agregar(ActionEvent event) {
        InsertarD.InsertarDepartamento(txtTNombreDep.getText(), conexion);
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
        lblNombreDep.setText(idioma.getProperty("NomDep"));
        Aceptar.setText(idioma.getProperty("Acep"));
        BarMenuSistema.setText(idioma.getProperty("Sistema"));
        BarMenuNavegar.setText(idioma.getProperty("Navegar"));
        tabDepartamentos.setText(idioma.getProperty("Dep"));
        lblBuscarDepartamento.setText(idioma.getProperty("Buscar"));
        lblNombreDepartamento.setText(idioma.getProperty("Nombre"));
        btnEditarDepartamento.setText(idioma.getProperty("Editar"));
        btnEliminarDepartamento.setText(idioma.getProperty("Eliminar"));
        EditarDepartamentoTab.setText((idioma.getProperty("EditarProyecto")));
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
        TableColumn tblCNombre = new TableColumn(idioma.getProperty("Nombre"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<Departamento, String>("Nombre"));
        tblCNombre.setMinWidth(601);
        table.getColumns().addAll(tblCNombre);
    }
}
