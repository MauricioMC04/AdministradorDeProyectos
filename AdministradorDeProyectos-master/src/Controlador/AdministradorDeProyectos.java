
package Controlador;

import Modelo.Conexion;
import java.sql.Connection;


public class AdministradorDeProyectos {

    public static void main(String[] args) {
        Conexion conec = new Conexion();
        Connection c = conec.conexion();
        
    }
    
}
