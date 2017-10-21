package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import Vista.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodoLogin {

    public void validar_ingreso(String Nombreusuario, String Contrasena) {

        Nombreusuario = Login.TxtUsuario.getText();
        Contrasena = String.valueOf(Login.JPContra.getPassword());
        int resultado = 0;

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
            }else {
            Login.TxtUsuario.setText("");
            Login.JPContra.setText("");
            
             
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(MetodoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
