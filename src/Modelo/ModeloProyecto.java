/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Controlador.ProyectosController;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ricardo
 */
public class ModeloProyecto {

    public void InsertarProyecto(String Nombre, String FI, String Departamento, String Estado,  String FF, int Supervisor, int Administrador, Connection conexion) {
        try {
            PreparedStatement pps = conexion.prepareStatement("INSERT INTO Proyecto(Nombre, FechaInicio, Departamento, Estado,  FechaFinal, Supervisor, Administrador) VALUES(?,?,?,?,?,?,?)");
            pps.setString(1, Nombre);
            pps.setString(2, FI);
            pps.setString(3, Departamento);
            pps.setString(4, Estado);
            pps.setString(5, FF);
            pps.setInt(6, Supervisor);
            pps.setInt (7, Administrador);
            pps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar Proyecto" + ex);

        }
    }

    public ObservableList<String> modelo = FXCollections.observableArrayList();
    public ObservableList<String> modelo1 = FXCollections.observableArrayList();
    public ObservableList<String> modelo2 = FXCollections.observableArrayList();


    public ObservableList<String> CargarUsuarios(Connection conexion) {

        String sql = "SELECT * FROM Usuario ";
        String datos = "";
        String datos2 = "";
        String cedula = "";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString("Nombre");
                cedula = rs.getString("idUsuario");
                datos2 = datos + "-" + cedula;
                modelo.addAll(datos2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarUsuarios");
        }
        return modelo;
    }

   

    public ObservableList<String> CargarTareas(Connection conexion) {

        String sql = "SELECT * FROM Tareas";
        String datos = "";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString("Nombre");
                modelo1.addAll(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarTareas");
        }
        return modelo1;
    }

    public ObservableList<String> CargarDepartamentos(Connection conexion) {

        String sql = "SELECT * FROM Departamentos";
        String datos = "";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString("Nombre");
                modelo2.addAll(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarTareas");
        }
        return modelo2;
    }
    
    
    
    public void InsertarTareaUsuario(String NombreProyecto, String NombreDepartamento, String TareaNombre, 
            int idUsuarioEmpleado,  int Estado, int Iteraciones, Connection conexion) {
        try {
            PreparedStatement pps = conexion.prepareStatement("INSERT INTO Usuario_has_Tareas(Proyecto_Nombre,"
                    + " Proyecto_Departamento, Tareas_Nombre, Usuario_idEmpleados, EstadosTareas_idEstadosTareas, iteraciones) VALUES(?,?,?,?,?,?)");
            pps.setString(1, NombreProyecto);
            pps.setString(2, NombreDepartamento);
            pps.setString(3, TareaNombre);
            pps.setInt(4, idUsuarioEmpleado);
            pps.setInt(5, Estado);
            pps.setInt(6, Iteraciones);
            pps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar Usuario/Tarea" + ex);

        }
    }
    
    public void CargarSupervisores( Connection conexion){
        
        
        String sql = "SELECT * FROM Usuario WHERE Rol = 2";
        DefaultComboBoxModel modeA = new DefaultComboBoxModel();
        String datos = "";
        String datos2 = "";
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                
                datos = rs.getString("idUsuario");
                datos2 = rs.getString("Nombre");
                
            }
            
        } catch (Exception e) {
        }
    }
    
    public ObservableList<Usuario> CargarUsuarios1(Connection conexion) {
        ArrayList<String> UsuarioNO = SupervisorNoDisponible(conexion);
        ObservableList <Usuario> modelo = FXCollections.observableArrayList();

        String sql = "SELECT idUsuario, Nombre FROM Usuario WHERE Rol = 2";
        String datos = "";
        String datos2 = "";
        String cedula = "";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString("Nombre");
                cedula = rs.getString("idUsuario");
                
                Usuario Us = new Usuario (cedula, datos, "Desconocido", "Desconocido", "Desconocido", "Desconocido", "Desconocido", "Desconocido");
                
                
                boolean bandera = true; 
                for (int i = 0; i < UsuarioNO.size(); i++) {
                    if(Us.getIdUsuario().equals(UsuarioNO.get(i))){
                        bandera = false;
                        break;
                    }
                }
                if(bandera == true){
                    modelo.addAll(Us);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarUsuarios");
        }
        return modelo;
    }
    
   
    
    
     public ArrayList<String> SupervisorNoDisponible(Connection conexion){
//    Falta restringir los usuarios que ya finalizaron la tarea
        ArrayList<String> UsuarioNO = new ArrayList<String>();
        String sql = "SELECT Supervisor FROM Proyecto";
        String datos = "";
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                datos = rs.getString("Supervisor");
                UsuarioNO.add(datos);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         return UsuarioNO;
    }

}
