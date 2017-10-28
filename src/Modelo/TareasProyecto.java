
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


public class TareasProyecto {
    
    
    public ObservableList<Usuario> CargarUsuario(Connection conexion){
        ObservableList <Usuario> modelo = FXCollections.observableArrayList();
        String sql = "SELECT idUsuario, Nombre, Apellido FROM Usuario";
        String[] datos = new String[4];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                
                modelo.add(new Usuario (datos[0],datos[1],datos[2],"Desconocido","Desconocido","Desconocido" ,"Desconocido" ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarPersonas");
        }
        return modelo;
    }
    
    
}
