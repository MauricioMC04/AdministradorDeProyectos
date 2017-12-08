/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idiomas;

import Modelo.ModeloLogin;
import java.awt.HeadlessException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Idiomas extends Properties{
    
    private static final long serialVersionUID = 1L;
	        
    public Idiomas(String idioma){
        //Modelo.ModeloLogin ML = new ModeloLogin();
        //String a = ML.idiomas+".properties";
        String a = idioma+".properties";
        getProperties(a);
    }

    private void getProperties(String idioma) {
        try {
            //JOptionPane.showMessageDialog(null, getClass().getResourceAsStream(idioma));
            String userDir = System.getProperty("user.dir");
            String ruta = userDir + "\\src\\Idiomas\\" + idioma;
            //this.load( getClass().getResourceAsStream(idioma));
            this.load(new FileReader(ruta));
            //JOptionPane.showMessageDialog(null, this.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
   }
}
