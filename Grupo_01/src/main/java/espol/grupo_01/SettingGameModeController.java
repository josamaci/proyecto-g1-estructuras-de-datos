/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package espol.grupo_01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class SettingGameModeController implements Initializable {

    @FXML
    private Pane pSettings;
    @FXML
    private Button btBackToCat;
    @FXML
    private ToggleButton btNormalMode;
    @FXML
    private ToggleGroup btGroupGameMode;
    @FXML
    private ToggleButton btExtremeMode;
    @FXML
    private Button btPlayboard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btPlayboard.setDisable(false);
    }    

    @FXML
    private void switchToCategory(ActionEvent event) throws IOException{
        App.setRoot("SettingCategory");
    }

    @FXML
    private void switchToPlayboard(ActionEvent event) throws IOException{
        App.setRoot("Playboard");
    }

    
}
