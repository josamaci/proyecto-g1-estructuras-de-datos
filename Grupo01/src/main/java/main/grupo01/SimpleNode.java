package main.grupo01;

public class SimpleNode<E> {

    private E content;
    private SimpleNode<E> next;

    public SimpleNode(E element, SimpleNode<E> next) { //Constructor con el siguiente nodo
        this.content = element;
        this.next = next;
    }

    public SimpleNode(E element) { //Constructor sin el siguiente nodo
        this.content = element;
    }

    public E getContent() {
        return content;
    }

    public SimpleNode<E> getNext() {
        return next;
    }

    public void setNext(SimpleNode<E> e) {
        this.next = e;
    }

    public void setContent(E e) {
        this.content = e;
    }
}
