package org.skramer.cs61b.linkedlist;

import java.util.NoSuchElementException;

/**
 * A linked list node
 */
public class LinkedListNode {
    private int value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
        // todo: alternative approach
        if (tail == null) {
            return 1;
        }

        return 1 + tail.size();
    }

    /**
     * Finds the n-th subsequent element counting from the current node and returns its value.
     *
     * @param i the index of the node that should be returned.
     * @return the value associated with the i-th node
     * @throws NoSuchElementException if requested index does not exist
     */
    public int getElement(int i) {
        LinkedListNode current = this;
        while (i > 0 && current != null) {
            i -= 1;
            current = current.tail;
        }

        if (current != null) {
            return current.value;
        } else {
            throw new NoSuchElementException();
        }
    }
}
