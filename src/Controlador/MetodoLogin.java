package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import Vista.Login;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodoLogin {

    public int validar_ingreso(String Nombreusuario, String Contrasena) {

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
                Controlador.ControladorPersonasConsultas c = new ControladorPersonasConsultas();
                c.setUsuario(new Usuario(3, "s", "s", 1, "s", "s", "s"));
                c.Personas();
                Controlador.PrincipalControlador b = new PrincipalControlador();
                b.InsertarProyecto();
            
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
