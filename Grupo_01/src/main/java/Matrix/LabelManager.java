package Matrix;

import espol.grupo_01.Reader;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class LabelManager {
    
    public static String selectedWord = "";
    public static Queue<String> selectedLabel = new PriorityQueue<>();
       
    public static void styleLabel(Label l) {
//        Label l = new Label(Randomer.getRdStr());
        l.setPrefSize(60, 60);
        l.setMaxSize(60, 60);
        l.setAlignment(Pos.CENTER);
        l.setStyle("-fx-background-color: WHITE; -fx-border-color: BLACK");
        
        l.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Node n = t.getPickResult().getIntersectedNode();
                if (n instanceof Label) {
                    Label l = (Label) n;
                    l.setStyle("-fx-background-color: LIGHTBLUE; -fx-border-color: BLACK");
                    selectedWord += l.getText();
                    System.out.println(selectedWord);
                }
                System.out.println(t.getPickResult().getIntersectedNode().getTypeSelector());
            }
        });
        l.setOnMousePressed((Event t) -> {
            
            l.setStyle("-fx-background-color: LIGHTBLUE; -fx-border-color: BLACK");
            
        });
    }
    
    public static boolean verifyWord() {
        
        for (String string : Reader.random) {
            if(string.compareTo(selectedWord) == 0) {
                return true;
            }
        }
        return false;
    }
    
}
