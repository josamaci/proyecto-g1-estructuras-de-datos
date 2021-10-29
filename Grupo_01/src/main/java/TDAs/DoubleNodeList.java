package TDAs;

public class DoubleNodeList<E> {

    private E content;
    private DoubleNodeList<E> next;
    private DoubleNodeList<E> previous;

    public DoubleNodeList(E element) {
        this.content = element;
        this.next = this;
        this.previous = this;
    }

    public E getContent() {
        return content;
    }

    public DoubleNodeList<E> getNext() {
        return next;
    }

    public DoubleNodeList<E> getPrevious() {
        return previous;
    }

    public void setNext(DoubleNodeList<E> e) {
        this.next = e;
    }

    public void setContent(E e) {
        this.content = e;
    }

    public void setPrevious(DoubleNodeList<E> previous) {
        this.previous = previous;
    }
}
