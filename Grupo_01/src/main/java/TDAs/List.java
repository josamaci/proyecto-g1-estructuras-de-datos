package TDAs;

import java.util.Comparator;
import java.util.Iterator;

public interface List<E> extends Iterable<E>, Comparable<E>{

    public boolean addFirst(E e);

    public boolean addLast(E e);

    public E removeFirst();

    public E removeLast();

    public int size();

    public boolean isEmpty();

    public void clear();

    public void add(int index, E element);

    public E remove(int index);

    public E get(int index);

    public E set(int index, E element);

    public String toString();

    public Iterator<E> iterator();

    public List<E> findAll(Comparator<E> cmp, E element);
}
