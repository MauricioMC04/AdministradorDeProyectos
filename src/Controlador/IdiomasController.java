/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosIdioma;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class IdiomasController implements Initializable {

    DatosIdioma datosIdioma = new DatosIdioma();
    
    @FXML
    private Tab nuevoIdioma;
    @FXML
    private TextField Nombreidioma;
    @FXML
    private TextField ingreso;
    @FXML
    private TextField contra;
    @FXML
    private TextField NoImplementada;
    @FXML
    private TextField Nombre;
    @FXML
    private TextField Implementada;
    @FXML
    private TextField TareasDisponibles;
    @FXML
    private TextField Estados;
    @FXML
    private TextField Enproceso;
    @FXML
    private TextField SupervisadorPor;
    @FXML
    private TextField FechaEntrega;
    @FXML
    private TextField EmpleadosDisponibles;
    @FXML
    private TextField Guardar;
    @FXML
    private TextField Iteraciones;
    @FXML
    private TextField Actualizar;
    @FXML
    private TextField Implementada2;
    @FXML
    private TextField Implementada4;
    @FXML
    private TextField Implementada5;
    @FXML
    private TextField Implementada6;
    @FXML
    private Button Save;
    @FXML
    private TextField Buscar;
    @FXML
    private TextField NombreTarea;
    @FXML
    private TextField Descripcion;
    @FXML
    private TextField Editar;
    @FXML
    private TextField Eliminar;
    @FXML
    private TextField acep;
    @FXML
    private TextField NomDep;
    @FXML
    private TextField SolamenteLetras;
    @FXML
    private TextField FaltaInfo;
    @FXML
    private TextField NomProyecto;
    @FXML
    private TextField Dep;
    @FXML
    private TextField TareasProy;
    @FXML
    private TextField FechaI;
    @FXML
    private TextField FechaE;
    @FXML
    private TextField Tareas;
    @FXML
    private TextField EmpSelec;
    @FXML
    private TextField SelecEmp;
    @FXML
    private TextField AgreTarea;
    @FXML
    private TextField AgregProy;
    @FXML
    private TextField Nav;
    @FXML
    private TextField Sis;
    @FXML
    private TextField TAsig;
    @FXML
    private TextField Personas;
    @FXML
    private TextField Proyectos;
    @FXML
    private TextField EditarProyecto;
    @FXML
    private TextField CerrarSesion;
    @FXML
    private TextField Personal;
    @FXML
    private TextField MisProyectos;
    @FXML
    private TextField AgregarPersonas;
    @FXML
    private TextField EliminarPersonas;
    @FXML
    private TextField EditarPersonas;
    @FXML
    private TextField Apellido;
    @FXML
    private TextField Cedula;
    @FXML
    private TextField Administrador;
    @FXML
    private TextField Supervisor;
    @FXML
    private TextField Empleado;
    @FXML
    private TextField Agregar;
    @FXML
    private TextField Rol;
    @FXML
    private TextField SeleccioneLaPersona;
    @FXML
    private TextField Proyecto;
    @FXML
    private TextField FechaInicio;
    @FXML
    private TextField FechaFinal;
    @FXML
    private TextField SalirDelSistema;
    @FXML
    private ComboBox<String> cmbIdiomas;
    @FXML
    private Button btnEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CargarIdiomas();
    }    

    @FXML
    private void OKL(ActionEvent event) throws IOException {
        String userDir = System.getProperty("user.dir");
        String ruta = userDir+"\\src\\Idiomas\\"+Nombreidioma.getText()+".properties";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
        int a =0;
        } else {
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("Ingreso="+ingreso.getText());
        bw.newLine();
        bw.write("Contra="+contra.getText());
        bw.newLine();
        bw.write("NoImplementada="+NoImplementada.getText()); 
        bw.newLine();
        bw.write("Nombre="+Nombre.getText());
        bw.newLine();
        bw.write("Implementada="+Implementada.getText()); 
        bw.newLine();
        bw.write("SupervisadorPor="+SupervisadorPor.getText()); 
        bw.newLine();
        bw.write("Iteraciones="+Iteraciones.getText()); 
        bw.newLine();
        bw.write("FechaEntrega="+FechaEntrega.getText());
        bw.newLine();
        bw.write("EmpleadosDisponibles="+EmpleadosDisponibles.getText()); 
        bw.newLine();
        bw.write("Actualizar="+Actualizar.getText()); 
        bw.newLine();
        bw.write("TareasDisponibles="+TareasDisponibles.getText()); 
        bw.newLine();
        bw.write("Estados="+Estados.getText());
        bw.newLine();
        bw.write("Enproceso="+Enproceso.getText());
        bw.newLine();
        bw.write("Acep="+acep.getText());
        bw.newLine();
        bw.write("NomDep="+NomDep.getText());
        bw.newLine();
        bw.write("SolLetras="+SolamenteLetras.getText());
        bw.newLine();
        bw.write("FaltaInfo="+FaltaInfo.getText());
        bw.newLine();
        bw.write("NomProyecto="+NomProyecto.getText());
        bw.newLine();
        bw.write("Dep="+Dep.getText());
        bw.newLine();
        bw.write("TareasProy="+TareasProy.getText());
        bw.newLine();
        bw.write("FInicial="+FechaI.getText());
        bw.newLine();
        bw.write("FEntrega="+FechaE.getText());
        bw.newLine();
        bw.write("Tareas="+Tareas.getText());
        bw.newLine();
        bw.write("EmpSelec="+EmpSelec.getText());
        bw.newLine();
        bw.write("SelecEmp="+SelecEmp.getText());
        bw.newLine();
        bw.write("AgreTarea="+AgreTarea.getText());
        bw.newLine();
        bw.write("AgregProy="+AgregProy.getText());
        bw.newLine();
        bw.write("NombreTarea="+NombreTarea.getText());
        bw.newLine();
        bw.write("Descripcion="+Descripcion.getText());
        bw.newLine();
        bw.write("Navegar="+Nav.getText());
        bw.newLine();
        bw.write("Sistema="+Sis.getText());
        bw.newLine();
        bw.write("TareaAsig="+TAsig.getText());
        bw.newLine();
        bw.write("Guardar="+Guardar.getText());
        bw.newLine();
        bw.write("Personas="+Personas.getText());
        bw.newLine();
        bw.write("Proyectos="+Proyectos.getText());
        bw.newLine();
        bw.write("EditarProyecto="+EditarProyecto.getText());
        bw.newLine();
        bw.write("CerrarSesion="+CerrarSesion.getText());
        bw.newLine();
        bw.write("Personal="+Personal.getText());
        bw.newLine();
        bw.write("MisProyectos="+MisProyectos.getText());
        bw.newLine();
        bw.write("AgregarPersonas="+AgregarPersonas.getText());
        bw.newLine();
        bw.write("EliminarPersonas="+EliminarPersonas.getText());
        bw.newLine();
        bw.write("EditarPersonas="+EditarPersonas.getText());
        bw.newLine();
        bw.write("Apellido="+Apellido.getText());
        bw.newLine();
        bw.write("Cedula="+Cedula.getText());
        bw.newLine();
        bw.write("Administrador="+Administrador.getText());
        bw.newLine();
        bw.write("Supervisor="+Supervisor.getText());
        bw.newLine();
        bw.write("Empleado="+Empleado.getText());
        bw.newLine();
        bw.write("Agregar="+Agregar.getText());
        bw.newLine();
        bw.write("Rol="+Rol.getText());
        bw.newLine();
        bw.write("SeleccioneLaPersona="+SeleccioneLaPersona.getText());
        bw.newLine();
        bw.write("Proyecto="+Proyecto.getText());
        bw.newLine();
        bw.write("FechaInicio="+FechaInicio.getText());
        bw.newLine();
        bw.write("FechaFinal="+FechaFinal.getText());
        bw.newLine();
        bw.write("Editar="+Editar.getText());
        bw.newLine();
        bw.write("Eliminar="+Eliminar.getText());
        bw.newLine();
        bw.write("SalirDelSistema="+SalirDelSistema.getText());
        bw.close();
        }  
        MenuController menu = new MenuController();
        menu.Login();
        Stage stage = (Stage) Guardar.getScene().getWindow();
        stage.close();    
    }   

    /*
    Nombre de metodo: EliminarIdioma
    Parametros: ActionEvent event
    Retorno: Ninguno
    Descripcion: Llama al metodo que elimina el idioma seleccionado 
    */
    @FXML
    private void EliminarIdioma(ActionEvent event) {
        String idioma = cmbIdiomas.getSelectionModel().getSelectedItem();
        if(idioma != null && !idioma.equals("")){
            datosIdioma.EliminarIdioma(idioma);
            CargarIdiomas();
        }
    }
    
    /*
    Nombre de metodo: CargarIdiomas
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Carga sobre el comboBox los idiomas disponibles 
    */
    public void CargarIdiomas(){
        cmbIdiomas.getItems().clear();
        cmbIdiomas.setItems(datosIdioma.CargarIdiomas());
    }

}