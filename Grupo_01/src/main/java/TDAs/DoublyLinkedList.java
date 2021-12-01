package TDAs;

import java.util.Comparator;
import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {
    
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;
    
    public DoublyLinkedList() {
        this.header = null;
        this.last = null;
    }

    public DoublyNodeList<E> getHeader() {
        return header;
    }

    public void setHeader(DoublyNodeList<E> header) {
        this.header = header;
    }

    public DoublyNodeList<E> getLast() {
        return last;
    }

    public void setLast(DoublyNodeList<E> last) {
        this.last = last;
    }
    
    private void recorrerHaciaAtras() {
        DoublyNodeList<E> n;
        for (n = last; n != header; n = n.getPrevious()) {
            
        }
    }

    @Override
    public boolean addFirst(E e) {
        if (e != null) {
            DoublyNodeList<E> h = header;
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            newNode.setNext(header);
            this.setHeader(newNode);
            header = newNode;
            if (h != null){
                h.setPrevious(newNode);
                if(last==null){
                last = h;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            if(header!=null){
                DoublyNodeList<E> l = last;
                DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
                newNode.setPrevious(last);
                this.setLast(newNode);
                last = newNode;
                if (l != null){
                    l.setNext(newNode);
                }
            }
            else{
                    addFirst(e);
            }
            return true;
        }
        return false;
    }
    
    public boolean addAt(E e, int pos) {
        if (e != null && pos >= 0 && pos < this.size()) {
            
            // Creando a P
            DoublyNodeList<E> p = header;
            // Encontrando a P
            for (int i = 0; i < pos; i++) {
                p = p.getNext();
            }
            
            // Creando el nuevo nodo
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            
            newNode.setNext(p.getNext());
            p.getNext().setPrevious(newNode);
            newNode.setPrevious(p);
            p.setNext(newNode);
            // O tambien newNode.getNext().setPrevious(newNode);
        }
        return false;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        int size = 0;
        DoublyNodeList<E> n;
        if(!isEmpty()){
            for (n = header; n!=null; n = n.getNext()) {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return header == null && last == null;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public E removeElement (int index) {
        DoublyNodeList<E> p = header;
        
        // Lo movemos tantas veces como nos dicen
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        
        // el anterior de P va a ser el siguiente al siguiente de p
        p.getPrevious().setNext(p.getNext());
        
        // el siguiente de P va a tener como anterior al anterior de p
        p.getNext().setPrevious(p.getPrevious());
        
        p.setNext(null);
        p.setPrevious(null);
        
        // retorna el contenido del elemento eliminando        
        return p.getContent();
    }
    
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        E e=null;
        int cont = 0;
        DoublyNodeList n = header;
        if(index>=0 && index<size() && !isEmpty()){
                while(cont<=index) {
                    if(cont == index){
                        e = (E)n.getContent();
                    }
                    n = n.getNext();
                    cont++;
                }
        
        }
        return e;
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){
            protected DoublyNodeList<E> cursor = header; 
            @Override
            public boolean hasNext() {
                return cursor.getNext()!=null;
            }
            @Override
            public E next(){
                E content = null;
                if(hasNext()){
                    content = cursor.getContent();
                    cursor = cursor.getNext();
                }
                return content;
            }
        };
    return it; 
    }


    @Override
    public List<E> findAll(Comparator<E> cmp, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(E t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}