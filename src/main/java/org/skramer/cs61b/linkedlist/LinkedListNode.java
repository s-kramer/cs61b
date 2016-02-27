package org.skramer.cs61b.linkedlist;

/**
 * A node object to be used by the LinkedList class
 */
public class LinkedListNode {
    final int value;
    public LinkedListNode tail;

    /**
     * Constructor
     *
     * @param value The value associated with this node
     * @param next  Points to the tail node in the linked list. Should be null if this is the last node.
     */
    public LinkedListNode(int value, LinkedListNode next) {
        this.tail = next;
        this.value = value;
    }
}
