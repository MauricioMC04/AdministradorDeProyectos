
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection conexion = null;

    /*
    Nombre de metodo: conexion
    Parametros: Ninguno
    Retorno: Un obejeto Connection
    Descripcion: Metodo encargado de hacer la coneccion con el hosting de la base de datos
    */
    public Connection conexion() {
        try {
            conexion = null;
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10199786", "sql10199786", "ePKENjFQXk");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error de conexion " + e);
        }
        return conexion;
    }
}
