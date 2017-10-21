package Controlador;

import Modelo.Conexion;
import Modelo.ModeloLogin;
import Modelo.Usuario;
import Vista.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorLogin {
    

    public boolean validar_ingreso() {

        Modelo.ModeloLogin ML = new ModeloLogin();
        String Nombreusuario = Login.TxtUsuario.getText();
        String Contrasena = String.valueOf(Login.JPContra.getPassword());
       return ML.Login(Nombreusuario,Contrasena);
       
    }

    Conexion conec = new Conexion();
    Connection c = conec.conexion();

}
