package org.skramer.cs61b.linkedlist;

/**
 * A node object to be used by the LinkedList class
 */
public class LinkedListNode {
    final int value;
    LinkedListNode next;

    /**
     * Constructor
     *
     * @param next  Points to the next node in the linked list. Should be null if this is the last node.
     * @param value The value associated with this node
     */
    public LinkedListNode(LinkedListNode next, int value) {
        this.next = next;
        this.value = value;
    }
}
