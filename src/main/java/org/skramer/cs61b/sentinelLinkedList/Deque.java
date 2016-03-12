package org.skramer.cs61b.sentinelLinkedList;

import java.util.List;

/**
 * Created by skramer on 3/12/16.
 * Double ended queue interface.
 * It's required that getSize() operates in constant time.
 */
public interface Deque<T> {
    /**
     * Returns the length of the list, i.e. the number of nodes that were added to the list.
     * This function returns in constant time.
     *
     * @return the length of the list
     */
    int getSize();

    /**
     * Inserts a new node with value i to the front of the list
     *
     * @param value the value to be added to the front of the list
     */
    void insertFront(T value);

    /**
     * Inserts a new node with value value to the end of the list
     *
     * @param value the value that should be associated with the node appended to the list
     */
    void insertBack(T value);

    /**
     * Inserts a new node with value value at index n. The node that was previously on position n will now be on n+1.
     *
     * @param n     the index onto which the new node should be added
     * @param value the value of the node to be added
     */
    void insertNode(int n, T value);

    /**
     * Generates a list of all values in the list
     *
     * @return a list of values stored in subsequent nodes of the list
     */
    List<T> getValues();

    /**
     * Returns the value of the n-th subsequent node
     *
     * @param n the number of the node that should be queried
     * @return the value associated with the n-th node
     */
    T getNodeValue(int n);

    /**
     * Removes the first node of the list. This operation happens in constant time
     */
    void removeFront();

    /**
     * Removes the last node of the list. This operation happens in constant time.
     */
    void removeBack();

    /**
     * Removes nth node from the list
     *
     * @param n the 0-based number of the node that should be removed
     */
    void removeNode(int n);
}
