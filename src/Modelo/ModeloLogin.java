package Modelo;

import Controlador.ControladorLogin;
import Vista.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloLogin {

    public boolean Login(String Nombreusuario, String Contrasena) {
        Controlador.ControladorLogin CL = new ControladorLogin();
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
