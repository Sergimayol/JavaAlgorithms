package SetandMapping;

import Utilities.Mapping;
import java.util.Iterator;

/**
 *
 * @author Sergi
 * @param <K>
 * @param <V>
 */
public class UnsortedArrayMapping<K, V> implements Mapping<K, V>{

    private K[] claus;
    private V[] valors;
    private int n;

    // Reserva memòria pels dos arrays de longitud max i inicialitza n a 0
    public UnsortedArrayMapping(int max) {
        this.claus = (K[]) new Object[max];
        this.valors = (V[]) new Object[max];
        this.n = 0;
    }

    // O(n): cerca lineal
    @Override
    public V get(K key) {
        return null;
    }

    // O(n): Retorna el valor anterior associat a la clau (cerca lineal), si n’hi havia
    @Override
    public V put(K key, V value) {
        return null;
    }

    // O(n): Retorna el valor anterior associat a la clau (cerca lineal), si n’hi havia
    @Override
    public V remove(K key) {
        return null;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
