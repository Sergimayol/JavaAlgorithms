package BinarySearchTree;

import Utilities.Mapping;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Sergi
 * @param <K>
 * @param <V>
 */
public class BSTMapping<K extends Comparable<K>, V> implements Mapping<K, V> {

    private Node root;

    /**
     * Constructor
     */
    public BSTMapping() {
        this.root = null;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        return get(key, root); // Es como el contains del set
    }

    private V get(K key, Node current) {
        // Si l’arbre és buit: no trobat
        // Si el node conté l’element: trobat
        // Si l’element és inferior a l’element del node: cercar al fill esquerra
        // Si l’element és superior a l’element del node: cercar al fill dret
        if (current == null) { // Si l’arbre és buit: no trobat
            return null;
        } else {
            if (current.key.equals(key)) {// Si el node conté l’element: trobat
                return current.value;
            }
            // Si l’element és inferior a l’element del node:
            if (key.compareTo(current.key) < 0) {
                return get(key, current.left); // cercar al fill esquerra
            } else {
                return get(key, current.right); // cercar al fill dret
            }
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
        Cerca cerca = new Cerca(null);
        this.root = put(key, value, root, cerca);
        return cerca.value;
    }

    private Node put(K key, V value, Node current, Cerca cerca) {
        if (current == null) {// Si l’arbre és buit: retornam un node nou
            return new Node(key, value, null, null);
        } else {
            if (current.key.equals(key)) {// Si el node conté l’element
                cerca.value = current.value;
                current.value = value;
                return current; // retornam el node (sense modificar)
            }
            if (key.compareTo(current.key) < 0) {// Si l’element és inferior
                // hem d’afegir al subarbre esquerre
                current.left = put(key, value, current.left, cerca);
            } else {
                // hem d’afegir al subarbre dret
                current.right = put(key, value, current.right, cerca);
            }
            return current;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Cerca cerca = new Cerca(null);
        this.root = remove(key, root, cerca);
        return cerca.value;
    }

    private Node remove(K key, Node current, Cerca cerca) {
        if (current == null) { // Element no trobat
            return null;
        }
        if (current.key.equals(key)) { // Element trobat
            // Eliminar node
            cerca.value = current.value;
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null && current.right != null) {
                return current.right;
            } else if (current.left != null && current.right == null) {
                return current.left;
            } else {
                Node plowest = current.right;
                Node parent = current;
                while (plowest.left != null) {
                    parent = plowest;
                    plowest = plowest.left;
                }
                plowest.left = current.left;
                if (plowest != current.right) {
                    parent.left = plowest.right;
                    plowest.right = current.right;
                }
                return plowest;
            }
        }
        if (key.compareTo(current.key) < 0) { // Subarbre esquerra
            current.left = remove(key, current.left, cerca);
        } else {// Subarbre dret
            current.right = remove(key, current.right, cerca);
        }
        return current;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        return new IteratorBSTMapping();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "BSTMapping{" + "root=" + root + '}';
    }

    private class Node {

        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", value=" + value + ", left=" + left + ", right=" + right + '}';
        }

    }

    private class Cerca {

        V value;

        public Cerca(V value) {
            this.value = value;
        }

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
         * @return
         */
        public V getValue() {
            return value;
        }
    }

    private class IteratorBSTMapping implements Iterator {

        private Stack<Node> iterator;

        private IteratorBSTMapping() {
            Node p;
            iterator = new Stack();
            if (root != null) {
                p = root;
                while (p.left != null) {
                    iterator.push(p);
                    p = p.left;
                }
                iterator.push(p);
            }
        }

        @Override
        public boolean hasNext() {
            return !iterator.isEmpty();
        }

        @Override
        public Object next() {
            Node p = iterator.pop();
            Pair pair = new Pair(p.key, p.value);
            if (p.right != null) {
                p = p.right;
                while (p.left != null) {
                    iterator.push(p);
                    p = p.left;
                }
                iterator.push(p);
            }
            return pair;
        }
    }
}
