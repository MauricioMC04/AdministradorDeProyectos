package Controlador;

import Modelo.Conexion;
import Vista.Login;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodoLogin {

    public int validar_ingreso(String usuario, String Contraseña) {

        usuario = Login.TxtUsuario.getText();
        Contraseña = String.valueOf(Login.JPContra.getPassword());
        int resultado = 0;

        String SSQL = "SELECT * FROM USUARIO WHERE NombreUsuario ='" + usuario + "' AND Contrasena=sha1('" + Contraseña + "')";
        String cap = "";

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            while (rs.next()) {

                cap = rs.getString("Rol");

            }
            if (cap.equals(1)) {
                Vista.Ventanapruebaadmi asd = new Vista.Ventanapruebaadmi();
                asd.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MetodoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
