package espol.grupo_01;
import TDAs.DoublyLinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
public class Reader {
    public static boolean language = true;
    public static String category = "Fruits.txt";
    public static boolean difficulty = false;
//    public static int size = 7;
    public static int size = 11;
    public static int cont = 120;
    public static int punt = 0;
    public static int life = 3;
    public static Set<String> random;
    
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