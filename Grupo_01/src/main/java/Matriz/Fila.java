package Matriz;

import CircularList.CircularLinkedList;
import CircularList.CircularList;
import javafx.beans.property.ObjectProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.FlowPane;

public class Fila {

    protected String contenido;
    protected CircularList<Character> lista = new CircularLinkedList<>();
    protected FlowPane panel = crearFlowPane();
    
    public Fila() {
    
    }

    public String getContenido() {
        return contenido;
    }

    public CircularList<Character> getLista() {
        return lista;
    }

    public FlowPane getPanel() {
        return panel;
    }

    public Fila(String contenido) {
        
        this.contenido = contenido;
        llenarLista();
        actualizarPanel();
        
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
        llenarLista();
        actualizarPanel();
    }
    
    public void setContenido(CircularList lista) {
        this.lista = lista;
        llenarContenido();
        actualizarPanel();
    }

    public boolean llenarContenido() {
        
        if (!lista.isEmpty()) {
            
            String resultante = "";
            
            for (Character c : lista) {
                resultante += Character.toString(c);
            }
            
            contenido = resultante;
            
            if (lista.size() == contenido.length()) {
                return true;
            }
        }
        return false;
        
    }
    
    public boolean llenarLista() {
        if(!contenido.isEmpty()) {
            lista = new CircularLinkedList<>();
            
            for (Character c : contenido.toCharArray()) {
                lista.addLast(c);
            }
            if (lista.size() == contenido.length()) {
                return true;
            }
        }
        
        return false;
    
    }
    
    public boolean construirPanel() {
        
        if (!lista.isEmpty()) {
            
            panel.getChildren().clear();
            
            for (Character c : lista) {
                Label label = crearLabel(c);
                panel.getChildren().add(label);
            }
            return true;
        }
        return false;
    }
    
    public boolean actualizarPanel() {
            construirPanel();
            if (panel.getChildren().size() > 0) {
                return true;
            }
        return false;
    }
    
    public FlowPane crearFlowPane() {

        FlowPane fp = new FlowPane();
        fp.setOrientation(Orientation.HORIZONTAL);
        fp.setAlignment(Pos.CENTER);
        /* Horizontal */
        fp.setPrefSize(360, 35); 
//        /* Vertical */
//        fp.setPrefSize(40, 360);
        fp.setStyle("-fx-border-color: RED");
        return fp;
    
    }
    
    public Label crearLabel(Character c) {
        
        Label l = new Label(Character.toString(c));
        l.setPrefSize(35, 35);
//        l.setDisable(true);
        l.setOnMouseEntered((Event t) -> {
            l.setStyle("-fx-background-color: LIGHTBLUE");
        });
        l.setOnMouseExited((Event t) -> {
            l.setStyle("-fx-background-color: WHITE");
        });
        l.setAlignment(Pos.CENTER);
        l.setStyle("-fx-background-color: WHITE");
        
        return l;
    
    }
    /* mover a la Izq Horizontal */
    /* mover arriba Vertical */
    public boolean retroceder() {
        String resultado;
        resultado = contenido.substring(1, contenido.length()) + contenido.charAt(0);
        if (resultado.length() == contenido.length()) {
            this.setContenido(resultado);
            return true;
        }
        return false;
    }
    
    /* mover a la Der Horizontal */
    /* mover abajo Vertical */
    
    public boolean avanzar() {
        String resultado;
        resultado = contenido.charAt(contenido.length() - 1) + contenido.substring(0, contenido.length() - 1);
        if (resultado.length() == contenido.length()) {
            this.setContenido(resultado);
            return true;
        }
        return false;
    }
}
