package espol.grupo_01;

import Matrix.Matrix;
import Matrix.Posicion;
import Matrix.Randomer;
import TDAs.DoublyLinkedList;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

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
    private Label lbWord1;
    @FXML
    private Pane matrixPane;
    @FXML
    private HBox hbWords;
    private int click;
    @FXML
    private Button btMoveRight;
    @FXML
    private Button btMoveLeft;
    @FXML
    private ComboBox<Integer> cbRows;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btMoveRight.setDisable(true);
        btMoveLeft.setDisable(true);
        click = 0;
        Reader.setMap(new HashMap<Label, Posicion>());
        Matrix matriz = new Matrix(Reader.getSize());
        moveRow(matriz);
        AddRowColumn(matriz);
        bpPlayboard.setCenter(matriz.getGridPane());
        lblTime.setText(String.valueOf(Reader.getCont()));
        lblPoints.setText(String.valueOf(Reader.getPunt()));
        setLanguage();
        setDifficulty();
        generate();
        putWords(matriz);
        setWords();
        matriz.updateWords();
        iniciarContadorVidas();
        setComboBox();
    }    

    public void AddRowColumn(Matrix m) {
        
        btAddRow.setOnMouseClicked(eh -> {
            if (click < 1) {
                click++;
                m.addRow();
            } else {
                btAddRow.setDisable(true);
                btAddColumn.setDisable(true);
                btDeleteRow.setDisable(true);
                btDeleteColumn.setDisable(true);
            }
        });
        btAddColumn.setOnMouseClicked(eh -> {
            if (click < 1) {
                click++;
                m.addColumn();
            } else {
                btAddRow.setDisable(true);
                btAddColumn.setDisable(true);
                btDeleteRow.setDisable(true);
                btDeleteColumn.setDisable(true);
            }
        });
        
        btDeleteRow.setOnMouseClicked(eh -> {
            if (click < 1) {
                click++;
            } else {
                btAddRow.setDisable(true);
                btAddColumn.setDisable(true);
                btDeleteRow.setDisable(true);
                btDeleteColumn.setDisable(true);
            }
        });
        
        btDeleteColumn.setOnMouseClicked(eh -> {
            if (click < 1) {
                click++;
            } else {
                btAddRow.setDisable(true);
                btAddColumn.setDisable(true);
                btDeleteRow.setDisable(true);
                btDeleteColumn.setDisable(true);
            }
        });
    }
        
    @FXML
    private void surrender(ActionEvent event) throws IOException {
        Reader.setCont(1);
        bpPlayboard.setCenter(null);
    }
    
    private void setLanguage(){
        if(Reader.getLanguage()){
            btAddColumn.setText("Add Column");
            btDeleteRow.setText("Delete Row");
            btAddRow.setText("Add Row");
            btDeleteColumn.setText("Delete Column");
            btSurrender.setText("Surrender");
            lbPoints.setText("Points:");
            lbTime.setText("Time to lose:");
        }
        else{
            btAddColumn.setText("+ Columna");
            btDeleteRow.setText("- Fila");
            btAddRow.setText("+ Fila");
            btDeleteColumn.setText("- Columna");
            btSurrender.setText("Rendirse");
            lbPoints.setText("Puntos:");
            lbTime.setText("Tiempo restante:");
        }
    }

    private void setDifficulty() {
        if(Reader.getDifficulty()){
            lbTime.setVisible(true);
            lblTime.setVisible(true);
            Reader.setCont(120);
            }else{
            Reader.setCont(100000000);
            lbTime.setVisible(false);
            lblTime.setVisible(false);
        }
        ContadorTiempo ct = new ContadorTiempo();
            Thread t = new Thread(ct);
            t.setDaemon(true);
            t.start();
    }
    private void setComboBox(){
        for(int i = 1; i <= Reader.getSize(); i++){
            cbRows.getItems().addAll(i);
        }
    }
    private void generate() {
        DoublyLinkedList<String> words = new DoublyLinkedList<>();
        Reader.setRandom(new TreeSet<>());
        if(!Reader.getCategory().equals("Numbers")){
            if(Reader.getCategory().equals("Aleatorio") || Reader.getCategory().equals("Random")){
                DoublyLinkedList<String> cats = new DoublyLinkedList<>();
                if(Reader.getCategory().equals("Aleatorio")){
                    cats.addFirst("Animales.txt");
                    cats.addFirst("Colores.txt");
                    cats.addFirst("Frutas.txt");
                }
                if(Reader.getCategory().equals("Random")){
                    cats.addFirst("Animals.txt");
                    cats.addFirst("Colors.txt");
                    cats.addFirst("Fruits.txt");
                }
                words = Reader.ReadAll(cats);
            }else{
                words = Reader.Read(Reader.getCategory());
            }
            
            switch(Reader.getSize()){
                case 7: Reader.setRandom(Reader.randomize(words, 3));
                    break;
                case 9: Reader.setRandom(Reader.randomize(words, 3));
                    break;
                case 11: Reader.setRandom(Reader.randomize(words, 4));
                    break;
                case 13: Reader.setRandom(Reader.randomize(words, 5));
                    break;
                default:
            }
            
            
        }else{
            switch(Reader.getSize()){
                case 7: Reader.setRandom(Reader.randomNumbers(5));
                    break;
                case 9: Reader.setRandom(Reader.randomNumbers(5));
                    break;
                case 11: Reader.setRandom(Reader.randomNumbers(5));
                    break;
                case 13: Reader.setRandom(Reader.randomNumbers(5));
                    break;
                default:
            }
        }
        
        for(String s: Reader.getRandom()){
                System.out.println(s);
            }
    }
    
    private void setWords() {
        for (String string : Reader.getRandom()) {
            Label l = new Label(string);
            l.setStyle("-fx-text-fill: WHITE");
            hbWords.getChildren().add(l);
        }
    }    
    
    private void putWords(Matrix matrix) {
        int count = 0;
//        int rdInt = Randomer.getRdint(3);
        int rdInt = Randomer.getRdint(2);
//        int rdInt = 1;
        for (String string : Reader.getRandom()) {
            count++;
            switch (rdInt) {
                case 0:
                    matrix.horizontal(string, Randomer.getRdint(matrix.getSize()-1) , Randomer.getRdint(matrix.getSize()-1));
                    break;
                case 1:
                    matrix.vertical(string, Randomer.getRdint(matrix.getSize()-1) , Randomer.getRdint(matrix.getSize()-1));
                    break;
//                case 2:
//                    matrix.downLeft(string, Randomer.getRdint(matrix.getSize()-1) , Randomer.getRdint(matrix.getSize()-1));
//                    break;
            }
        }
        
    }
    
    private void iniciarContadorVidas() {
        ContadorVidas cv = new ContadorVidas();
        Thread t = new Thread(cv);
        t.setDaemon(true);
        t.start();
    }
    
    public void moveRow(Matrix m) {
        btMoveRight.setOnMouseClicked(eh -> {
            m.moveRight(cbRows.getValue() - 1);
        });
        btMoveLeft.setOnMouseClicked(eh -> {
            m.moveLeft(cbRows.getValue() - 1);
        });
    }
   
    private class ContadorTiempo implements Runnable{
        @Override
        public void run(){
            try{
                while(Reader.getCont()>0){
                    if(cbRows.getValue()!=null){
                        btMoveRight.setDisable(false);
                        btMoveLeft.setDisable(false);
                    }
                sleep(1000);
                Reader.setCont(Reader.getCont()-1);
                Reader.setPunt(Reader.getPunt()+1);
                Platform.runLater(()->{
                lblTime.setText(String.valueOf(Reader.getCont()));
                lblPoints.setText(String.valueOf(Reader.getPunt()));});
                }
            }
            catch(InterruptedException ex){
                ex.getMessage();
            }
            
            try {
            App.setRoot("Credits");
            
            }
            catch (IOException ex) {
            ex.printStackTrace();
            }
            
        }
    }
    
    private class ContadorVidas implements Runnable {

        @Override
        public void run() {
            try {
                while (Reader.getLife() < 3) {
                    Platform.runLater(() -> {
                        switch (Reader.getLife()) {
                            case 2:
                                health1.setDisable(true);
                                break;
                            case 1:
                                health2.setDisable(true);
                                break;
                            case 0:
                                health3.setDisable(true);
                                Reader.setCont(0);
                                break;
                        }
                    });
                }
            }
            catch (Exception e) {
            }
        }
        
    }
}
