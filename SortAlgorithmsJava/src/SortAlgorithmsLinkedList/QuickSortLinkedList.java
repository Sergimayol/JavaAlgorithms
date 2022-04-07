package SortAlgorithmsLinkedList;

import Utilities.Node;

/**
 *
 * @author Sergi
 */
public class QuickSortLinkedList {

    public QuickSortLinkedList() {
    }

    // takes first and last node,
    // but do not break any links in
    // the whole linked list
    private Node paritionLast(Node start, Node end) {
        if (start == end || start == null || end == null) {
            return start;
        }
        Node pivot_prev = start;
        Node curr = start;
        int pivot = (int) end.getItem();
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if ((int) start.getItem() < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                Object temp = curr.getItem();
                curr.setItem(start.getItem());
                start.setItem(temp);
                curr = curr.getNext();
            }
            start = start.getNext();
        }
        // swap the position of curr i.e.
        // getNext() suitable index and pivot
        Object temp = curr.getItem();
        curr.setItem(pivot);
        end.setItem(temp);
        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    public void sort(Node start, Node end) {
        if (start == null || start == end || start == end.getNext()) {
            return;
        }
        // split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from getNext() of pivot
        if (pivot_prev != null && pivot_prev == start) {
            sort(pivot_prev.getNext(), end);
        } // if pivot is in between of the list,
        // start from getNext() of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                && pivot_prev.getNext() != null) {
            sort(pivot_prev.getNext().getNext(), end);
        }
    }
}
