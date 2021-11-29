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
public class SettingCategoryController implements Initializable {

    @FXML
    private Button btBackToBS;
    @FXML
    private ToggleButton btCategoryAnimal;
    @FXML
    private ToggleGroup btGroupBoardSize;
    @FXML
    private ToggleButton btCateogrySports;
    @FXML
    private ToggleGroup btGroupCategory;
    @FXML
    private ToggleButton btCategoryFruits;
    @FXML
    private ToggleGroup btGroupBoardSize1;
    @FXML
    private Button btNextSetting2;
    @FXML
    private Pane pCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btCategoryAnimal.setDisable(false);
    }

    @FXML
    private void switchToBoardSize(ActionEvent event) throws IOException {
        App.setRoot("SettingBoardSize");
    }

    @FXML
    private void switchToGameMode(ActionEvent event) throws IOException {
        App.setRoot("SettingGameMode");
    }

}
