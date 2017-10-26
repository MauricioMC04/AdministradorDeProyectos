package Controlador;

import Modelo.Conexion;
import Modelo.ModeloLogin;
import Modelo.Usuario;
import Vista.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorLogin {
    Modelo.ModeloLogin ML = new ModeloLogin();
 

    public boolean validar_ingreso() {
        String Nombreusuario = Login.TxtUsuario.getText();
        String Contrasena = String.valueOf(Login.JPContra.getPassword());
       return ML.Login(Nombreusuario,Contrasena);
       
    }
   public boolean ValidarRegistrarse(){
   int cedula = Integer.parseInt(Vista.Login.TxtValidarCedula.getText());
   return ML.ValidarCedula(cedula);
   } 
   
   public boolean Registrarse(){
    int cedula = Integer.parseInt(Vista.Login.TxtValidarCedula.getText());
   return ML.Registrar(cedula);
   }
   

 
}
