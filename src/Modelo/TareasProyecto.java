
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;



 public class TareasProyecto {
//    ArrayList<String> EmpleadoD = new ArrayList<String>();
    
    public ObservableList<Usuario> CargarUsuario(Connection conexion){
        ArrayList<String> EmpleadoD = EmpleadosDNoisponibles(conexion);
        ObservableList <Usuario> modelo = FXCollections.observableArrayList();
        
        String sql = "SELECT idUsuario, Nombre, Apellido FROM Usuario WHERE Rol = 3";
        String[] datos = new String[4];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                Usuario Us = new Usuario (datos[0],datos[1],datos[2],"Desconocido","Desconocido","Desconocido" ,"Desconocido",
                           "Desconocido");
                
                boolean bandera = true; 
                for (int i = 0; i < EmpleadoD.size(); i++) {
                    if(Us.getIdUsuario().equals(EmpleadoD.get(i))){
                        bandera = false;
                        break;
                    }
                }
                if(bandera == true){
                    modelo.addAll(Us);
                }
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarPersonas");
        }
        return modelo;
    }
    
    
    
    public ArrayList<String> EmpleadosDNoisponibles(Connection conexion){
//    Falta restringir los usuarios que ya finalizaron la tarea
        ArrayList<String> EmpleadoD = new ArrayList<String>();
        String sql = "SELECT Usuario_idEmpleados FROM Usuario_has_Tareas WHERE EstadosTareas_idEstadosTareas != 3";
        String datos = "";
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                datos = rs.getString("Usuario_idEmpleados");
                EmpleadoD.add(datos);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         return EmpleadoD;
    }
    
    
}