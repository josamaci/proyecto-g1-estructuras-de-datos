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
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            newNode.setNext(header);
            header.setPrevious(newNode);
            this.setHeader(newNode);
            return true;
        }
        return false;
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            newNode.setPrevious(last);
            last.setNext(newNode);
            this.setLast(newNode);
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
        if(!isEmpty()){
        for (DoublyNodeList n = header; n != last; n = n.getNext()) {
            size++;
        }
        size++;
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
        if(index>=0 && !isEmpty()){
                for (DoublyNodeList n = header; n != last; n = n.getNext()) {
                    if(cont == index){
                        //e = n.getContent();
                    }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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