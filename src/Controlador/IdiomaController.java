package Controlador;
import Idiomas.Idiomas;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IdiomaController implements Initializable {

    private Button Guardar;
    private TextField Nombreidioma;
    private TextField ingreso;
    private TextField contra;
   public static String Idioma="";
    private TextField NoImplementada;
    private TextField Nombre;
    private TextField Implementada;
    private TextField SupervisadorPor;
    private TextField FechaEntrega;
    private TextField EmpleadosDisponibles;
    private TextField Iteraciones;
    private TextField Actualizar;
    private TextField TareasDisponibles;
    private TextField Estados;
    private TextField Enproceso;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    private void Guardar(ActionEvent event) throws IOException {
       String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
      String ruta = userDir+"\\src\\Idiomas\\"+Nombreidioma.getText()+".properties";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
        int a =0;
        } else {
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("Ingreso="+ingreso.getText());
        bw.newLine();
        bw.write("Contra="+contra.getText());
        bw.newLine();
        bw.write("NoImplementada="+NoImplementada.getText()); 
        bw.newLine();
        bw.write("Nombre="+Nombre.getText());
        bw.newLine();
        bw.write("Implementada="+Implementada.getText()); 
        bw.newLine();
        bw.write("SupervisadorPor="+SupervisadorPor.getText()); 
        bw.newLine();
        bw.write("Iteraciones="+Iteraciones.getText()); 
        bw.newLine();
        bw.write("FechaEntrega="+FechaEntrega.getText());
        bw.newLine();
        bw.write("EmpleadosDisponibles="+EmpleadosDisponibles.getText()); 
        bw.newLine();
        bw.write("Actualizar="+Actualizar.getText()); 
        bw.newLine();
        bw.write("TareasDisponibles="+TareasDisponibles.getText()); 
        bw.newLine();
        bw.write("Estados="+Estados.getText());
        bw.newLine();
        bw.write("Enproceso="+Enproceso.getText());
        
        bw.close();
        }  
        
        MenuController menu = new MenuController();
        menu.Login();
        Stage stage = (Stage) Guardar.getScene().getWindow();
        stage.close(); 
        Idioma = Nombreidioma.getText();
    }
    
        public void cambiarIdioma(String nombreIdioma){
        Idiomas idioma=new Idiomas(nombreIdioma);
        LoginControador login = new LoginControador();
        String idiomas[]={
                          idioma.getProperty("espanol"),
                          idioma.getProperty("ingles"),
                          idioma.getProperty("frances")
                          };      
    }
    
}
