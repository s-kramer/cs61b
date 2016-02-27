package org.skramer.cs61b.linkedlist;

import java.util.NoSuchElementException;

/**
 * A linked list node
 */
public class LinkedListNode {
    private int value;
    private LinkedListNode tail;

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
    public String toString() {
        if (tail == null) {
            return Integer.toString(value);
        }

        return value + " " + tail.toString();
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
     * This method uses recursive approach.
     *
     * @return the number of nodes from the current node to the terminator node (null object).
     */
    public int size() {
        if (tail == null) {
            return 1;
        }

        return 1 + tail.size();
    }

    /**
     * Counts the size of the list from the current node to the terminator node.
     * The list terminator is considered to be a null object.
     * This method uses iterative approach.
     *
     * @return the number of nodes from the current node to the terminator node (null object).
     */
    public int sizeIterative() {
        LinkedListNode current = this;
        int size = 0;
        while (current != null) {
            size += 1;
            current = current.tail;
        }

        return size;
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

    /**
     * Finds the n-th subsequent element counting from the current node and returns its value.
     * This method uses recursive approach.
     *
     * @param i the index of the node that should be returned.
     * @return the value associated with the i-th node
     * @throws NoSuchElementException if requested index does not exist
     */
    public int getElementRecursive(int i) {
        if (i == 0) {
            return value;
        }

        if (tail == null) {
            throw new NoSuchElementException();
        }

        return tail.getElementRecursive(i - 1);
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a mutable way.
     * The modification is made in place, that is listNode will be modified after this method returns.
     * This method uses iterative approach.
     *
     * @param listNode     the head of the linked list that should be modified
     * @param modification the integer value that should be added to all the nodes
     */
    public static void dincrListIterative(LinkedListNode listNode, int modification) {
        LinkedListNode current = listNode;

        while (current != null) {
            current.setValue(current.getValue() + modification);
            current = current.tail;
        }
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a immutable way.
     * The result list is independent of @code listNode.
     * This method uses iterative approach.
     *
     * @param listNode     the head of the linked list that should be copied and modified
     * @param modification the integer value that should be added to all the nodes
     */
    public static LinkedListNode incrListIterative(LinkedListNode listNode, int modification) {
        LinkedListNode result = new LinkedListNode(listNode.getValue() + modification, null);

        LinkedListNode current_source = listNode.tail;
        LinkedListNode current_result = result;

        while (current_source != null) {
            current_result.tail = new LinkedListNode(current_source.getValue() + modification, null);
            current_result = current_result.tail;
            current_source = current_source.tail;
        }

        return result;
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a immutable way.
     * The result list is independent of @code listNode.
     * This method uses recursive approach.
     *
     * @param listNode     the head of the linked list that should be copied and modified
     * @param modification the integer value that should be added to all the nodes
     */
    public static LinkedListNode incrListRecursive(LinkedListNode listNode, int modification) {
        if (listNode.tail == null) {
            return new LinkedListNode(listNode.getValue() + modification, null);
        }

        return new LinkedListNode(listNode.getValue() + modification,
                                  incrListRecursive(listNode.tail, modification));
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a mutable way.
     * The modification is made in place, that is @code listNode will be modified after this method returns.
     * This method uses recursive approach.
     *
     * @param listNode     the list that should be modified
     * @param modification the value that should be added to all the nodes of the list
     */
    public static void dincrListRecursive(LinkedListNode listNode, int modification) {
        if (listNode == null) {
            return;
        }

        listNode.setValue(listNode.getValue() + modification);
        dincrListRecursive(listNode.tail, modification);
    }
}
