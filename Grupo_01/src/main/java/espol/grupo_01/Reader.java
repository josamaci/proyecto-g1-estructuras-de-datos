package espol.grupo_01;
import TDAs.DoublyLinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class Reader {
    public static boolean language = true;
    public static String category = "Fruits.txt";
    public static boolean difficulty = true;
    public static int size = 7;
    public static int cont = 90;
    
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
            while(numWords>0){
                for(String s:words){
                    double r = Math.random();
                    if(r>0.85 && numWords>0){
                        random.add(s);
                        numWords--;
                    }
                }
            }
        return random;
    }
}