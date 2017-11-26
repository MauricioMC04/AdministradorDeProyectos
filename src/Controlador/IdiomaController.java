/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IdiomaController implements Initializable {

    @FXML
    private TextField Idioma;
    @FXML
    private Label Hola;
    @FXML
    private Button Ok;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ok(ActionEvent event) throws FileNotFoundException, IOException {
        
        String ruta = "C:\\Users\\Luis\\Desktop\\Nueva carpeta\\Proyecto Final\\AdministradorDeProyectos\\src\\PROPERTIES\\"+Idioma.getText()+".properties";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
            // El fichero ya existe
        } else {
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("Acabo de crear el fichero de texto.");
        }
    }

}
