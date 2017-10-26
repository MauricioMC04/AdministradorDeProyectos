package Controlador;

import Modelo.Conexion;
import Modelo.InsertarProyecto;
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

        Modelo.InsertarProyecto MI = new InsertarProyecto();
        
        public void cbxDepartamento(){
            MI.cargarcbxDepartamento();
            
        }
             



}
