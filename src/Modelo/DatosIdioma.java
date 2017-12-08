
package Modelo;

import Controlador.MenuController;
import Idiomas.Idiomas;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class DatosIdioma {
    
    /*
    Nombre de metodo: CargarIdiomas
    Parametros: Ninguno
    Retorno: ObservableList<String>
    Descripcion: Carga en el ObservableList los idiomas disponibles 
    */
    public ObservableList<String> CargarIdiomas(){
        ObservableList <String> idiomas = FXCollections.observableArrayList();
        String userDir = System.getProperty("user.dir");
        String Directorio = userDir+"\\src\\Idiomas";
        File f = new File(Directorio);
        if (f.exists()){
            File[] ficheros = f.listFiles();
            for (int i = 0; i < ficheros.length; i++){
                String nombre = ficheros[i].getName();
                if(!nombre.equals("Idiomas.java") && !nombre.equals("Espanol") && !nombre.equals("English")){
                    idiomas.add(nombre.substring(0, nombre.length() - 11));
                }
            }
        }        
        return idiomas;
    }
    
    /*
    Nombre de metodo: EliminarIdioma
    Parametros: Ninguno
    Retorno: Ninguno
    Descripcion: Elimina el idioma 
    */
    public void EliminarIdioma(String idioma){ 
        String userDir = System.getProperty("user.dir");
        String ruta = userDir + "\\src\\Idiomas\\" + idioma + ".properties";
        File fichero = new File(ruta);
        if(fichero.exists()){
            if(new Idiomas(idioma) == MenuController.idioma){
                MenuController.idioma = new Idiomas("Espanol");    
            }
            if (!fichero.delete()){
               JOptionPane.showMessageDialog(null, "Error al eliminar el idioma");
            }
        }
    }
}
