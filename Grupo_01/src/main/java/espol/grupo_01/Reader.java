package espol.grupo_01;
import TDAs.DoublyLinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Reader {
    public static DoublyLinkedList<String> Read(String nameFile, int numWords){
        DoublyLinkedList<String> words = new DoublyLinkedList<>();
        try(InputStream input = App.class.getResource(nameFile).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                if(words.size()<=numWords){
                        words.addLast(linea);
                }
            }         
        }  catch (IOException ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        return words;
    }
    
    public static DoublyLinkedList<String> ReadAll(DoublyLinkedList<String> nameFile, int numWords){
        DoublyLinkedList<String> words = new DoublyLinkedList<>();
        for(int i=0; i<nameFile.size(); i++){
        try(InputStream input = App.class.getResource(nameFile.get(i)).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                if(words.size()<=numWords){
                        words.addLast(linea);
                }
            }         
        }  catch (IOException ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        }
        return words;
    }
    
     
}
