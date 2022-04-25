package SetandMapping;

import Utilities.Node;
import Utilities.Set;
import java.util.Iterator;

/**
 *
 * @author Sergi
 * @param <E>
 */
public class UnsortedLinkedListSet<E> implements Set<E> {

    private Node first;

    /**
     *
     */
    public UnsortedLinkedListSet() {
        this.first = null;
    }

    /**
     *
     * @param elem
     * @return
     */
    @Override
    public boolean contains(E elem) {
        Node p = first;
        boolean trobat = false;
        while (p != null && !trobat) {
            trobat = p.getItem().equals(elem);
            p = p.getNext();
        }
        return trobat;
    }

    /**
     *
     * @param elem
     * @return
     */
    @Override
    public boolean add(E elem) {
        boolean trobat = contains(elem);
        if (!trobat) {
            first = new Node(elem, first);
        }
        return !trobat;
    }

    /**
     *
     * @param elem
     * @return
     */
    @Override
    public boolean remove(E elem) {
        Node p = first;
        Node pp = null;
        boolean trobat = false;
        while (p != null && !trobat) {
            trobat = p.getItem().equals(elem);
            if (!trobat) {
                pp = p;
                p = p.getNext();
            }
        }
        if (trobat) {
            if (pp == null) {
                first = p.getNext();
            } else {
                pp.setNext(p.getNext());
            }
        }
        return trobat;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        return new IteratorUnsortedLinkedListSet();
    }

    private class IteratorUnsortedLinkedListSet implements Iterator {

        private Node idxIterator;

        private IteratorUnsortedLinkedListSet() {
            idxIterator = first;
        }

        @Override
        public boolean hasNext() {
            return idxIterator != null;
        }

        @Override
        public Object next() {
            E elem = (E) idxIterator.getItem();
            idxIterator = idxIterator.getNext();
            return elem;
        }
    }
}
