
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class InsertarDepartamento {
    
    
     /*
    Nombre de metodo: InsertarDepartamento
    Parametros: String, String, Connection
    Retorno: Ninguno
    Descripcion: Inserta la nueva tarea creada por el administrador
    */
    
     public void InsertarDepartamento(String Nombre, Connection conexion){
          try {
            PreparedStatement pps = conexion.prepareStatement("INSERT INTO Departamentos(Nombre) VALUES(?)");
            pps.setString(1, Nombre);
            pps.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
}
