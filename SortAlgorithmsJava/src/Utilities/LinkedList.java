package Utilities;

import SortAlgorithmsLinkedList.*;

/**
 *
 * @author Sergi
 * @param <E>
 */
public class LinkedList<E extends Comparable<E>> {

    private Node first;
    private int length;

    public LinkedList() {
        this.first = null;
        this.length = 0;
    }

    public void add(E element) {
        this.first = new Node(element, this.first);
        this.length++;
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

    public Node getLastNode() {
        Node ult = this.first;
        while (ult.getNext() != null) {
            ult = ult.getNext();
        }
        return ult;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void deleteList() {
        this.first = null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Object[] toArray() {
        Object[] array = new Object[this.length];
        Node aux = this.first;
        for (int i = 0; aux != null; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }
        return array;
    }

    public int getLength() {
        return length;
    }

}
