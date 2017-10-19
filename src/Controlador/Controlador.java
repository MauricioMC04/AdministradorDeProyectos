
package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import Modelo.CargarConsultas;
import Modelo.DatosPersonas;
import Vista.Consultar;
import Vista.Personas;
import java.sql.Connection;

public class Controlador {

    private Usuario usuario;
    private Conexion conect = new Conexion();
    private Connection conexion = conect.conexion();
    private Consultar consultar = new Consultar();
    private CargarConsultas cargarConsultas = new CargarConsultas();
    //private Personas personas = new Personas();
    private DatosPersonas datosPersonas = new DatosPersonas();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public static void main(String[] args) {
        
    }
    
    /*
    Nombre de metodo: Consultar
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: llamado a la vista consultar y cargo de modelo correspondiente
    */
    public void Consultar(){
        consultar.setVisible(true);
        consultar.setControlador(this);
        consultar.MostrarDatos(cargarConsultas.CargarProyectos(usuario, conexion));
    }
    
    /*
    Nombre de metodo: Personas
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: llamado a la vista Personas y cargo de los modelos correspondientes
    */
    public void Personas(Personas personas){
        personas.setVisible(true);
        personas.setControlador(this);
        personas.MostrarDatosAgregar(datosPersonas.CargarPersonas(conexion));
        personas.MostrarDatosEliminar(datosPersonas.CargarPersonas(conexion));
        personas.MostrarDatosEditar(datosPersonas.CargarPersonasEditables(conexion));
    }
    
    /*
    Nombre de metodo: InsertarPersona
    Parametros: String, String
    Retorno: Ninguno
    Descripcion: llamado al metodo InsertarPersonaNueva en el modelo DatosPersonas 
    */
    public void InsertarPersona(String cedula, String rol){
        datosPersonas.InsertarPersonaNueva(cedula, rol, conexion);
    }
    
    /*
    Nombre de metodo: EliminarPersona
    Parametros: String
    Retorno: Ninguno
    Descripcion: llamado al metoso EliminarPersonas en el modelo DatosPersonas
    */
    public void EliminarPersona(String cedula){
        datosPersonas.EliminarPersona(cedula, conexion);
    }
    
    /*
    Nombre de metodo: EditarPersona
    Parametros: String, String, String, String
    Retorno: Ninguno
    Descripcion: llamado al metodo EditarPersonas en el modelo DatosPersonas
    */
    public void EditarPersona(String cedula, String nombre, String apellido, String rol){
        datosPersonas.EditarPersona(cedula, nombre, apellido, rol, conexion);
    }
}
