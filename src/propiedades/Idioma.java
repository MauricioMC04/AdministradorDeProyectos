
package propiedades;

import Controlador.PruebaIdiomaController;
import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties{
    
    private static final long serialVersionUID = 1L;
	        
    public Idioma(String idioma){
    	switch(idioma){
	    	case "Español":
                    getProperties("Esp.properties");
                    break;
	    	case "Ingles":
                    getProperties("ingles.properties");
                    break;
                case "Frances":
                    getProperties("frances.properties");
                    break;
	    	default:
                    getProperties("espanol.properties");
	   	}

    }

    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
        
        }
        int a =0;
   }
}
