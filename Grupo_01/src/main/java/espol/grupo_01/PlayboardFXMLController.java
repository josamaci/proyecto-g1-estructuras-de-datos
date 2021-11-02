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
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author JMaci
 */
public class PlayboardFXMLController implements Initializable {

    @FXML
    private Label lblPoints;
    @FXML
    private Circle health1;
    @FXML
    private Circle health2;
    @FXML
    private Circle health3;
    @FXML
    private Button btAdd1;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void backToTitle(MouseEvent event) {
        try{
        App.setRoot("MainMenuFXML");}
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void AddRow(MouseEvent event) {
        gBoard.addRow(gBoard.getRowCount());
    }

    @FXML
    private void AddColumn(MouseEvent event) {
        gBoard.addColumn(gBoard.getColumnCount());
    }

    @FXML
    private void DeleteRow(MouseEvent event) {
        gBoard.getChildren().remove(gBoard.getRowCount()-1);
    }

    @FXML
    private void DeleteColumn(MouseEvent event) {
        gBoard.getChildren().remove(gBoard.getColumnCount()-1);
    }
    
}
