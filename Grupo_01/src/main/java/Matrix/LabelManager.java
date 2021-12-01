package Matrix;

import espol.grupo_01.Reader;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class LabelManager {
    
    public static String selectedWord = "";
    public static Queue<String> selectedLabel = new PriorityQueue<>();
       
    public static void styleLabel(Button l) {
//        Label l = new Label(Randomer.getRdStr());
        l.setPrefSize(60, 60);
        l.setMaxSize(60, 60);
        l.setAlignment(Pos.CENTER);
//        l.setStyle("-fx-background-color: WHITE; -fx-border-color: BLACK");
        
        l.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                
//                Node n = t.getPickResult().getIntersectedNode();
//                if (n instanceof Button) {
//                    Button l = (Button) n;
                  if (t.isDragDetect()) {
                      l.setStyle("-fx-background-color: LIGHTBLUE; -fx-border-color: BLACK");
                      selectedWord += l.getText();
                      System.out.println(selectedWord);
                      l.setDisable(true);
                    }

//                }
//                System.out.println(t.getPickResult().getIntersectedNode().getTypeSelector());
            }
        });
//        l.setOnMouseClicked((Event t) -> {
//            
//            
//            l.setDisable(true);
//            
//        });

//        l.addEventFilter(MouseEvent.MOUSE_DRAGGED, );

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
