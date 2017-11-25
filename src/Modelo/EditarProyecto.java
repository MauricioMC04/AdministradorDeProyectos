/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.EditarProyController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EditarProyecto {
    
    public ObservableList<Proyecto> CargarProyecto(Connection conexion){
        ObservableList <Proyecto> modelo = FXCollections.observableArrayList();
        String sql = "Select * FROM Proyecto";
        String[] datos = new String[7];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);

              Proyecto P = new Proyecto(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[6]),Integer.parseInt(datos[5]));
          
                 modelo.addAll(P);
                
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarProyectos");
        }
        return modelo;
    }
    
    public void EditarProyecto(String Nombre, String Departamento, String Supervisor, String NP, String DP, Connection conexion){
        try {
            PreparedStatement pst = conexion.prepareStatement("Update Proyecto Set Nombre = '" + Nombre + "', Departamento "
                    + "= '" + Departamento + "', Supervisor = " + Supervisor + " Where Nombre  = '" + NP +  "' AND " + "Departamento = '" + DP + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }

    /*
    Nombre de metodo: CargarTareas
    Parametros: String busqueda, Connection conexion
    Retorno: ObservableList<Tarea>
    Descripcion: Retorna un ObservableList con las tareas que se pueden editar
    */
    public ObservableList<Tarea> CargarTareas(String busqueda, Connection conexion){
        ObservableList <Tarea> modelo = FXCollections.observableArrayList();
        String sql = GenerarSqlTareas(busqueda);
        String[] datos = new String[2];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(1);
                modelo.add(new Tarea(datos[0],datos[1]));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarTareas");
        }
        return modelo;
    }
    
    /*
    Nombre de metodo: GenerarSqlTareas
    Parametros: String busqueda
    Retorno: String
    Descripcion: Retorna el sql necesario para la consulta de las tareas
    */
    private String GenerarSqlTareas(String busqueda){
        if(busqueda.equals("Ninguna")){
            return "Select T1.* From Tareas T1 Left Outer Join Usuario_has_Tareas T2 ON T1.Nombre = T2.Tareas_Nombre "
                   + "WHERE T2.Tareas_Nombre IS NULL";
        }else{
            return "Select T1.* From Tareas T1 Left Outer Join Usuario_has_Tareas T2 ON T1.Nombre = T2.Tareas_Nombre "
                   + "WHERE T2.Tareas_Nombre IS NULL And T1.Nombre LIKE '" + busqueda + "%' OR T1.Descripcion LIKE '" 
                   + busqueda + "%' group by Nombre";
        }
    }
    
    /*
    Nombre de metodo: EditarTarea
    Parametros: Tarea tarea, String Nombre, String Descripcion, Connection conexion
    Retorno: Ninguno
    Descripcion: Edita una tarea del sistema
    */
    public void EditarTarea(Tarea tarea, String Nombre, String Descripcion, Connection conexion){
        try {
            PreparedStatement pst = conexion.prepareStatement("Update Tareas Set Nombre = '" + Nombre + "', Descripcion"
                    + " = '" + Descripcion + "' Where Nombre = '" + tarea.getNombre() + "' AND Descripcion = '" 
                    + tarea.getDescripcion() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar Tarea: " + e);
        }
    }
    
    /*
    Nombre de metodo: EliminarTarea
    Parametros: Tarea tarea, Connection conexion
    Retorno: Ninguno
    Descripcion: Elimina una tarea del sistema
    */
    public void EliminarTarea(Tarea tarea, Connection conexion){
        try {
            PreparedStatement pst = conexion.prepareStatement("Delete from Tareas Where Nombre = '" + tarea.getNombre() + "'"
                    + " AND Descripcion = '" + tarea.getDescripcion() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Tarea: " + e);
        }
    }
    
    /*
    Nombre de metodo: CargarDepartamentos
    Parametros: String busqueda, Connection conexion
    Retorno: ObservableList<Departamento>
    Descripcion: Retorna un ObservableList con los departamentos que se pueden editar en el sistema
    */
    public ObservableList<Departamento> CargarDepartamentos(String busqueda, Connection conexion){
        ObservableList <Departamento> modelo = FXCollections.observableArrayList();
        String sql = GenerarSqlDepartamentos(busqueda);
        String[] datos = new String[1];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                modelo.add(new Departamento(datos[0]));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Departamentos");
        }
        return modelo;
    }
    
    /*
    Nombre de metodo: GenerarSqlDepartamentos
    Parametros: String busqueda
    Retorno: String
    Descripcion: Retorna el sql necesario para la consulta de los departamentos
    */
    private String GenerarSqlDepartamentos(String busqueda){
        if(busqueda.equals("Ninguna")){
            return "Select T1.* From Departamentos T1 Left Outer Join Proyecto T2 ON T1.Nombre = T2.Departamento WHERE "
                   + "T2.Departamento IS NULL";
        }else{
            return "Select T1.* From Departamentos T1 Left Outer Join Proyecto T2 ON T1.Nombre = T2.Departamento WHERE "
                   + "T2.Departamento IS NULL And T1.Nombre LIKE '" + busqueda + "%' group by Nombre";
        }
    }
    
    /*
    Nombre de metodo: EditarDepartamento
    Parametros: Departamento departamento, String Nombre, Connection conexion
    Retorno: Ninguno
    Descripcion: Edita un departamento del sistema
    */
    public void EditarDepartamento(Departamento departamento, String Nombre, Connection conexion){
        try {
            PreparedStatement pst = conexion.prepareStatement("Update Departamentos Set Nombre = '" + Nombre + "' Where"
                    + " Nombre = '" + departamento.getNombre() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar Departamento: " + e);
        }
    }
    
    /*
    Nombre de metodo: EliminarDepartamento
    Parametros: Departamento departamento, Connection conexion
    Retorno: Ninguno
    Descripcion: Elimina un departamento del sistema
    */
    public void EliminarDepartamento(Departamento departamentos, Connection conexion){
        try {
            PreparedStatement pst = conexion.prepareStatement("Delete from Departamentos Where Nombre = '" + 
                    departamentos.getNombre() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Departamento: " + e);
        }
    }
    
     /*
    Nombre de metodo: CargarTareas
    Parametros: ProyectoConsulta proyecto, int cedula, int rol, Connection conexion
    Retorno: ObservableList<Usuario_has_Tareas>
    Descripcion: Retorna el ObservableList con las tareas en un proyecto que puede ver el actor  
    */
    public ObservableList<Usuario_has_Tareas> CargarTareas(Proyecto proyecto,  Connection conexion){
        ObservableList <Usuario_has_Tareas> modelo = FXCollections.observableArrayList();
        String sql = "SELECT Tareas_Nombre, Usuario_idEmpleados, EstadosTareas_idEstadosTareas, "
                + "Iteraciones FROM Usuario_has_Tareas WHERE Proyecto_Nombre = '"+ proyecto.getNombre() + "' AND Proyecto_Departamento = '" + proyecto.getDepartamento() +"'";
        String[] datos = new String[4];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[2] = definirEstadoTarea(datos[2]);
                modelo.add(new Usuario_has_Tareas(proyecto.getNombre(), proyecto.getDepartamento(), datos[0], datos[1], datos[2], datos[3]));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarTareas");
        }
        return modelo;
    }
    
    /*
    Nombre de metodo: definirEstadoTarea
    Parametros: String estado
    Retorno: String
    Descripcion:  Retorna la tarea dependiendo del numero de la tarea   
    */
    private String definirEstadoTarea(String estado){
        switch (estado) {
            case "1":
                return "No Implementada";
            case "2":
                return "En Proceso";
            case "3":
                return "Implementada";
            default:
                return "Implementada";
        }
    }
    
    
}