package Modelo;

import Controlador.ControladorLogin;
import Vista.Login;
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
                Vista.Menu menu = new Vista.Menu();
                menu.setVisible(true);
                System.out.println("Modelo.ModeloLogin.Login()");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean ValidarCedula(int Cedula) {

        String SSQL = "SELECT * FROM Usuario WHERE idUsuario ='" + Cedula +"'";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            while (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Registrar(int Cedula) {
        String Nombre = Vista.Login.TxtNombreUsuario.getText();
        String Contrasena = Vista.Login.JPContraseña2.getText();
        String Pregunta = Vista.Login.TxtRespuesta.getText();
        try {
            PreparedStatement pst = c.prepareStatement("Update Usuario Set NombreUsuario = '" + Nombre + "', Contrasena "
                    + "= '" + Contrasena + "', Pregunta= '" + Pregunta + "' Where idUsuario = '" + Cedula + "'");
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar"+e);
        }
        return false;
    }
    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
