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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class PlayboardController implements Initializable {

    @FXML
    private Label lblPoints;
    @FXML
    private Circle health1;
    @FXML
    private Circle health2;
    @FXML
    private Circle health3;
    @FXML
    private Button btAddRow;
    @FXML
    private Button btAddColumn;
    @FXML
    private Button btDeleteRow;
    @FXML
    private Button btDeleteColumn;
    @FXML
    private Button btBacktoTitle;
    @FXML
    private GridPane gBoard;
    @FXML
    private BorderPane bpPlayboard;
    @FXML
    private Label lblPoints1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddRow(MouseEvent event) {
    }

    @FXML
    private void AddColumn(MouseEvent event) {
    }

    @FXML
    private void DeleteRow(MouseEvent event) {
    }

    @FXML
    private void DeleteColumn(MouseEvent event) {
    }

    @FXML
    private void backToTitle(ActionEvent event) throws IOException {
        App.setRoot("MainMenu");
    }
    
}
