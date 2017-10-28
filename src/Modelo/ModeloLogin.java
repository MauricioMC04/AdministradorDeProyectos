package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        String SSQL = "SELECT * FROM Usuario WHERE (idUsuario = '" + Cedula + "')AND(Contrasena = '" + definir + "')";
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

    public boolean ValidarCambioContraseña(int Cedula, String respuesta) {
        String SSQL = "SELECT * FROM Usuario WHERE (idUsuario = '" + Cedula + "')";
        String cap = "";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            while (rs.next()) {
                cap = rs.getString("Respuesta");
            }
            if (cap.equals(respuesta)) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al validar la respuesta");
        }
        return false;
    }

    public boolean Registrar(int Cedula, String Nombre, String Contrasena, String Respuesta, int Pregunta) {
        try {
            PreparedStatement pst = c.prepareStatement("Update Usuario Set NombreUsuario = '" + Nombre + "', Contrasena "
                    + "= '" + Contrasena + "', Respuesta= '" + Respuesta + "', Pregunta ='" + Pregunta + "' Where idUsuario = '" + Cedula + "'");
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar" + e);
        }
        return false;
    }

    public boolean ValidarNombreusuario(String Nombre) {
        ArrayList<String> NombreUsuarios = NombreUsuarioDisponible();
        for (int i = 0; i < NombreUsuarios.size(); i++) {
            if (Nombre.equals(NombreUsuarios.get(i))) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> NombreUsuarioDisponible() {
        ArrayList<String> NombreUsuarioD = new ArrayList<String>();
        String sql = "SELECT NombreUsuario FROM Usuario";
        String datos = "";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString("NombreUsuario");
                NombreUsuarioD.add(datos);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return NombreUsuarioD;
    }

    public boolean CambiarContraseña(String contrasena, int Cedula) {
        try {
            PreparedStatement pst = c.prepareStatement("Update Usuario Set Contrasena = '" + contrasena + "' Where idUsuario = '" + Cedula + "'");
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
