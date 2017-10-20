
package Controlador;

import Modelo.Conexion;
import Vista.Insertar;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InsertarControlador {
    
    Conexion conec = new Conexion();
    Connection c = conec.conexion();
    
    public void InsertarDepartamento(String Nombre){
          try {
            PreparedStatement pps = c.prepareStatement("INSERT INTO Departamentos(Nombre) VALUES(?)");
            pps.setString(1, Nombre);
            pps.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
       public void InsertarTareas(String Nombre, String Descripcion){
           String RE = "";
           try {
            String sql = "select max(idTarea) FROM Tareas";
            
            Statement st = c.createStatement();
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
            PreparedStatement pps = c.prepareStatement("INSERT INTO Tareas(idTarea,Descripcion,Nombre) VALUES(?,?,?)");
            pps.setString(1, RE);
            pps.setString(2, Descripcion);
            pps.setString(3, Nombre);
            pps.executeUpdate();
        } catch (SQLException ex) {
            
        }
       }
}

 