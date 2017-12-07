/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idiomas;

import Modelo.ModeloLogin;
import java.io.IOException;
import java.util.Properties;

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
        this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
        }
        int a =0;
   }
}
