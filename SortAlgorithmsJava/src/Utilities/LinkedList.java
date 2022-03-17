package Utilities;

/**
 *
 * @author Sergi
 * @param <E>
 */
public class LinkedList<E extends Comparable<E>> {

    private Node first;

    public LinkedList() {
        this.first = null;
    }

    public void add(E element) {
        this.first = new Node(element, this.first);
    }

    public void s() {
        System.out.println(middle(first));
    }

    private Node middle(Node firstNode) {
        if (firstNode == null) {
            return firstNode;
        }
        Node node = firstNode, aux = firstNode;
        while (aux.getNext() != null && aux.getNext().getNext() != null) {
            node = node.getNext();
            aux = aux.getNext().getNext();
        }
        return node;
    }

    // Ordena la llista amb el metode mergesort
    public void mergeSort() {
        System.out.println(mergeSort(this.first).toString());
    }

    private Node mergeSort(Node n) {
        return null;
    }

    // S’encarrega de fusionar les dues subllistes ordenades l, r
    // Retorna el punter a l’inici de la llista fusionada
    private Node merge(Node l, Node r) {
        return null;
    }

    @Override
    public String toString() {
        return "LinkedList{" + "first=" + first + '}';
    }

}
