package BusquedaArbolBinario;

import Utilities.Mapping;
import java.util.Iterator;

/**
 *
 * @author Sergi
 * @param <K>
 * @param <V>
 */
public class BSTMapping<K extends Comparable<K>, V> implements Mapping<K, V> {

    private Node root;

    public BSTMapping() {
        this.root = null;
    }

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public V remove(K key) {
        if (!isEmpty()) {
            
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Iterator iterator() {
        return new IteratorBSTMapping();
    }

    private class Node {

        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private class IteratorBSTMapping implements Iterator {

        private Node idxIterator;

        private IteratorBSTMapping() {

        }

        @Override
        public boolean hasNext() {
            return idxIterator != null;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}
