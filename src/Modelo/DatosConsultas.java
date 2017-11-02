
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class DatosConsultas {
    
    public ObservableList<ProyectoConsulta> CargarProyectos(int cedula, int rol, Connection conexion){
        if(rol == 1 || rol == 2){
            return CargarProyectosAdmiSup(cedula, rol,"Ninguno", "Ninguno", conexion);
        }else {
            return CargarProyectosEmpleado(cedula, conexion);
        }
    }
    
    private String GenerarSqlProyectos(int cedula, int rol, String filtro, String dato){
        if(rol == 1){
            if(filtro.equals("Proyecto")){
                return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                    + "Proyecto WHERE Nombre LIKE '" + dato + "%'";
            }else if (filtro.equals("Departamento")){
                return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                    + "Proyecto WHERE Departamento LIKE '" + dato + "%'";
            }else if(filtro.equals("Supervisor")){
                return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                    + "Proyecto WHERE Supervisor LIKE '" + dato + "%'";
            }else if(filtro.equals("Estado")){
                return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                    + "Proyecto WHERE Estado = " + dato;
            } 
            return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                    + "Proyecto";
        }else if(rol == 2) {
            return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM " +
                    "Proyecto WHERE Supervisor = " + cedula + " And Estado != 'Finalizado'";
        }else {
            return "SELECT Proyecto_Nombre, Proyecto_Departamento FROM Usuario_has_Tareas WHERE Usuario_idEmpleados = "
                    + cedula + " AND Proyecto_Nombre in (select Nombre from Proyecto WHERE Estado != 'Finalizado') AND "
                    + "Proyecto_Departamento in (select Departamento from Proyecto WHERE Estado != 'Finalizado')";
        }
    }
    
    private ObservableList<ProyectoConsulta> CargarProyectosAdmiSup(int cedula, int rol, String filtro, String dato,Connection conexion){
        ObservableList <ProyectoConsulta> modelo = FXCollections.observableArrayList();
        String sql = GenerarSqlProyectos(cedula, rol, filtro, dato);
        String[] datos = new String[7];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.add(new ProyectoConsulta(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarProyectosAdmiSup");
        }
        return modelo;
    }
    
    private ObservableList<ProyectoConsulta> CargarProyectosEmpleado(int cedula, Connection conexion){ 
        ObservableList <ProyectoConsulta> modelo = FXCollections.observableArrayList();
        String sql = GenerarSqlProyectos(cedula, 3, "", "");
        String[] datos = new String[2];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                modelo.add(new ProyectoConsulta(datos[0],datos[1],"","","","",""));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarProyectosEmpleado");
        }
        return modelo;
    }
    
    public ObservableList<Usuario_has_Tareas> CargarTareas(ProyectoConsulta proyecto, int cedula, int rol, Connection conexion){
        ObservableList <Usuario_has_Tareas> modelo = FXCollections.observableArrayList();
        String sql = GenerarSqlTareas(proyecto, cedula, rol);
        String[] datos = new String[4];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[2] = definirEstadoTarea(datos[2]);
                modelo.add(new Usuario_has_Tareas(proyecto.getNombre(), proyecto.getDepartamento(), datos[0], datos[1], datos[2], datos[3]));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarTareas");
        }
        return modelo;
    }
    
    private String GenerarSqlTareas(ProyectoConsulta proyecto, int cedula, int rol){
        if(rol == 1 || rol == 2){
            return "SELECT Tareas_Nombre, Usuario_idEmpleados, EstadosTareas_idEstadosTareas, iteraciones from Usuario_"
                    + "has_Tareas WHERE Proyecto_Nombre = '" + proyecto.getNombre() + "' AND Proyecto_Departamento = '"
                    + proyecto.getDepartamento() + "'";
        }else{
            return "SELECT Tareas_Nombre, Usuario_idEmpleados, EstadosTareas_idEstadosTareas, iteraciones from Usuario_"
                    + "has_Tareas WHERE Proyecto_Nombre = '" + proyecto.getNombre() + "' AND Proyecto_Departamento = '"
                    + proyecto.getDepartamento() + "' AND Usuario_idEmpleados = " + cedula + " AND EstadosTareas_idEstadosTareas !"
                    + "= 3"; 
        }
    }
    
    private String definirEstadoTarea(String estado){
        if(estado.equals("1")){
            return "No Implementada";
        }else if(estado.equals("2")){
            return "En Proceso";
        }else{
            return "Implementada";
        }
    }
    
    public ObservableList<ProyectoConsulta> CargarProyectosBusqueda(int cedula, int rol, String filtro, String dato, Connection conexion){
        return CargarProyectosAdmiSup(cedula, rol, filtro, dato, conexion);
    }
    
    public void Editar(Usuario_has_Tareas tarea, String estado, Connection conexion){
        String numEstado;
        if(estado.equals("No Implementada")){
            numEstado = "1";
        }else if(estado.equals("En Proceso")){
            numEstado = "2";
        }else{
            numEstado = "3";
        }
        try {
            PreparedStatement pst = conexion.prepareStatement("Update Usuario_has_Tareas Set EstadosTareas_idEstadosTareas"
                    + " = " + numEstado + " Where Proyecto_Nombre = '" + tarea.getNombreProyecto() + "' AND Proyecto_Departamento"
                    + " = '" + tarea.getDepartamento() + "' AND Tareas_Nombre = '" + tarea.getTarea() + "' AND Usuario_idEmpleados"
                    + " = '" + tarea.getEmpleado() + "' AND iteraciones = " + tarea.getIteraciones());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editarTarea");
        }  
    }
}
