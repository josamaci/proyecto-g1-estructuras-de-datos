/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.grupo_01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToTheTitle(MouseEvent event) {
        try{
        App.setRoot("MainMenuFXML");}
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
