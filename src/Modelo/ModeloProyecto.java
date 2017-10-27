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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ricardo
 */
public class ModeloProyecto {

    public void InsertarProyecto(String Nombre, String FI, String Departamento, String Estado, int Iteracion, String FF, int Supervisor, Connection conexion) {
        try {
            PreparedStatement pps = conexion.prepareStatement("INSERT INTO Proyecto(Nombre, FechaInicio, Departamento, Estado, Iteraciones, FechaFinal, Supervisor) VALUES(?,?,?,?,?,?,?)");
            pps.setString(1, Nombre);
            pps.setString(2, FI);
            pps.setString(3, Departamento);
            pps.setString(4, Estado);
            pps.setInt(5, Iteracion);
            pps.setString(6, FF);
            pps.setInt(7, Supervisor);
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
                datos2 = datos + " " + cedula;
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

}
