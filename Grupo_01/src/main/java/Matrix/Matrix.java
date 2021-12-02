package Matrix;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Matrix {
    
    GridPane gridPane;
    Button [][] array;
    int size;

    public Matrix(int size) {
        array = new Button[size][size];
        this.size = size;
        gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: WHITE");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button l = new Button();
                LabelManager.styleLabel(l);
                array[i][j] = l;
                gridPane.add(l, j, i);
            }
        }
    }
    
    public void updatePane() {
        gridPane.getChildren().clear();
        gridPane.setStyle("-fx-background-color: WHITE");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                Button l = array[i][j];
                LabelManager.styleLabel(l);
                gridPane.add(l, j, i);
            }
        }
        gridPane.setGridLinesVisible(true);
    }
    
    public void moveLeft(int row) {
        String first = array[row][0].getText();
        for (int i = 0; i < size - 1; i++) {
            array[row][i].setText(array[row][i + 1].getText());
        }
        array[row][size-1].setText(first);
    }
    
    /*
        Arreglar, implementarlo bien
    */
    
    public void moveRight(int row) {
        
        String last = array[row][size-1].getText();
        
        String s = "";
        
        int counter = 0;        
        for (int i = size-2; i >= 0; i--) {
            s = array[row][i].getText();
            
            if (counter <= size) {
                array[row][size -1-counter].setText(s);
            }
            counter++;
        }
        
        array[row][0].setText(last);
    }
    
    public void horizontal(String s, int row) {

        String word = "";

        if (s.length() <= size) {
            for (int i = 0; i < s.length(); i++) {
                if (array[row][i].getText().isEmpty()) {
                    word = Character.toString(s.charAt(i));
                    array[row][i].setText(word);
                }
            }
        }
        else if (s.length() > size) {
            String primeraParte = s.substring(0, size);
            String segundaParte = s.substring(size);

            for (int i = 0; i < primeraParte.length(); i++) {
                if (array[row][i].getText().isEmpty()) {
                    word = Character.toString(primeraParte.charAt(i));
                    array[row][i].setText(word);
                }
            }
        }
    }
    
    public void horizontal(String s, int row, int column) {

        String word = "";

        if (column + s.length() <= size) {
            int counter = 0;
            
            for (int i = column; i < size; i++) {
                if (array[row][i].getText().isEmpty()) {
                    if (counter < s.length()) {
                        word = Character.toString(s.charAt(counter));
                        array[row][i].setText(word);
                        counter++;
                    }
                }
            }
            
        }
        else if (column + s.length() > size) {
            String primeraParte = s.substring(0, size-column);
            String segundaParte = s.substring(size-column);
            int counter = 0;
            
            for (int i = column; i < size; i++) {
                if (array[row][i].getText().isEmpty()) {
                    if (counter < s.length()) {
                        word = Character.toString(s.charAt(counter));
                        array[row][i].setText(word);
                        counter++;
                    }
                }
            }
        }
    }
    
    public void vertical(String s, int column) {

//        Recorro las filas
        String word = "";

        if (s.length() <= size) {
            for (int i = 0; i < s.length(); i++) {
                if (array[i][column].getText().isEmpty()) {
                    word = Character.toString(s.charAt(i));
                    array[i][column].setText(word);
                }
            }
        } 
        else if (s.length() > size) {
            String primeraParte = s.substring(0, size);
            String segundaParte = s.substring(size);
            
            for (int i = 0; i < primeraParte.length(); i++) {
                if (array[i][column].getText().isEmpty()) {
                    word = Character.toString(primeraParte.charAt(i));
                    array[i][column].setText(word);
                }
            }
        }
    }
    
    public void vertical(String s, int row, int column) {

//        Recorro las filas
        String word = "";

        if (row + s.length() <= size) {
            int counter = 0;
            
            for (int i = row; i < size; i++) {
                if (array[i][column].getText().isEmpty()) {
                    if (counter < s.length()) {
                        word = Character.toString(s.charAt(counter));
                        array[i][column].setText(word);
                        counter++;
                    }
                }
            }
        }
        else if (row + s.length() > size) {
            String primeraParte = s.substring(0, size-row);
            String segundaParte = s.substring(size-row);
            int counter = 0;
            
            for (int i = row; i < size; i++) {
                if (array[i][column].getText().isEmpty()) {
                    if (counter < s.length()) {
                        word = Character.toString(primeraParte.charAt(counter));
                        array[i][column].setText(word);
                        counter++;
                    }
                }
            }
        }
    }
    
    public void downLeft(String s, int row, int column) {
        
//        Recorro las filas
        String word = "";

        if (s.length() <= size) {
            if (row + s.length() < size && column + s.length() < size) {
                for (int i = 0; i < s.length(); i++) {
                    if (array[row + i][column + i].getText().isEmpty()) {
                        word = Character.toString(s.charAt(i));
                        array[row + i][column + i].setText(word);
                    }
                }
            }
        }
        else if (s.length() > size) {
            String primeraParte = s.substring(0, size-row-column);
            String segundaParte = s.substring(size-row-column);
            
            if (row + primeraParte.length() < size && column + primeraParte.length() < size) {
                for (int i = 0; i < primeraParte.length(); i++) {
                    if (array[row+i][column+i].getText().isEmpty()) {
                        word = Character.toString(primeraParte.charAt(i));
                        array[row+i][column+i].setText(word);
                    }
                }
            }
        }
    }
    
    public GridPane getGridPane() {
        return gridPane;
    }
    
}
