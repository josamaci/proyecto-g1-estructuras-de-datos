package Matrix;

import java.util.PriorityQueue;
import java.util.Queue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class StyleManager {
    
    public static String selectedWord = "";
    public static Queue<String> selectedLabel = new PriorityQueue<>();
       
    public static void styleLabel(Label l) {
        l.setPrefSize(60, 60);
        l.setMaxSize(60, 60);
        l.setAlignment(Pos.CENTER);
    }

    
    
}
