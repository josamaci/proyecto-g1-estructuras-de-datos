package CircularList;

import java.util.Comparator;
import java.util.Iterator;

public class CircularLinkedList<E> implements CircularList<E> {

    private CircularNodeList<E> last = new CircularNodeList<>();

    // Constructor    
    public CircularLinkedList() {
        
    }
    
    public void setLast(CircularNodeList<E> last) {
        this.last = last;
    }
    
    public CircularNodeList<E> getLast() {
        return last;
    }

    public CircularNodeList<E> getHeader() {
        return last.getNext();
    }
    
    @Override
    public int size() {
        int size = 0;
        
        if (!this.isEmpty()) {
            size++;
            CircularNodeList<E> i;
            for (i = last.getNext(); i != this.last; i = i.getNext()) {
                size++;
            }
        }
        
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return last.getContent() == null;
    }

    @Override
    public boolean addFirst(E e) {
        if (e != null) {
            CircularNodeList<E> newNode = new CircularNodeList<E>(e);

            if (!this.isEmpty()) {
                
                CircularNodeList<E> header = last.getNext();
                last.setNext(newNode);
                newNode.setNext(header);
                header.setPrevious(newNode);
                newNode.setPrevious(last);

                return true;
            }
            
            else {
                last = newNode;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            CircularNodeList<E> newNode = new CircularNodeList<E>(e);

            if (!this.isEmpty()) {

                CircularNodeList<E> header = last.getNext();
                last.setNext(newNode);
                newNode.setNext(header);
                header.setPrevious(newNode);
                newNode.setPrevious(last);

                // La unica diferencia con el addFirst
                this.setLast(newNode);

                return true;
            } else {
                last = newNode;
                return true;
            }
        }
        return false;
    }

    @Override
    public E removeFirst() {

        if (!this.isEmpty()) {
            
            CircularNodeList<E> header = last.getNext();
            
            // Primero conecto el ultimo con el segundo primero
            last.setNext(header.getNext());
            header.getNext().setPrevious(last);
            
            // Despues desconecto al primer Nodo de la lista
            header.setNext(header);
            header.setPrevious(header);
            
            return header.getContent();
        }
        return null;
    }

    @Override
    public E removeLast() {
        CircularNodeList<E> header = last.getNext();
        CircularNodeList<E> newLast = last.getPrevious();
        CircularNodeList<E> result = last;

        if (!this.isEmpty()) {

            newLast.setNext(header);
            header.setPrevious(newLast);
            
            result.setNext(result);
            result.setPrevious(result);
            
            this.setLast(newLast);
            
            return result.getContent();
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            
            CircularNodeList<E> cursor = last.getNext();
            short count = 0;            
            
            @Override
            public boolean hasNext() {
                count++;
                if (count == 1) {
                    return cursor == last.getNext();
                }
                return cursor != last.getNext();
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext();
                return e;
            }
        };
    }

    @Override
    public int compareTo(E t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        
        String result = "";
        CircularNodeList<E> n;
        
        for (n = last.getNext(); n != last; n = n.getNext()) {
            E e = n.getContent();
            result += e.toString();
        }
        
        result += last.getContent().toString();
        
        return result;
    }

    /*
    
        No está bien implementado
    
    */
//    @Override
//    public boolean clear() {
//        
//        for (E e : this) {
//            this.removeLast();
//        }
//        
//        if (this.size() == 0)
//            return true;
//        
//        return false;
//        
//    }

    @Override
    public E get(int index) {
        
        int count = 0;
        
        if (index <= this.size()) {
            
            CircularNodeList<E> i;
            for (i = last.getNext(); i != this.last; i = i.getNext()) {
                if (count == index) {
                    return i.getContent();
                }
                count++;
            }
        }
        
        return null;
    }

    @Override
    public boolean set(int index, E e) {
        if (e != null) {
            
            int size = this.size();
            int counter = 0;
            
            if (index == 0) {
                this.addFirst(e);
            }
            
            else if (index < size) {
                CircularNodeList<E> i;
                for (i = last.getNext(); i != this.last; i = i.getNext()) {
                    if (counter == index) {
                        i.setContent(e);
                        return true;
                    }
                    counter++;
                }
            }
        }
        return false;
    }
}
