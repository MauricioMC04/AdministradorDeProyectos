package Controlador;

import Modelo.Conexion;
import Vista.Proyectos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorProyecto {

    Conexion conec = new Conexion();
    Connection c = conec.conexion();

    public void mostrartabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdUsuario");
        modelo.addColumn("Nombres");

    }

    private DefaultTableModel CrearModeloUsuario() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");

        return modelo;
    }

    private DefaultTableModel MostrarTablaUsuario(Connection conexion) {
        DefaultTableModel modelo = CrearModeloUsuario();
        String sql = "SELECT * FROM Usuario";
        String[] datos = new String[2];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarProyectosAdmi");
        }
        return modelo;
    }

    public void MostarPrincipal() {
        Vista.Proyectos principal = new Vista.Proyectos();
        principal.setVisible(true);

    }

    public void InsertarProyecto(String Nombre, String FI, String Departamento, String Estado, int Iteracion, String FF, int Supervisor) {
        try {
            PreparedStatement pps = c.prepareStatement("INSERT INTO Proyecto(Nombre, FechaInicio, Departamento, Estado, Iteraciones, FechaFinal, Supervisor) VALUES(?,?,?,?,?,?,?)");
            pps.setString(1, Nombre);
            pps.setString(2, FI);
            pps.setString(3, Departamento);
            pps.setString(4, Estado);
            pps.setInt(5, Iteracion);
            pps.setString(6, FF);
            pps.setInt(7, Supervisor);
            pps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo" + ex);

        }
    }

}
