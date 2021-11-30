package CircularList;

import java.util.Comparator;
import java.util.Iterator;

public interface CircularList<E> extends Iterable<E>, Comparable<E>{
    
    public int size();
    
    /* Implementar mejor */
//    public boolean clear();

    public boolean isEmpty();
    
    public boolean addFirst(E e);
    
    public boolean addLast(E e);
    
    public E removeFirst();
    
    public E removeLast();
    
    public E get(int index);
    
    public boolean set(int index, E e);
    
}
