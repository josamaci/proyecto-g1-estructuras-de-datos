/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.grupo_01;

import espol.grupo_01.App;
import espol.grupo_01.Reader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class SettingsLanguageController implements Initializable {


    @FXML
    private BorderPane bpMenu;
    @FXML
    private Button btBack;
    @FXML
    private Button btSpanish;
    @FXML
    private Button btEnglish;
    @FXML
    private Label lbLS;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToMainMenu(ActionEvent event) throws IOException{
        App.setRoot("MainMenu");
    }

    @FXML
    private void switchToSpanish(ActionEvent event) {
        Reader.language = false;
        lbLS.setText("SELECCIONA LENGUAJE");
        btSpanish.setText("ESPAÑOL");
        btEnglish.setText("INGLÉS");
        btBack.setText("VOLVER");
    }

    @FXML
    private void switchToEnglish(ActionEvent event) {
        Reader.language = true;
        lbLS.setText("LANGUAGE SELECTION");
        btSpanish.setText("SPANISH");
        btEnglish.setText("ENGLISH");
        btBack.setText("BACK");
    }

}
