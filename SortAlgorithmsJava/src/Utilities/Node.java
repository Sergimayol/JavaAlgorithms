package Utilities;

import java.util.Objects;

/**
 *
 * @author Sergi
 */
public class Node {

    private Object item;
    private Node next;

    /**
     *
     * @param item
     * @param next
     */
    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    /**
     *
     * @return Object
     */
    public Object getItem() {
        return item;
    }

    /**
     *
     * @param item
     */
    public void setItem(Object item) {
        this.item = item;
    }

    /**
     *
     * @return Object ( Node )
     */
    public Node getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Node{" + "item=" + item + ", next=" + next + '}';
    }

    /**
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.item);
        hash = 53 * hash + Objects.hashCode(this.next);
        return hash;
    }

    /**
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (!Objects.equals(this.next, other.next)) {
            return false;
        }
        return true;
    }

}
