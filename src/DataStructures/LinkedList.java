package DataStructures;

import SortAlgorithmsLinkedList.*;

/**
 *
 * @author Sergi
 * @param <E>
 */
public class LinkedList<E extends Comparable<E>> {

    private Node first;
    private int length;

    /**
     * Construtor
     */
    public LinkedList() {
        this.first = null;
        this.length = 0;
    }

    /**
     * Method to add an element
     *
     * @param element
     */
    public void add(E element) {
        this.first = new Node(element, this.first);
        this.length++;
    }

    /**
     * Method to do a merge sort of the actual linkedlist
     */
    public void mergeSort() {
        this.first = new MergeSortLinkedList().mergeSort(this.first);
    }

    /**
     * Method to do a quick sort of the actual linkedlist
     */
    public void quickSort() {
        new QuickSortLinkedList().sort(this.first, getLastNode());
    }

    /**
     * Method to convert this to a String
     *
     * @return
     */
    @Override
    public String toString() {
        return "LinkedList{" + "first=" + first + '}';
    }

    /**
     * Method to get a String of the list
     *
     * @return string
     */
    public String printList() {
        Node aux = this.first;
        String list = "";
        while (aux != null) {
            list += aux.getItem().toString() + "-->";
            aux = aux.getNext();
        }
        return list + "null";
    }

    /**
     * Method to get the last node of the list
     *
     * @return last node of the list
     */
    public Node getLastNode() {
        Node ult = this.first;
        while (ult.getNext() != null) {
            ult = ult.getNext();
        }
        return ult;
    }

    /**
     * Method to check if the list is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Method to delete the list
     */
    public void deleteList() {
        this.first = null;
    }

    /**
     * Method to get the first node of the list
     *
     * @return first node
     */
    public Node getFirst() {
        return first;
    }

    /**
     * Method to set the first node of the list
     *
     * @param first
     */
    public void setFirst(Node first) {
        this.first = first;
    }

    /**
     * Method to convert the linkedlist to an array
     *
     * @return array
     */
    public Object[] toArray() {
        Object[] array = new Object[this.length];
        Node aux = this.first;
        for (int i = 0; aux != null; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }
        return array;
    }

    /**
     * Method to get the length of the list
     *
     * @return int
     */
    public int getLength() {
        return length;
    }

}
