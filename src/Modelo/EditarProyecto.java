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

    public ObservableList<Tarea> CargarTareas(String busqueda, Connection conexion){
        ObservableList <Tarea> modelo = FXCollections.observableArrayList();
        String sql = GenerarSqlProyectos(busqueda);
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
    
    private String GenerarSqlProyectos(String busqueda){
        if(busqueda.equals("Ninguna")){
            return "Select T1.* From Tareas T1 Left Outer Join Usuario_has_Tareas T2 ON T1.Nombre = T2.Tareas_Nombre "
                   + "WHERE T2.Tareas_Nombre IS NULL";
        }else{
            return "Select T1.* From Tareas T1 Left Outer Join Usuario_has_Tareas T2 ON T1.Nombre = T2.Tareas_Nombre "
                   + "WHERE T2.Tareas_Nombre IS NULL And T1.Nombre LIKE '" + busqueda + "%' OR T1.Descripcion LIKE '" 
                   + busqueda + "%' group by Nombre";
        }
    }
    
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
    
    public void EliminarTarea(Tarea tarea, Connection conexion){
        try {
            PreparedStatement pst = conexion.prepareStatement("Delete from Tareas Where Nombre = '" + tarea.getNombre() + "'"
                    + " AND Descripcion = '" + tarea.getDescripcion() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Tarea: " + e);
        }
    }
}