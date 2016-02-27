package org.skramer.cs61b.linkedlist;

/**
 * A linked list node
 */
public class LinkedListNode {
    public final int value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListNode node = (LinkedListNode) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    /**
     * Inserts a new LinkedListNode after this one
     *
     * @param value The value of the node that will be added after current node
     */
    public void insertAfter(int value) {
        tail = new LinkedListNode(value, tail);
    }

    /**
     * Returns the size of the list from the current node.
     * The list terminator is considered to be a null object.
     *
     * @return the number of nodes from the current node to the terminator node (null object).
     */
    public int size() {
        if (tail == null) {
            return 1;
        }

        return 1 + tail.size();
    }
}
