package Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdministradorDeProyectosFX extends Application {
    
    private Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        comparar();
        this.stagePrincipal = stagePrincipal;   
        mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(AdministradorDeProyectosFX.class.getResource("/Vista/Login.fxml"));
            rootPane = loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Login");
            stagePrincipal.setScene(scene);
            stagePrincipal.show();
        } catch (IOException e) {
        }
    }
    
    
     /**
  * @param args
  */
private void comparar(){
   
 String fecha1 = "29/10/2017";  
 
 Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        String fechaSistema=formateador.format(fechaActual);
 String resultadoMenor=compararFechasConDate(fecha1,fechaSistema);
 System.out.println(resultadoMenor+"\n");
   
 System.out.println("******************************" +
    "******************************\n");
 }

 private String compararFechasConDate(String fecha1, String fechaActual) {  
  System.out.println("Parametro String Fecha 1 = "+fecha1+"\n" +
    "Parametro String fechaActual = "+fechaActual+"\n");  
  String resultado="";
  try {
   /**Obtenemos las fechas enviadas en el formato a comparar*/
   SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
   Date fechaDate1 = formateador.parse(fecha1);
   Date fechaDate2 = formateador.parse(fechaActual);
    
   System.out.println("Parametro Date Fecha 1 = "+fechaDate1+"\n" +
     "Parametro Date fechaActual = "+fechaDate2+"\n");
    
    if ( fechaDate1.before(fechaDate2) ){
    resultado= "La Fecha 1 es menor ";
    }else{
     if ( fechaDate2.before(fechaDate1) ){
      resultado= "La Fecha 1 es Mayor ";
     }else{
      resultado= "Las Fechas Son iguales ";
     } 
    }
  } catch (ParseException e) {
   System.out.println("Se Produjo un Error!!!  "+e.getMessage());
  }  
  return resultado;
 
 }

    public void mostrarPersonas() {
        try {
            FXMLLoader loader = new FXMLLoader(AdministradorDeProyectosFX.class.getResource("/Vista/Personas_1.fxml"));
            rootPane = loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Personas");
            stagePrincipal.setScene(scene);
            PersonasController controller = loader.getController();
            stagePrincipal.show();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
