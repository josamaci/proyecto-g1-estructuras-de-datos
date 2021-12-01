package Matrix;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class LabelManager {
    
    public static Label styleLabel() {
//        Label l = new Label(Randomer.getRdStr());
        Label l = new Label();
        l.setPrefSize(60, 60);
        l.setMaxSize(60, 60);
        l.setAlignment(Pos.CENTER);
        
        l.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Node n = t.getPickResult().getIntersectedNode();
                
                if (n instanceof Label) {
                    Label l = (Label) n;
                    System.out.println(l.getText());
                    l.setStyle("-fx-background-color: LIGHTBLUE");
                }
                System.out.println(t.getPickResult().getIntersectedNode().getTypeSelector());                                
            }
        });
        
        return l;
    }

    public static void styleLabel(Label l) {
//        Label l = new Label(Randomer.getRdStr());
        l.setPrefSize(60, 60);
        l.setMaxSize(60, 60);
        l.setAlignment(Pos.CENTER);
    }

    public static Label styleLabel(String text) {
        Label l = new Label(text);
        l.setPrefSize(60, 60);
        l.setMaxSize(60, 60);
        l.setAlignment(Pos.CENTER);
        return l;
    }
    
}
