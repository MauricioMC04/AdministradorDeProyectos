/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class IdiomasController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OKL(ActionEvent event) throws IOException {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
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
        bw.close();
        bw.write("NomDep="+NomDep.getText());
        bw.close();
        bw.write("SolLetras="+SolamenteLetras.getText());
        bw.close();
        bw.write("FaltaInfo="+FaltaInfo.getText());
        bw.close();
        bw.write("NomProyecto="+NomProyecto.getText());
        bw.close();
        bw.write("Dep="+Dep.getText());
        bw.close();
        bw.write("TareasProy="+TareasProy.getText());
        bw.close();
        bw.write("FInicial="+FechaI.getText());
        bw.close();
        bw.write("FEntrega="+FechaE.getText());
        bw.close();
        bw.write("Tareas="+Tareas.getText());
        bw.close();
        bw.write("EmpSelec="+EmpSelec.getText());
        bw.close();
        bw.write("SelecEmp="+SelecEmp.getText());
        bw.close();
        bw.write("AgreTarea="+AgreTarea.getText());
        bw.close();
        bw.write("AgregProy="+AgregProy.getText());
        bw.close();
        bw.write("NombreTarea="+NombreTarea.getText());
        bw.close();
        bw.write("Descripcion="+Descripcion.getText());
        bw.close();
        bw.write("Navegar="+Nav.getText());
        bw.close();
        bw.write("Sistema="+Sis.getText());
        bw.close();
        bw.write("TareaAsig="+TAsig.getText());
        bw.close();
        bw.write("Guardar="+Guardar.getText());
        bw.close();
        bw.write("Personas="+Personas.getText());
        bw.close();
        bw.write("Proyectos="+Proyectos.getText());
        bw.close();
        bw.write("EditarProyecto="+EditarProyecto.getText());
        bw.close();
        bw.write("CerrarSesion="+CerrarSesion.getText());
        bw.close();
        bw.write("Personal="+Personal.getText());
        bw.close();
        bw.write("MisProyectos="+MisProyectos.getText());
        bw.close();
        bw.write("AgregarPersonas="+AgregarPersonas.getText());
        bw.close();
        bw.write("EliminarPersonas="+EliminarPersonas.getText());
        bw.close();
        bw.write("EditarPersonas="+EditarPersonas.getText());
        bw.close();
        bw.write("Apellido="+Apellido.getText());
        bw.close();
        bw.write("Cedula="+Cedula.getText());
        bw.close();
        bw.write("Administrador="+Administrador.getText());
        bw.close();
        bw.write("Supervisor="+Supervisor.getText());
        bw.close();
        bw.write("Empleado="+Empleado.getText());
        bw.close();
        bw.write("Agregar="+Agregar.getText());
        bw.close();
        bw.write("Rol="+Rol.getText());
        bw.close();
        bw.write("SeleccioneLaPersona="+SeleccioneLaPersona.getText());
        bw.close();
        bw.write("Proyecto="+Proyecto.getText());
        bw.close();
        bw.write("FechaInicio="+FechaInicio.getText());
        bw.close();
        bw.write("FechaFinal="+FechaFinal.getText());
        bw.close();
        }  
        MenuController menu = new MenuController();
        menu.Login();
        Stage stage = (Stage) Guardar.getScene().getWindow();
        stage.close();    
    }   
}