/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetandMapping;

import Utilities.Mapping;
import java.util.Iterator;
//import jdk.internal.net.http.common.Pair;

/**
 *
 * @author Sergi
 * @param <K>
 * @param <V>
 */
public class UnsortedLinkedListMapping<K, V> implements Mapping<K, V> {

    private class Node {

        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    private Node first;

    /**
     * Constructor
     */
    public UnsortedLinkedListMapping() {
        this.first = null;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node p = first;
        boolean trobat = false;
        while (p != null && !trobat) {
            trobat = p.key.equals(key);
            if (!trobat) {
                p = p.next;
            }
        }
        if (trobat) {
            return p.value;
        } else {
            return null;
        }
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        Node p = first;
        boolean trobat = false;
        while (p != null && !trobat) {
            trobat = p.key.equals(key);
            if (!trobat) {
                p = p.next;
            }
        }
        if (trobat) {
            V valueAnt = p.value;
            p.value = value;
            return valueAnt;
        } else {
            Node n = new Node(key, value, first);
            first = n;
            return null;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Node p = first;
        Node pp = null;
        boolean trobat = false;
        while (p != null && !trobat) {
            trobat = p.key.equals(key);
            if (!trobat) {
                pp = p;
                p = p.next;
            }
        }
        if (trobat) {
            V valueAnt = p.value;
            if (pp == null) {
                first = p.next;
            } else {
                pp.next = p.next;
            }
            return valueAnt;
        } else {
            return null;
        }
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
        return new IteratorUnsortedLinkedListMapping();
    }

    /**
     * Pair of values (key, value)
     */
    protected class Pair {

        private K key;
        private V value;

        /**
         *
         * @param key
         * @param value
         */
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         *
         * @return
         */
        public K getKey() {
            return key;
        }

        /**
         *
         * @param key
         */
        public void setKey(K key) {
            this.key = key;
        }

        /**
         *
         * @return
         */
        public V getValue() {
            return value;
        }

        /**
         *
         * @param value
         */
        public void setValue(V value) {
            this.value = value;
        }

    }

    private class IteratorUnsortedLinkedListMapping implements Iterator {

        private Node idxIterator;

        private IteratorUnsortedLinkedListMapping() {
            idxIterator = first;
        }

        @Override
        public boolean hasNext() {
            return idxIterator != null;
        }

        @Override
        public Object next() {
            Pair p = new Pair(idxIterator.key, idxIterator.value);
            idxIterator = idxIterator.next;
            return p;
        }
    }
}
