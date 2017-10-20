
package Controlador;

import Modelo.Conexion;
import Vista.Principal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class PrincipalControlador {
    
    Conexion conec = new Conexion();
    Connection c = conec.conexion();
    
    public void mostrartabla(){
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("IdUsuario");
    modelo.addColumn("Nombres");
    
    }
    
    
    public void InsertarProyecto(){
        
        String Nombre="";
        Date FI =null ;
        String Departamento="";
        String Estado="";
        int Iteracion=0;
        Date FF = null;
        String Supervisor="";
        
        Vista.Principal ca = new Principal();
        ca.setVisible(true);
          try {
            PreparedStatement pps = c.prepareStatement("INSERT INTO Proyecto(Nombre, "
                    + "FI, Departamento, Estado, Iteracion, FF, Supervisor) VALUES(?,?,?,?,?,?,?)");
            pps.setString(1, Nombre);
            pps.setDate(2, FF);
            pps.setString(3, Departamento);
            pps.setString(4, Estado);
            pps.setInt(5, Iteracion);
            pps.setDate(6, FF);
            pps.setString(7, Supervisor);
            pps.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    

    
}
