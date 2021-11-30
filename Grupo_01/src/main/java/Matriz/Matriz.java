package Matriz;

import CircularList.CircularLinkedList;
import CircularList.CircularList;
import java.util.Random;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;


public class Matriz {
    
    protected CircularList<Fila> listaDeListas = new CircularLinkedList<>();
    
    protected int dimensiones = 5;
    
    protected String alfabeto = "ABCDEFGHIJKMNLOPQRSTUVWXYZ";
    
    static Random randomizador = new Random();
    
    protected FlowPane panelMatriz = new FlowPane();

    public Matriz(int dimensiones) {
        
        this.dimensiones = dimensiones;
        
        arreglandoPanel();
        
        for (int i = 0; i < this.dimensiones; i++) {
            
            Fila fila = new Fila(stringAleatorio(dimensiones));
            
            listaDeListas.addLast(fila);
            
            panelMatriz.getChildren().add(fila.getPanel());
        }
        
    }
    
    public void arreglandoPanel() {
    
        panelMatriz.setPrefSize(360, 360);
        panelMatriz.setOrientation(Orientation.VERTICAL);
        panelMatriz.setAlignment(Pos.CENTER);
        panelMatriz.setStyle("-fx-background-color: BLUE");
    
    }
    
    public String stringAleatorio(int tamano) {
        
        String resultado = "";
        
        for (int i = 0; i < tamano; i++) {
            
            int numero = randomizador.nextInt(alfabeto.length());
            resultado += Character.toString(alfabeto.charAt(numero));
        }
        
        return resultado;
    }
    
    public boolean ponerPalabraEnLista(String palabra) {
        
        int numeroAleatorio = randomizador.nextInt(dimensiones);

        switch (setOrientacionPalabra(palabra)) {
            case 1:
                ponerHorizontal(numeroAleatorio, palabra);
                break;
            case 2:
                ponerVertical(numeroAleatorio, palabra);
                break;
//            case 3:
//                ponerDiagona();
//                break;
        }
        
        return true;
    }
    
    protected boolean ponerHorizontal(int numeroFila,String palabra) {
        
        Fila f = listaDeListas.get(numeroFila);
        
        CircularList fLista = f.getLista();
        
        int contadorPalabra = 0;
        
        if (f != null) {
            
            String filaEnString = f.getContenido();
            
            if (palabra.length() == dimensiones) {
                f.setContenido(palabra);
            }
            
            // La palabra es mas pequeña que las dimensiones de la Mariz
            
            else {
                
                // Si la palabra se pone en posición y se pude añadir en ese lugar
                // Se añade a esa posición
                
                while (contadorPalabra < palabra.length()-1) {
                    
                    int posicion = randomizador.nextInt(dimensiones);
                    
                    if (posicion + palabra.length() <= dimensiones) {
                        
                        for (int i = 0; i < dimensiones; i++) {
                            
                            if (i >= posicion) {
                                
                                if (contadorPalabra < palabra.length()) {
                                    
                                    fLista.setAt(i, palabra.charAt(contadorPalabra));
                                    contadorPalabra++;
                                    
                                }
                            }
                            
                        }
                        
//                        for (char c : filaEnString.toCharArray()) {
//
//                            if (filaEnString.indexOf(c) >= posicion) {
//
//                                if (contadorPalabra < palabra.length()) {
////                                    c = palabra.charAt(contadorPalabra);
////                                    filaEnString = filaEnString.replace(c, palabra.charAt(contadorPalabra));
//                                    filaEnString = filaEnString.replaceFirst(Character.toString(c), Character.toString(palabra.charAt(contadorPalabra)));
//                                    contadorPalabra++;
//                                }
//                               
//                            }
//                        }
                    }
                }
            }
            
            f.setContenido(fLista);
            return true;
        }
        return false;
    }
       
    protected boolean ponerVertical(int numeroColumna,String palabra) {
        
        int contadorPalabra = 0;
        
        for (Fila fila : listaDeListas) {
            
            String p = fila.getContenido();
            
            for (int i = 0; i < dimensiones; i++) {
                
                if (i == numeroColumna) {

                    if (contadorPalabra < palabra.length()) {
                        fila.getLista().setAt(i, palabra.charAt(contadorPalabra));
                        fila.setContenido(fila.getLista());
                        contadorPalabra++;
                    }
                    
                }
                
            }
            
//            for (Character c : p.toCharArray()) {
//                if (contadorColumna == numeroColumna) {
//                    if (contadorPalabra < palabra.length()) {
//                        p = p.replace(c, palabra.charAt(contadorPalabra));
//                        // replace no siempre funciona hay que cambiar de estrategia
//                        fila.setContenido(p);
//                        contadorPalabra++;
//                        break;
//                    }
//                }
//
//                else if (contadorPalabra > palabra.length() - 1) {
//                    return true;
//                }
//                contadorColumna++;
//            }
        }
        return false;
    } 
    
    public int setOrientacionPalabra(String palabra) {
    
//        if (palabra.length() >= dimensiones) {
//            return 3;
//        }
//        if (palabra.length() <= dimensiones) {
//            if (randomizador.nextInt(10)%2 == 0) {
//                return 2;
//            }
//            return 1;
//        }
        
        return 1;
    }

    public CircularList<Fila> getListaDeListas() {
        return listaDeListas;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    public FlowPane getPanelMatriz() {
        return panelMatriz;
    }
    
}
