/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package espol.grupo_01;

import Matriz.Matriz;
import TDAs.DoublyLinkedList;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    private BorderPane bpPlayboard;
    @FXML
    private Button btSurrender;
    @FXML
    private Label lbPoints;
    @FXML
    private Label lbTime;
    @FXML
    private Label lblTime;

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
        if(!Reader.difficulty){
            ContadorTiempo ct = new ContadorTiempo();
            Thread t = new Thread(ct);
            t.setDaemon(true);
            t.start();
        }
        DoublyLinkedList<String> words = new DoublyLinkedList<>();
        if(Reader.category.equals("Aleatorio") || Reader.category.equals("Random")){
            DoublyLinkedList<String> cats = new DoublyLinkedList<>();
            if(Reader.category.equals("Aleatorio")){
                cats.addLast("Animales.txt");
                cats.addLast("Colores.txt");
                cats.addLast("Frutas.txt");
            }
            if(Reader.category.equals("Random")){
                cats.addLast("Animals.txt");
                cats.addLast("Colors.txt");
                cats.addLast("Fruits.txt");
            }
            words = Reader.ReadAll(cats);
        }else{
            words = Reader.Read(Reader.category);
        }
        
        Matriz matriz = new Matriz(SettingBoardSizeController.buttonValue);
        matriz.ponerPalabraEnLista("Hola");
        bpPlayboard.setCenter(matriz.getPanelMatriz());
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
    
    private class ContadorTiempo implements Runnable{
        @Override
        public void run(){
            try{
                while(Reader.cont>0){
                sleep(1000);
                Reader.cont--;
                Platform.runLater(()->{
                lblTime.setText(String.valueOf(Reader.cont));});
                }
            }catch(InterruptedException ex){
                ex.getMessage();
            }
            
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Credits.fxml"));
            Parent root = fxmlLoader.load();
            CreditsController cc = fxmlLoader.<CreditsController>getController();
            cc.setPoints(lblPoints.getText());
            App.setRoot("Credits");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
        }
    }
}
