package BusquedaArbolBinario;

/**
 *
 * @author Sergi
 * @param <E>
 */
public class BSTSet<E extends Comparable> {

    private class Node {

        public E elem;
        public Node left, right;

        public Node(E elem, Node left, Node right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

    }
    private Node root;

    private class Cerca {

        boolean trobat;

        public Cerca(boolean trobat) {
            this.trobat = trobat;
        }

    }

    public BSTSet() {
        this.root = null;
    }

    boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(E elem) {
        return contains(elem, root);
    }

    private boolean contains(E elem, Node current) {
        // Si l’arbre és buit: no trobat
        // Si el node conté l’element: trobat
        // Si l’element és inferior a l’element del node: cercar al fill esquerra
        // Si l’element és superior a l’element del node: cercar al fill dret
        if (current == null) { // Si l’arbre és buit: no trobat
            return false;
        } else {
            if (current.elem.equals(elem)) {// Si el node conté l’element: trobat
                return true;
            }
            // Si l’element és inferior a l’element del node:
            if (elem.compareTo(current.elem) < 0) {
                return contains(elem, current.left); // cercar al fill esquerra
            } else {
                return contains(elem, current.right); // cercar al fill dret
            }
        }
    }

    private Node add(E elem, Node current) {
        if (current == null) {// Si l’arbre és buit: retornam un node nou
            return new Node(elem, null, null);
        } else {
            if (current.elem.equals(elem)) {// Si el node conté l’element
                return current; // retornam el node (sense modificar)
            }
            if (elem.compareTo(current.elem) < 0) {// Si l’element és inferior
                // hem d’afegir al subarbre esquerre
                current.left = add(elem, current.left);
            } else {
                // hem d’afegir al subarbre dret
                current.right = add(elem, current.right);
            }
            return current;
        }
    }

    public boolean add(E elem) {
        Cerca cerca = new Cerca(false);
        //this.root = add(elem, root, cerca);
        return !cerca.trobat;
    }
}
