package espol.grupo_01;
import TDAs.DoublyLinkedList;
import Matrix.Posicion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.control.Label;
public class Reader {
    private static boolean language = true;
    private static String category = "Fruits.txt";
    private static boolean difficulty = false;
    private static int size = 7;
    private static int cont = 120;
    private static int punt = 0;
    private static int life = 4;
    private static Set<String> random;
    private static Map<Label, Posicion> map;
    public static boolean getLanguage() {
        return language;
    }

    public static void setLanguage(boolean language) {
        Reader.language = language;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        Reader.category = category;
    }

    public static boolean getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(boolean difficulty) {
        Reader.difficulty = difficulty;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Reader.size = size;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Reader.cont = cont;
    }

    public static int getPunt() {
        return punt;
    }

    public static void setPunt(int punt) {
        Reader.punt = punt;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        Reader.life = life;
    }

    public static Set<String> getRandom() {
        return random;
    }

    public static void setRandom(Set<String> random) {
        Reader.random = random;
    }

    public static Map<Label, Posicion> getMap() {
        return map;
    }

    public static void setMap(Map<Label, Posicion> map) {
        Reader.map = map;
    }
    
    public static DoublyLinkedList<String> Read(String nameFile){
        DoublyLinkedList<String> words = new DoublyLinkedList<>();
        try(InputStream input = App.class.getResource(nameFile).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){   
                        words.addFirst(linea);
            }         
        }  catch (IOException ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        return words;
    }
    
    public static DoublyLinkedList<String> ReadAll(DoublyLinkedList<String> namesFiles){
        DoublyLinkedList<String> words = new DoublyLinkedList<>();
        for(int i=0; i<namesFiles.size(); i++){
        try(InputStream input = App.class.getResource(namesFiles.get(i)).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                        words.addFirst(linea);
            }         
        }  catch (IOException ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        }
        return words;
    }
    
    public static Set<String> randomize(DoublyLinkedList<String> words, int numWords){
        Set<String> random = new TreeSet<>();
        
        for (int i = 0; i < numWords; i++) {
            for (String s : words) {
                double r = Math.random();
                if (r > 0.85 && random.size() < numWords) {
                    random.add(s);
                }
            }
        }
 
        return random;
    }
    
    public static Set<String> randomNumbers(int numNumbers){
        Set<String> random = new TreeSet<>();
        Random rm = new Random();
            while(numNumbers>0){
                int val = rm.nextInt(1000000)+1000;
                    random.add(String.valueOf(val));
                    numNumbers--;
            }
        return random;
    }
}