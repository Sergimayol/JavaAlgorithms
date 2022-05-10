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

    /**
     *
     * @param max
     */
    public ArrayMapping(int max) {
        this.claus = (K[]) new Object[max];
        this.valors = (V[]) new Object[max];
        this.n = 0;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        return null;
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
