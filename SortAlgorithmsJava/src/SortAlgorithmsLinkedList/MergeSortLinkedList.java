package SortAlgorithmsLinkedList;

import Utilities.Node;

/**
 *
 * @author Sergi
 */
public class MergeSortLinkedList {
    
    public MergeSortLinkedList() {
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

    public Node mergeSort(Node h) {
        // Base case : if head is null
        if (h == null || h.getNext() == null) {
            return h;
        }
        // get the middle of the list
        Node middle = middle(h);
        Node nextofmiddle = middle.getNext();

        // set the next of middle node to null
        middle.setNext(null);

        // Apply mergeSort on left list
        Node left = mergeSort(h);

        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = merge(left, right);
        return sortedlist;
    }

    // S’encarrega de fusionar les dues subllistes ordenades l, r
    // Retorna el punter a l’inici de la llista fusionada
    private Node merge(Node l, Node r) {
        Node result = null;
        /* Base cases */
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }

        /* Pick either a or b, and recur */
        if ((int) l.getItem() <= (int) r.getItem()) {
            result = l;
            result.setNext(merge(l.getNext(), r));
        } else {
            result = r;
            result.setNext(merge(l, r.getNext()));
        }
        return result;
    }
}
