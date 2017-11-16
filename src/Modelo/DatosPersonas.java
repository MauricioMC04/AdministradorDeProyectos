
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DatosPersonas {
    
    /*
    Nombre de metodo: CargarPersonas
    Parametros: Connection conexion
    Retorno: ObservableList<Usuario>
    Descripcion: Retorna la llamada a Personas con el sql necesario
    */
    public ObservableList<Usuario> CargarPersonas(Connection conexion){
        String sql = "SELECT idUsuario, Nombre, Apellido, Rol FROM Usuario";
        return Personas(conexion, sql);
    }
    
    /*
    Nombre de metodo: Personas
    Parametros: Connection conexion, String sql
    Retorno: ObservableList<Usuario>
    Descripcion: Retorna el ObservableList con las personas dependiendo del sql 
    */
    private ObservableList<Usuario> Personas(Connection conexion, String sql){
        ObservableList <Usuario> modelo = FXCollections.observableArrayList();
        String[] datos = new String[4];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[3] = DefinirRol(datos[3]);
                modelo.add(new Usuario (datos[0],datos[1],datos[2],datos[3],"Desconocido","Desconocido" ,"Desconocido",
                           "Desconocido"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error CargarPersonas");
        }
        return modelo;
    }
    
    /*
    Nombre de metodo: DefinirRol 
    Parametros: String rol
    Retorno: String
    Descripcion: Retorna el rol correspondiente dependiento del numero de Rol
    */
    private String DefinirRol(String rol){
        if(rol.equals("1")){
            return "Administrador";
        }else if(rol.equals("2")){
            return "Supervisor";
        }else{
            return "Empleado";
        }
    }
    
    /*
    Nombre de metodo: CargarPersonasEditables
    Parametros: Connection conexion 
    Retorno: ObservableList<Usuario>
    Descripcion: Carga sobre un modelo las personas que puede editar un administrador
    */
   public ObservableList<Usuario> CargarPersonasEditables(Connection conexion){
        String sql = "SELECT idUsuario, Nombre, Apellido, Rol FROM Usuario WHERE Contrasena != 'Por Definir'";
        return Personas(conexion, sql);
    }  
    
    /*
    Nombre de metodo: GenerarPersonaNueva
    Parametros: String cedula, String nombre, String apellido, String rol
    Retorno: Usuario
    Descripcion: Genera un nuevo usuario para ser insertado por el administrador
    */
    private Usuario GenerarPersonaNueva(String cedula, String nombre, String apellido, String rol){
        String nuevoRol = "";
        if(rol.equals("Administrador")){
            nuevoRol = "1";
        }else if(rol.equals("Supervisor")){
            nuevoRol = "2";
        }else{
            nuevoRol = "3";
        }
        Usuario usuario = new Usuario(cedula, nombre, apellido, nuevoRol, "Por Definir", "Por Definir",
                "Por Definir", "0");
        return usuario;        
    }
    
    /*
    Nombre de metodo: InsertarPersonaNueva
    Parametros: String cedula, String nombre, String apellido, String rol, Connection conexion
    Retorno: Ninguno
    Descripcion: Inserta la nueva persona creada por el administrador
    */
   public void InsertarPersonaNueva(String cedula, String nombre, String apellido, String rol, Connection conexion){
        Usuario usuario = GenerarPersonaNueva(cedula, nombre, apellido,rol);
        try {
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO Usuario(idUsuario,Nombre,"
                    + "Apellido,Rol,Contrasena,Respuesta,NombreUsuario, Pregunta) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, usuario.getIdUsuario());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getRol());
            pst.setString(5, usuario.getContrasena());
            pst.setString(6, usuario.getRespuesta());
            pst.setString(7, usuario.getNombreUsuario());
            pst.setString(8, usuario.getPregunta());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la persona");
        }
    }
    
    /*
    Nombre de metodo: EliminarPersona
    Parametros: String cedula, Connection conexion
    Retorno: Ninguno
    Descripcion: Elimina una persona del sistema
    */
    public void EliminarPersona(String cedula, Connection conexion){
        try {
            PreparedStatement pst = conexion.prepareStatement("DELETE FROM Usuario WHERE idUsuario = '" + cedula + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminarPersona");
        }   
    }
    
     /*
    Nombre de metodo: EditarPersona
    Parametros: String cedula, String nombre, String apellido, String rol, Connection conexion
    Retorno: Ninguno
    Descripcion: Edita una persona del sistema con la nueva informacion
    */
    public void EditarPersona(String cedula, String nombre, String apellido, String rol, Connection conexion){
        String numRol;
        if(rol.equals("Administrador")){
            numRol = "1";
        }else if(rol.equals("Supervisor")){
            numRol = "2";
        }else{
            numRol = "3";
        }
        try {
            PreparedStatement pst = conexion.prepareStatement("Update Usuario Set Nombre = '" + nombre + "', Apellido "
                    + "= '" + apellido + "', Rol = '" + numRol + "' Where idUsuario = '" + cedula + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editarPersona");
        }  
    } 
    
    /*
    Nombre de metodo: CargarBusquedaEliminar
    Parametros: Connection conexion, String busqueda
    Retorno: ObservableList<Usuario>
    Descripcion: Retorna la llamada a Personas con el sql necesario
    */
    public ObservableList<Usuario> CargarBusquedaEliminar (Connection conexion, String busqueda){
        String sql = "SELECT idUsuario, Nombre, Apellido, Rol FROM Usuario WHERE idUsuario Like '" + busqueda + "%' OR "
                + "Nombre Like '" + busqueda + "%' OR Apellido Like '" + busqueda + "%' OR Rol Like '" + busqueda + "%'";
        return Personas(conexion, sql);
    }
    
    /*
    Nombre de metodo: CargarBusquedaEditar
    Parametros: Connection conexion, String busqueda
    Retorno: ObservableList<Usuario>
    Descripcion: Retorna la llamada a Personas con el sql necesario
    */
    public ObservableList<Usuario> CargarBusquedaEditar (Connection conexion, String busqueda){
        String sql = "SELECT idUsuario, Nombre, Apellido, Rol FROM Usuario WHERE Contrasena != 'Por Definir' AND ("
                + "idUsuario Like '" + busqueda + "%' OR Nombre Like '" + busqueda + "%' OR Apellido Like '" + 
                busqueda + "%' OR Rol Like '" + busqueda + "%')";
        return Personas(conexion, sql);
    }
}
