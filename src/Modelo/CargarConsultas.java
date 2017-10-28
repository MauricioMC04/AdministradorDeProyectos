
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CargarConsultas {
    
//    /*
//    Nombre de metodo: CargarProyectos
//    Parametros: Usuario, Connection
//    Retorno: llamado a CargarProyectosAdmi o llamado a CargarProyectosSup o llamado a CargarProyectosEmp
//    Descripcion: Verifica el rol del usuari para identificar que datos se pueden mostrar
//    */
//    public DefaultTableModel CargarProyectos(Usuario usuario, Connection conexion){
//        if(usuario.getRol() == 1){
//            return CargarProyectosAdmi(conexion);
//        }else{
//            if(usuario.getRol() == 2){
//                return CargarProyectosSup(usuario, conexion);
//            }else{
//                return CargarProyectosEmp(usuario, conexion);
//            }
//        }
//    }
//    
//    /*
//    Nombre de metodo: CargarProyectosAdmi
//    Parametros: Connection
//    Retorno: DefaultTableModel
//    Descripcion: Carga sobre un modelo los proyectos que puede ver un administrador
//    */
//    private DefaultTableModel CargarProyectosAdmi(Connection conexion){
//        DefaultTableModel modelo = CrearModeloProyectosAdmi();
//        String sql = "SELECT * FROM Proyecto";
//        String[] datos = new String[7];
//        try {
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = rs.getString(1);
//                datos[1] = rs.getString(3);
//                datos[2] = rs.getString(7);
//                datos[3] = rs.getString(4);
//                datos[4] = rs.getString(2);
//                datos[5] = rs.getString(6);
//                datos[6] = rs.getString(5);
//                modelo.addRow(datos);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error CargarProyectosAdmi");
//        }
//        return modelo;
//    }
//    
//    /*
//    Nombre de metodo: CargarProyectosSup
//    Parametros: Usuario, Connection
//    Retorno: DefaultTableModel
//    Descripcion: Carga sobre un modelo los proyectos que puede ver un supervisor
//    */
//    private DefaultTableModel CargarProyectosSup(Usuario usuario, Connection conexion){
//        DefaultTableModel modelo = CrearModeloProyectosSup();
//        String sql = "SELECT * FROM Proyecto WHERE Supervisor = '" + Integer.toString(usuario.getIdUsuario()) + "' AND "
//                + "Estado != 'Implementada'";
//        String[] datos = new String[3];
//        try {
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = rs.getString(1);
//                datos[1] = rs.getString(3);
//                datos[2] = rs.getString(5);
//                modelo.addRow(datos);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error CargarProyectosSup");
//        }
//        return modelo;
//    }
//    
//    /*
//    Nombre de metodo: CargarProyectosEmp
//    Parametros: Usuario, Connection
//    Retorno: DefaultTableModel
//    Descripcion: Carga sobre un modelo los proyectos que puede ver un empleado
//    */
//    private DefaultTableModel CargarProyectosEmp(Usuario usuario, Connection conexion){
//        DefaultTableModel modelo = CrearModeloProyectosEmp();
//        String sql = "select  p.Nombre, p.Departamento from Proyecto p, Usuario_has_Tareas u where u.Usuario_idEmpleados = '"
//                + Integer.toString(usuario.getIdUsuario()) + "' AND p.Nombre = u.Proyecto_Nombre AND p.Departamento = "
//                + "u.Proyecto_Departamento AND p.Estado != 'Implementada'";
//        String[] datos = new String[2];
//        try {
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = rs.getString(1);
//                datos[1] = rs.getString(2);
//            }
//            modelo.addRow(datos);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error CargarProyectosEmp");
//        }
//        return modelo;
//    }
//    
//    /*
//    Nombre de metodo: CrearModeloProyectosAdmi
//    Parametros: Ninguno
//    Retorno: DefaultTableModel
//    Descripcion: Crea el modelo necesario para mostrar los proyectos a un administrador
//    */
//    private DefaultTableModel CrearModeloProyectosAdmi(){
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("Nombre");
//        modelo.addColumn("Departamento");
//        modelo.addColumn("IdSupervisor");
//        modelo.addColumn("Estado");
//        modelo.addColumn("FechaInicio");
//        modelo.addColumn("FechaFinal");
//        modelo.addColumn("Iteraciones");
//        return modelo;
//    }
//    
//    /*
//    Nombre de metodo: CrearModeloProyectosSup
//    Parametros: Ninguno
//    Retorno: DefaultTableModel
//    Descripcion: Crea el modelo necesario para mostrar los proyectos a un supervisor
//    */
//    private DefaultTableModel CrearModeloProyectosSup(){
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("Nombre");
//        modelo.addColumn("Departamento");
//        modelo.addColumn("Iteraciones");
//        return modelo;
//    }
//    
//    /*
//    Nombre de metodo: CrearModeloProyectosEmp
//    Parametros: Ninguno
//    Retorno: DefaultTableModel
//    Descripcion: Crea el modelo necesario para mostrar los proyectos a un empleado
//    */
//    private DefaultTableModel CrearModeloProyectosEmp(){
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("Nombre");
//        modelo.addColumn("Departamento");
//        return modelo;
//    }
//    
//    /*
//    Nombre de metodo: CrearModeloTareas
//    Parametros: Ninguno
//    Retorno: DefaultTableModel
//    Descripcion: Crea el modelo necesario para mostrar las tareas de un proyecto
//    */
//    private DefaultTableModel CrearModeloTareas(){
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("Tarea");
//        modelo.addColumn("Empleado");
//        modelo.addColumn("Estado");
//        return modelo;
//    }
// 
//    /*
//    Nombre de metodo: CargarTareas
//    Parametros: Usuario, Connection, String, String
//    Retorno: llamado a CargarTareasAdmiSup o llamado a CargarTareasEmp
//    Descripcion: Verifica el rol del usuario para identificar que datos se pueden mostrar
//    */
//    public DefaultTableModel CargarTareas(Usuario usuario, Connection conexion, String nombreProyecto, String departamento){
//        if(usuario.getRol() == 1 || usuario.getRol() == 2){
//            return CargarTareasAdmiSup(conexion, nombreProyecto, departamento);
//        }else{
//            return CargarTareasEmp(usuario, conexion, nombreProyecto, departamento);
//        }
//    }
//    
//    /*
//    Nombre de metodo: CargarTareasAdmiSup
//    Parametros: Connection, String, String
//    Retorno: DefaultTableModel
//    Descripcion: Carga sobre un modelo las tareas que puede ver un administrador y un supervisor
//    */
//    private DefaultTableModel CargarTareasAdmiSup(Connection conexion,  String nombreProyecto, String departamento){
//        DefaultTableModel modelo = CrearModeloTareas();
//        String sql = "SELECT Usuario_idEmpleados, Tareas_idTarea, Estado FROM Usuario_has_Tareas WHERE Proyectos_Nombre = '"
//                + nombreProyecto + "' AND Proyecto_Departamento = '" + departamento + "'";
//        String[] datos = new String[3];
//        try {
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = rs.getString(2);
//                datos[1] = rs.getString(1);
//                datos[2] = rs.getString(3);
//                modelo.addRow(datos);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error CargarTareasAdmiSup");
//        }
//        return modelo;
//    }
//    
//    /*
//    Nombre de metodo: CargarTareasEmp
//    Parametros: Usuario, Connection , String, String
//    Retorno: DefaultTableModel
//    Descripcion: Carga sobre un modelo las tareas de un proyecto que puede ver un empleado 
//    */
//    private DefaultTableModel CargarTareasEmp(Usuario usuario, Connection conexion, String nombreProyecto, String departamento){
//        DefaultTableModel modelo = CrearModeloTareas();
//        String sql = "SELECT Usuario_idEmpleados, Tareas_idTarea, Estado FROM Usuario_has_Tareas WHERE Proyectos_Nombre = '"
//                + nombreProyecto + "' AND Proyecto_Departamento = '" + departamento + "' AND Usuario_idEmpleados = '" + 
//                Integer.toString(usuario.getIdUsuario()) + "'";
//        String[] datos = new String[3];
//        try {
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = rs.getString(2);
//                datos[1] = rs.getString(1);
//                datos[2] = rs.getString(3);
//                modelo.addRow(datos);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error CargarTareasAdmiSup");
//        }
//        return modelo;
//    }
}
