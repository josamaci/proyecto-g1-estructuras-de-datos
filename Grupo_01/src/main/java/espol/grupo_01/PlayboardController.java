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
    private GridPane gBoard;
    @FXML
    private BorderPane bpPlayboard;
    @FXML
    private Label lblPoints1;
    @FXML
    private Button btSurrender;
    @FXML
    private Label lbPoints;
    @FXML
    private Label lbTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Reader.language){
            btAddColumn.setText("Add Column");
            btDeleteRow.setText("Delete Row");
            btAddRow.setText("Add Row");
            btDeleteColumn.setText("Delete Column");
            btSurrender.setText("Surrender");
            lbPoints.setText("Points:");
            lbTime.setText("Time to lose:");
        }else{
            btAddColumn.setText("+ Columna");
            btDeleteRow.setText("- Fila");
            btAddRow.setText("+ Fila");
            btDeleteColumn.setText("- Columna");
            btSurrender.setText("Rendirse");
            lbPoints.setText("Puntos:");
            lbTime.setText("Tiempo restante:");
        }
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
    private void surrender(ActionEvent event) throws IOException {
        App.setRoot("Credits");
    }
    
}
