package main.grupo01;

public class DoubleNode<E> {

    private E content;
    private DoubleNode<E> next;
    private DoubleNode<E> previous;

    public DoubleNode(E element) {
        this.content = element;
        this.next = this;
        this.previous = this;
    }

    public E getContent() {
        return content;
    }

    public DoubleNode<E> getNext() {
        return next;
    }

    public DoubleNode<E> getPrevious() {
        return previous;
    }

    public void setNext(DoubleNode<E> e) {
        this.next = e;
    }

    public void setContent(E e) {
        this.content = e;
    }

    public void setPrevious(DoubleNode<E> previous) {
        this.previous = previous;
    }
}
