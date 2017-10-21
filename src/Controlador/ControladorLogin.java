package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import Vista.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorLogin {

    public boolean validar_ingreso(String Nombreusuario, String Contrasena) {

        Nombreusuario = Login.TxtUsuario.getText();
        Contrasena = String.valueOf(Login.JPContra.getPassword());
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
                return true;
            } else {
                Login.TxtUsuario.setText("");
                Login.JPContra.setText("");
                Login.lbldatos.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
