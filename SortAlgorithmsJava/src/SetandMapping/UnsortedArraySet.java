package SetandMapping;

import Utilities.Set;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Sergi
 * @param <E>
 */
public class UnsortedArraySet<E> implements Set<E> {

    private E[] array;
    private int n;

    // Reserva memòria per un array de longitud max i inicialitza n a 0

    /**
     *
     * @param max
     */
    public UnsortedArraySet(int max) {
        this.array = (E[]) new Object[max];
        this.n = 0;
    }

    // O(n): cerca lineal

    /**
     *
     * @param elem
     * @return
     */
    @Override
    public boolean contains(E elem) {
        for (int i = 0; i < n && !isEmpty(); i++) {
            if (this.array[i] != null && this.array[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    /* O(n): abans d’afegir, ha de comprovar que la clau no existeix dins el 
     * conjunt (cerca lineal)
     */

    /**
     *
     * @param elem
     * @return
     */

    @Override
    public boolean add(E elem) {
        if (n < this.array.length) {
            int i = 0;
            while (i < this.array.length) {
                if (!contains(elem) && this.array[i] == null) {
                    this.array[i] = elem;
                    n++;
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    // O(n): cal cercar la clau dins el conjunt (cerca lineal) i
    // el darrer element ha de situar-se a la posició alliberada

    /**
     *
     * @param elem
     * @return
     */
    @Override
    public boolean remove(E elem) {
        for (int i = 0; i < n && !isEmpty(); i++) {
            if (this.array[i] != null && this.array[i].equals(elem)) {
                this.array[i] = null;
                n--;
                return true;
            }
        }
        return false;
    }

    // O(1)

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        return new IteratorUnsortedArraySet();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "UnsortedArraySet{" + "array=" + Arrays.deepToString(array) + ", n=" + n + '}';
    }

    private class IteratorUnsortedArraySet implements Iterator {

        private int idxIterator;

        private IteratorUnsortedArraySet() {
            idxIterator = 0;
        }

        @Override
        public boolean hasNext() {
            return idxIterator < n;
        }

        @Override
        public Object next() {
            idxIterator++;
            return array[idxIterator - 1];
        }
    }

}
