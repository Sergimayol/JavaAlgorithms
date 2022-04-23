package SetandMapping;

import Utilities.Mapping;
import java.util.Iterator;

/**
 *
 * @author Sergi
 * @param <K>
 * @param <V>
 */
public class ArrayMapping<K, V> implements Mapping<K, V>{

    private K[] claus;
    private V[] valors;
    private int n;

    public ArrayMapping(int max) {
        this.claus = (K[]) new Object[max];
        this.valors = (V[]) new Object[max];
        this.n = 0;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
