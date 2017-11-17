
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
    
    /*
    Nombre de metodo: CargarProyectos
    Parametros: int cedula, int rol, Connection conexion
    Retorno: ObservableList<ProyectoConsulta>
    Descripcion: Retorna la llamada al metodo que carga los proyectos dependiendo del rol
    */
    public ObservableList<ProyectoConsulta> CargarProyectos(int cedula, int rol, Connection conexion){
        if(rol == 1 || rol == 2){
            return CargarProyectosAdmiSup(cedula, rol,"Ninguno", "Ninguno", conexion);
        }else {
            return CargarProyectosEmpleado(cedula, conexion);
        }
    }
    
    /*
    Nombre de metodo: GenerarSqlProyectos
    Parametros: int cedula, int rol, String filtro, String dato
    Retorno: String
    Descripcion: Retorna el sql para cargar los proyectos dependiendo del rol 
    */
    private String GenerarSqlProyectos(int cedula, int rol, String filtro, String dato){
         switch (rol) {
            case 1:
                switch (filtro) {
                    case "Proyecto":
                        return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                            + "Proyecto WHERE Nombre LIKE '" + dato + "%'";
                    case "Departamento":
                        return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                            + "Proyecto WHERE Departamento LIKE '" + dato + "%'";
                    case "Supervisor":
                        return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                            + "Proyecto WHERE Supervisor LIKE '" + dato + "%'";
                    case "Estado":
                        return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                            + "Proyecto WHERE Estado LIKE '" + dato + "%'";
                    default:
                        return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM "
                            + "Proyecto";
                }
            case 2:
                return "SELECT Nombre, Departamento, FechaInicio, FechaFinal, Administrador, Supervisor, Estado FROM " +
                    "Proyecto WHERE Supervisor = " + cedula + " And Estado != 'Finalizado'";
            default:
                return "SELECT Proyecto_Nombre, Proyecto_Departamento FROM Usuario_has_Tareas WHERE Usuario_idEmpleados = "
                    + cedula + " AND Proyecto_Nombre in (select Nombre from Proyecto WHERE Estado != 'Finalizado') AND "
                    + "Proyecto_Departamento in (select Departamento from Proyecto WHERE Estado != 'Finalizado')";
        }
    }
    
    /*
    Nombre de metodo: CargarProyectosAdmiSup
    Parametros: int cedula, int rol, String filtro, String dato,Connection conexion
    Retorno: ObservableList<ProyectoConsulta>
    Descripcion: Retorna el ObservableList con los proyectos que puede ver el actor  
    */
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
    
    /*
    Nombre de metodo: CargarProyectosEmpleado
    Parametros: int cedula, Connection conexion
    Retorno: ObservableList<ProyectoConsulta>
    Descripcion: Retorna el ObservableList con los proyectos que puede ver el empleado  
    */
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
    
    /*
    Nombre de metodo: CargarTareas
    Parametros: ProyectoConsulta proyecto, int cedula, int rol, Connection conexion
    Retorno: ObservableList<Usuario_has_Tareas>
    Descripcion: Retorna el ObservableList con las tareas en un proyecto que puede ver el actor  
    */
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
    
    /*
    Nombre de metodo: GenerarSqlTareas
    Parametros: ProyectoConsulta proyecto, int cedula, int rol
    Retorno: String
    Descripcion:  Retorna el sql para las tareas dependiendo del rol  
    */
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
    
    /*
    Nombre de metodo: definirEstadoTarea
    Parametros: String estado
    Retorno: String
    Descripcion:  Retorna la tarea dependiendo del numero de la tarea   
    */
    private String definirEstadoTarea(String estado){
        switch (estado) {
            case "1":
                return "No Implementada";
            case "2":
                return "En Proceso";
            case "3":
                return "Implementada";
            default:
                return "Implementada";
        }
    }
    
    /*
    Nombre de metodo: CargarProyectosBusqueda
    Parametros: int cedula, int rol, String filtro, String dato, Connection conexion
    Retorno: ObservableList<ProyectoConsulta>
    Descripcion:  Retorna la llamada al metodo que carga lo proyectos que el actor puede ver
    */
    public ObservableList<ProyectoConsulta> CargarProyectosBusqueda(int cedula, int rol, String filtro, String dato, Connection conexion){
        return CargarProyectosAdmiSup(cedula, rol, filtro, dato, conexion);
    }
    
    /*
    Nombre de metodo: Editar
    Parametros: Usuario_has_Tareas tarea, String estado, Connection conexion
    Retorno: Ninguno 
    Descripcion: Edita la tarea del proyecto en el sistema
    */
    public void Editar(Usuario_has_Tareas tarea, String estado, Connection conexion){
        String numEstado;
        switch (estado) {
            case "No Implementada":
                numEstado = "1";
            break;
            case "En Proceso":
                numEstado = "2";
            break;
            case "Implementada":
                numEstado = "3";
            break;
            default:
                numEstado = "3";
            break;
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
