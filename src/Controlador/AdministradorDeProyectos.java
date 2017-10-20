
package Controlador;

import Modelo.Conexion;
import java.sql.Connection;

/**
 *
 * @author Josue
 */
public class AdministradorDeProyectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conec = new Conexion();
        Connection c = conec.conexion();
        
        
        Vista.Menu M = new Vista.Menu();
        M.setVisible(true);
    }

}

