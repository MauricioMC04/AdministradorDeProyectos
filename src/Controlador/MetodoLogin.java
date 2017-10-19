package Controlador;

import Modelo.Conexion;
import Vista.Login;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodoLogin {

    public int validar_ingreso(String Nombreusuario, String Contraseña) {

        Nombreusuario = Login.TxtUsuario.getText();
        Contraseña = String.valueOf(Login.JPContra.getPassword());
        int resultado = 0;

        String SSQL = "SELECT * FROM Usuario WHERE NombreUsuario ='" + Nombreusuario + "' AND Contrasena=('" + Contraseña + "')";
        String cap = "";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            while (rs.next()) {

                cap = rs.getString("Rol");
            }
            if (cap.equals("1")) {
               Vista.Login asd = new Vista.Login();
               asd.setVisible(false);
                Controlador asdf = new Controlador();
                asdf.Personas();
                }else if(cap.equals("2")){
            
            Vista.VentanapruebaSupervisor asdd = new Vista.VentanapruebaSupervisor();
                asdd.setVisible(true);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(MetodoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
