package SetandMapping;

import java.util.Arrays;
import java.util.Iterator;

public class UnsortedArraySet<E> {

    private E[] array;
    private int n;

    // Reserva memòria per un array de longitud max i inicialitza n a 0
    public UnsortedArraySet(int max) {
        this.array = (E[]) new Object[max];
        this.n = 0;
    }

    // O(n): cerca lineal
    public boolean contains(E elem) {
        for (int i = 0; i < n && !isEmpty(); i++) {
            if (this.array[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    /* O(n): abans d’afegir, ha de comprovar que la clau no existeix dins el 
     * conjunt (cerca lineal)
     */
    public boolean add(E elem) {
        if (n < this.array.length) {
            int i = 0;
            while (i < this.array.length && n < this.array.length) {
                if (!contains(elem)) {
                    this.array[n] = elem;
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
    public boolean remove(E elem) {
        for (int i = 0; i < n && !isEmpty(); i++) {
            if (this.array[i].equals(elem)) {
                this.array[i] = null;
                n--;
                return true;
            }
        }
        return false;
    }

    // O(1)
    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator iterator() {
        return new IteratorUnsortedArraySet();
    }

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
