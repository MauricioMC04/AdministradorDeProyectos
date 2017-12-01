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

    @FXML
    private Button Guardar;
    @FXML
    private TextField Nombreidioma;
    @FXML
    private TextField ingreso;
    @FXML
    private TextField contra;
   public static String Idioma="";
    @FXML
    private TextField NoImplementada;
    @FXML
    private TextField Nombre;
    @FXML
    private TextField Implementada;
    @FXML
    private TextField SupervisadorPor;
    @FXML
    private TextField FechaEntrega;
    @FXML
    private TextField EmpleadosDisponibles;
    @FXML
    private TextField Iteraciones;
    @FXML
    private TextField Actualizar;
    @FXML
    private TextField TareasDisponibles;
    @FXML
    private TextField Estados;
    @FXML
    private TextField Enproceso;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
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
