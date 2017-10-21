
package Controlador;

import Modelo.Conexion;
import java.sql.Connection;


public class AdministradorDeProyectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conec = new Conexion();
        Connection c = conec.conexion();
        
        
        Vista.Login lo = new Vista.Login();
        lo.setVisible(true);
    }

}

