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
/**
 * FXML Controller class
 *
 * @author kevin
 */
public class SettingBoardSizeController implements Initializable {


    @FXML
    private ToggleGroup btGroupBoardSize;
    @FXML
    private Button btNextSetting;
    @FXML
    private Button btBackToTitle;
    @FXML
    private ToggleButton btBoard7;
    @FXML
    private ToggleButton btBoard9;
    @FXML
    private ToggleButton btBoard11;
    @FXML
    private ToggleButton btBoard13;
    @FXML
    private ToggleButton btBoardR;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void switchToCategory() throws IOException {
        App.setRoot("SettingCategory");
    }

    private void switchToBoardSize(ActionEvent event) throws IOException {
        App.setRoot("SettingBoardSize");
    }

    private void switchToPlayboard(ActionEvent event) throws IOException {
        App.setRoot("PlayboardFXML");
    }



}
