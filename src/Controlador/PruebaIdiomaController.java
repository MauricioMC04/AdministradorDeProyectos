
package Controlador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import propiedades.Idioma;

public class PruebaIdiomaController implements Initializable {

    @FXML
    public Button Adios;
    @FXML
    private Button Hola;
    @FXML
    private Label Cambio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void Adios (ActionEvent event) throws IOException {
      cambiarIdioma("Español");
    }
    
    public void cambiarIdioma(String nombreIdioma){
        
        Idioma idioma=new Idioma(nombreIdioma);
        
       Adios.setText(idioma.getProperty("kkkrrr"));
        String idiomas[]={
                          idioma.getProperty("espanol"),
                          idioma.getProperty("ingles"),
                          idioma.getProperty("frances")
                          };      
    }
    
   

    @FXML
    private void Hola(ActionEvent event) {
    }
    
}
