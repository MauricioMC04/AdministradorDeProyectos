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
    public void InsertarTarea(String nombre, String descripcion, Connection conexion) {
       

        try {
            PreparedStatement pps = conexion.prepareStatement("INSERT INTO Tareas(Descripcion,Nombre) VALUES(?,?)");
            pps.setString(1, descripcion);
            pps.setString(2, nombre);
            pps.executeUpdate();
        } catch (SQLException ex) {

        }
    }

}
