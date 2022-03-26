package Utilities;

import SortAlgorithmsLinkedList.*;

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

    public void mergeSort() {
        this.first = new MergeSortLinkedList().mergeSort(this.first);
    }

    public void quickSort() {
        new QuickSortLinkedList().sort(this.first, getLastNode());
    }

    @Override
    public String toString() {
        return "LinkedList{" + "first=" + first + '}';
    }

    public String printList() {
        Node aux = this.first;
        String list = "";
        while (aux != null) {
            list += aux.getItem().toString() + "-->";
            aux = aux.getNext();
        }
        return list + "null";
    }

    private Node getLastNode() {
        Node ult = this.first;
        while (ult.getNext() != null) {
            ult = ult.getNext();
        }
        return ult;
    }

}
