
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class InsertarTareas {
    
    /*
    Nombre de metodo: InsertarTareas
    Parametros: String, String, Connection
    Retorno: Ninguno
    Descripcion: Inserta la nueva tarea creada por el administrador
    */
    public void InsertarTarea(String nombre, String descripcion, Connection conexion){
        String RE = "";
           try {
            String sql = "select max(idTarea) FROM Tareas";
            
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            RE = rs.getString(1);}
            if(RE == null){
            RE = "1";
            }else{
            RE = Integer.toString(Integer.parseInt(RE)+1);
           }
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
   
          try{
            PreparedStatement pps = conexion.prepareStatement("INSERT INTO Tareas(idTarea,Descripcion,Nombre) VALUES(?,?,?)");
            pps.setString(1, RE);
            pps.setString(2, descripcion);
            pps.setString(3, nombre);
            pps.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    
    
    
    
}
