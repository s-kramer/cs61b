package org.skramer.cs61b.sentinelLinkedList;

/**
 * Created by skramer on 3/10/16.
 * A linked list implementation with a sentinel node
 */
public class LinkedList {
    private int size;

    public LinkedList(int value) {
        size = 1;
        LinkedListNode listNode = new LinkedListNode(value);
    }

    /**
     * Creates an empty linked list
     */
    public LinkedList() {

    }

    /**
     * Returns the length of the list, i.e. the number of nodes that were added to the list
     *
     * @return the length of the list
     */
    public int getSize() {
        return size;
    }
}
