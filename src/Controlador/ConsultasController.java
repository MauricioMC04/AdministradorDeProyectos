package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ConsultasController implements Initializable {

    MenuController menu = new MenuController();
    @FXML
    private MenuBar MbMenu;
    @FXML
    private MenuItem MPersonas;
    @FXML
    private MenuItem MbCerrarS;
    @FXML
    private MenuItem MProyectos;
    @FXML
    private MenuItem MbMisProyectos;
    @FXML
    private Menu MInavegar;
    @FXML
    private Menu MenuIsistema;
    @FXML
    private Menu MenuIpersonal;
    @FXML
    private MenuItem MPtareas;
    @FXML
    private MenuItem MPEdittar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (MenuController.Tipo == 3) {
            MPersonas.setDisable(true);
            MProyectos.setDisable(true);
            MPEdittar.setDisable(true);
            MPtareas.setDisable(true);
        }
    }

    @FXML
    private void Personas(ActionEvent event) {
    }

    @FXML
    private void Proyectos(ActionEvent event) {

        menu.Proyecto();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    private void Tareas(ActionEvent event) {
        menu.Insertar();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    private void EditProyectos(ActionEvent event) {
    }

    @FXML
    private void CerrarS(ActionEvent event) {
        menu.Login();
        Scene scene = MbMenu.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    @FXML
    private void ProyectosValidar(Event event) {

    }

    @FXML
    private void Irproyectos(ActionEvent event) {
    }
}
