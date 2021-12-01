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
    private ToggleGroup btGroupCategory;
    @FXML
    private ToggleButton btCategoryFruit;
    @FXML
    private Button btNextSetting2;
    @FXML
    private Pane pCat;
    @FXML
    private Label lbTitle;
    @FXML
    private ToggleButton btCategoryColor;
    @FXML
    private ToggleButton btCategoryNumber;
    @FXML
    private ToggleButton btCategoryRandom;
    @FXML
    private ToggleGroup btGroupCategory1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btNextSetting2.setDisable(true);
        if (Reader.language) {
            btCategoryAnimal.setText("Animals");
            btCategoryColor.setText("Colors");
            btCategoryFruit.setText("Fruits");
            btCategoryNumber.setText("Numbers");
            btCategoryRandom.setText("Random");
            lbTitle.setText("Second, choose a category!");
            btNextSetting2.setText("OK! And then?");
        } else {
            btCategoryAnimal.setText("Animales");
            btCategoryColor.setText("Colores");
            btCategoryFruit.setText("Frutas");
            btCategoryNumber.setText("Números");
            btCategoryRandom.setText("Aleatorio");
            lbTitle.setText("Ahora, ¡escoge una categoría!");
            btNextSetting2.setText("Listo, ¿ahora qué?");
        }
    }

    @FXML
    private void switchToBoardSize(ActionEvent event) throws IOException {
        App.setRoot("SettingBoardSize");
    }

    @FXML
    private void switchToGameMode(ActionEvent event) throws IOException {
        App.setRoot("SettingGameMode");
    }

    @FXML
    private void catAnimals(ActionEvent event) {
        if (!btCategoryAnimal.isSelected()) {
            btNextSetting2.setDisable(true);
        } else {
            if (Reader.language) {
                Reader.category = "Animals.txt";
            } else {
                Reader.category = "Animales.txt";
            }
            btNextSetting2.setDisable(false);
        }
    }

    @FXML
    private void catColors(ActionEvent event) {
        if (!btCategoryColor.isSelected()) {
            btNextSetting2.setDisable(true);
        } else {
            if (Reader.language) {
                Reader.category = "Colors.txt";
            } else {
                Reader.category = "Colores.txt";
            }
            btNextSetting2.setDisable(false);
        }
    }

    @FXML
    private void catFruits(ActionEvent event) {
        if (!btCategoryFruit.isSelected()) {
            btNextSetting2.setDisable(true);
        } else {
            if (Reader.language) {
                Reader.category = "Fruits.txt";
            } else {
                Reader.category = "Frutas.txt";
            }
            btNextSetting2.setDisable(false);

        }
    }

    @FXML
    private void catNumbers(ActionEvent event) {
        if (!btCategoryNumber.isSelected()) {
            btNextSetting2.setDisable(true);
        } else {
            Reader.category = "Numbers";
            btNextSetting2.setDisable(false);
        }
    }

    @FXML
    private void catRandom(ActionEvent event) {
        if (!btCategoryRandom.isSelected()) {
            btNextSetting2.setDisable(true);
        } else {
            if (Reader.language) {
                Reader.category = "Random";
            } else {
                Reader.category = "Aleatorio";
            }
            btNextSetting2.setDisable(false);
        }
    }
}
