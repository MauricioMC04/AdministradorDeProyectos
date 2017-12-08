package Modelo;

import Controlador.MenuController;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class ModeloLogin {
    public String idiomas = "Nostro";
    /*
    Metodo de Ingreso al sistema
     */
    public int Login(String Nombreusuario, String Contrasena) {
        String SSQL = "SELECT * FROM Usuario WHERE NombreUsuario ='" + Nombreusuario + "' AND Contrasena=('" + Contrasena + "')";
        String cap = "";
        String cap2 = "";
        String cap3 = "";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            while (rs.next()) {
                cap = rs.getString("Rol");
                cap2 = rs.getString("idUsuario");
                cap3 = rs.getString("NombreUsuario");
                if (Nombreusuario.equals(cap3)) {
                    break;
                }
            }
            MenuController.Cedula = Integer.parseInt(cap2);
            switch (cap) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default:
                    return 4;

            }
        } catch (SQLException ex) {
        }
        return 0;
    }

//    public int Login(String Nombreusuario, String Contrasena) {
//        String SSQL = "SELECT * FROM Usuario WHERE NombreUsuario ='" + Nombreusuario + "' AND Contrasena=('" + Contrasena + "')";
//        String cap = "";
//        String cap2 = "";
//        String cap3 = "";
//        try {
//            Statement st = c.createStatement();
//            ResultSet rs = st.executeQuery(SSQL);
//            while (rs.next()) {
//                cap = rs.getString("Rol");
//                cap2 = rs.getString("idUsuario");
//                cap3 = rs.getString("NombreUsuario");
//                if(Nombreusuario.equals(cap3)){
//                break;
//            }
//            }
//            MenuController.Cedula = Integer.parseInt(cap2);
//            if (cap.equals("1")) {
//                return 1;
//            }
//             if (cap.equals("2")) {
//                return 2;
//            }
//              if (cap.equals("3")) {
//                return 3;
//            }
//              if (cap.equals("")) {
//                return 4;
//            }
//        } catch (SQLException ex) {
//        }
//        return 0;
//    }
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

    /*
    Nombre de metodo: CargarIdiomas
    Parametros: Ninguno
    Retorno: ObservableList<String>
    Descripcion: Carga en el ObservableList los idiomas disponibles 
    */
    public ObservableList<String> CargarIdiomas(){
        ObservableList <String> idiomas = FXCollections.observableArrayList();
        String userDir = System.getProperty("user.dir");
        String Directorio = userDir+"\\src\\Idiomas";
        File f = new File(Directorio);
        if (f.exists()){
            File[] ficheros = f.listFiles();
            for (int i = 0; i < ficheros.length; i++){
                String nombre = ficheros[i].getName();
                if(!nombre.equals("Idiomas.java")){
                    idiomas.add(nombre.substring(0, nombre.length() - 11));
                }
            }
        }        
        return idiomas;
    }
}
