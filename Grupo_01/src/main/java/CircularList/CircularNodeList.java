package CircularList;

public class CircularNodeList<E> {
    
    private E content;
    
    private CircularNodeList<E> next;
    
    private CircularNodeList<E> previous;
    
    public CircularNodeList() {
        this.content = null;
        this.next = this;
        this.previous = this;
    }
    
    public CircularNodeList(E content) {
        this.content =  content;
        this.next = this;
        this.previous = this;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public CircularNodeList<E> getNext() {
        return next;
    }

    public void setNext(CircularNodeList<E> next) {
        this.next = next;
    }

    public CircularNodeList<E> getPrevious() {
        return previous;
    }

    public void setPrevious(CircularNodeList<E> previous) {
        this.previous = previous;
    }
    
}
