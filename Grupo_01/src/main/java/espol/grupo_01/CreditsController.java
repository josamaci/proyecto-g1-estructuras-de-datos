/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.grupo_01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class CreditsController implements Initializable {

    @FXML
    private Label lblWinLose;
    @FXML
    private Label lblPoints;
    @FXML
    private Button btMainMenu;
    @FXML
    private VBox vbCredits;
    @FXML
    private Label lbPoints;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Reader.getLanguage()){
            lblWinLose.setText("YOU LOSE");
            btMainMenu.setText("Main Menu");
            lbPoints.setText("Points: ");
        }else{
            lblWinLose.setText("¡HAS PERDIDO!");
            btMainMenu.setText("Menú principal");
            lbPoints.setText("Puntos: ");
        }
        lblPoints.setText(String.valueOf(Reader.getPunt()));
    }    

    @FXML
    private void backToTheTitle(ActionEvent event) throws IOException{
        Reader.setPunt(0);
        Reader.setCont(120);
        App.setRoot("MainMenu");
    }
    
}
