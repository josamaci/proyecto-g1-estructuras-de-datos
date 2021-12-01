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
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

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
    @FXML
    private Label lbTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btNextSetting.setDisable(true);
        if (Reader.language) {
            btNextSetting.setText("Got it! Now what?");
            btBoardR.setText("Random!");
            lbTitle.setText("Board Size");
        } else {
            btNextSetting.setText("¡Entendido! ¿Ahora qué?");
            btBoardR.setText("Aleatorio");
            lbTitle.setText("Tamaño del Tablero");
        }
    }

    @FXML
    private void switchToCategory(ActionEvent event) throws IOException {
        App.setRoot("SettingCategory");
    }

    @FXML
    private void switchToMainMenu(ActionEvent event) throws IOException {
        App.setRoot("MainMenu");
    }

    @FXML
    private void value7(ActionEvent event) {
        if (!btBoard7.isSelected()) {
            btNextSetting.setDisable(true);
        } else {
            Reader.size = 7;
            btNextSetting.setDisable(false);
        }

    }

    @FXML
    private void value9(ActionEvent event) {
        if (!btBoard9.isSelected()) {
            btNextSetting.setDisable(true);
        } else {
            Reader.size = 9;
            btNextSetting.setDisable(false);
        }
    }

    @FXML
    private void value11(ActionEvent event) {
        if (!btBoard11.isSelected()) {
            btNextSetting.setDisable(true);
        } else {
            Reader.size = 11;
            btNextSetting.setDisable(false);
        }
    }

    @FXML
    private void value13(ActionEvent event) {
        if (!btBoard13.isSelected()) {
            btNextSetting.setDisable(true);
        } else {
            Reader.size = 13;
            btNextSetting.setDisable(false);
        }
    }

    @FXML
    private void valueR(ActionEvent event) {
        if (!btBoard7.isSelected()) {
            btNextSetting.setDisable(true);
        } else {
            Reader.size = Math.random() * (13 - 9) + 9;
            btNextSetting.setDisable(false);
        }
    }

}
