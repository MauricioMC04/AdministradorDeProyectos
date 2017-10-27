package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModeloLogin {

    public boolean Login(String Nombreusuario, String Contrasena) {
        String SSQL = "SELECT * FROM Usuario WHERE NombreUsuario ='" + Nombreusuario + "' AND Contrasena=('" + Contrasena + "')";
        String cap = "";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            while (rs.next()) {
                cap = rs.getString("Rol");
            }
            if (cap.equals("1")) {
                return true;
            }
        } catch (SQLException ex) {
           
        }
        return false;
    }

    public boolean ValidarCedula(int Cedula) {
        String definir = "Por Definir";
        String SSQL = "SELECT * FROM Usuario WHERE (idUsuario = '"+Cedula+"')AND(Contrasena = '"+definir+"')";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al Validar"); 
        }
        return false;
    }

    public boolean Registrar(int Cedula, String Nombre, String Contrasena, String Respuesta,int Pregunta) {
    try {
            PreparedStatement pst = c.prepareStatement("Update Usuario Set NombreUsuario = '" + Nombre + "', Contrasena "
                    + "= '" + Contrasena + "', Respuesta= '" + Respuesta + "', Pregunta ='"+Pregunta+"' Where idUsuario = '" + Cedula + "'");
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar" + e);
        }
        return false;
    }
    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
