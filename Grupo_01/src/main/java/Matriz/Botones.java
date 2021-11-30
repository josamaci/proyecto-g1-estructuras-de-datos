package Matriz;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class Botones {
    public static Button crearBoton(Fila f, String s) {

        Button b = new Button();
        b.setPrefSize(30, 30);
        b.setAlignment(Pos.CENTER);
        b.setText(s);

        if (s.equals("<")) {

            // Mover a la izq
            b.setOnMouseClicked((Event t) -> {

                f.retroceder();

//                if (p.getChildren().size() > 0) {
//                    Node node = p.getChildren().remove(0);
//                    p.getChildren().add(p.getChildren().size(), node);
//                }
            });

            return b;

        } else if (s.equals(">")) {

            // Mover a la Derecha
            b.setOnMouseClicked((Event t) -> {

                f.avanzar();

//                if (p.getChildren().size() > 0) {
//                    
//                    
//                    Node node = p.getChildren().remove(p.getChildren().size() - 1);
//                    p.getChildren().add(0, node);
//                }
            });

            return b;

        }

        return b;

    }
}
