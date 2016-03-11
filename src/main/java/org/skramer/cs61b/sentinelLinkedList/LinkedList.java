package org.skramer.cs61b.sentinelLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skramer on 3/10/16.
 * A linked list implementation.
 * This implementation ensures that getSize() operates in constant time and that operations on the back of the list
 * are performed in the same time as operations performed on the front.
 */
public class LinkedList {
    private LinkedListNode sentinelNode;
    private int size;

    /**
     * Creates a new linked list. Each of the provided arguments will be used to create a subsequent node of the list
     *
     * @param args values that will be used to create linked list nodes
     */
    public LinkedList(int... args) {
        sentinelNode = makeSentinelNode();
        for (int i : args) {
            insertBack(i);
        }
    }

    /**
     * Creates a linked list with a single node which's value is value
     *
     * @param value the value of the first node of the newly created list
     */
    public LinkedList(int value) {
        sentinelNode = makeSentinelNode();
        sentinelNode.next = new LinkedListNode(sentinelNode, value, sentinelNode);
        sentinelNode.prev = sentinelNode.next;
        size = 1;
    }

    /**
     * Creates an empty linked list
     */
    public LinkedList() {
        sentinelNode = makeSentinelNode();
        size = 0;
    }

    private LinkedListNode makeSentinelNode() {
        return LinkedListNode.createSentinelNode();
    }

    /**
     * Returns the length of the list, i.e. the number of nodes that were added to the list.
     * This function returns in constant time.
     *
     * @return the length of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Inserts a new node with value i to the front of the list
     *
     * @param i the value to be added to the front of the list
     */
    public void insertFront(int i) {
        sentinelNode.next = new LinkedListNode(getListFront(), i, sentinelNode);
        size += 1;
    }

    /**
     * Generates a list of all values in the list
     *
     * @return a list of values stored in subsequent nodes of the list
     */
    public List<Integer> getValues() {
        List<Integer> result = new ArrayList<>(size);

        for (LinkedListNode it = getListFront(); it != sentinelNode; it = it.next) {
            result.add(it.getValue());
        }

        return result;
    }

    /**
     * Inserts a new node with value value to the end of the list
     *
     * @param value the value that should be associated with the node appended to the list
     */
    public void insertBack(int value) {
        LinkedListNode it = getLastNode();

        it.next = new LinkedListNode(sentinelNode, value, it);
        sentinelNode.prev = it.next;
        size += 1;
    }

    private LinkedListNode getLastNode() {
        return sentinelNode.prev;
    }

    private LinkedListNode getListFront() {
        return sentinelNode.next;
    }

    /**
     * Removes the first node of the list. This operation happens in constant time
     */
    public void removeFront() {
        removeNode(0);
    }

    /**
     * Removes the last node of the list. This operation happens in constant time.
     */
    public void removeBack() {
        removeNode(size - 1);
    }

    private LinkedListNode getListBack() {
        return sentinelNode.prev;
    }

    // todo: make abstraction for sentinel node - different strategies should be used for empty list, signleton list and multielement list

    /**
     * Removes nth node from the list
     *
     * @param n the 0-based number of the node that should be removed
     */
    public void removeNode(int n) {
        LinkedListNode ithNode = getNthNode(n);
        ithNode.prev.next = ithNode.next;
        ithNode.next.prev = ithNode.prev;
        size -= 1;
    }

    private LinkedListNode getNthNode(int n) {
        if (n < 0 || n >= size) {
            throw new IllegalArgumentException(String.format("List element %d exceeds the size of the list which is %d",
                                                             n, size));
        }

        if (n <= size / 2) {
            return proceedForward(n);
        } else {
            final int lastIndex = size - 1;
            return proceedBackward(lastIndex - n);
        }
    }

    private LinkedListNode proceedBackward(int i) {
        LinkedListNode it = getListBack();
        for (; i > 0; i--) {
            it = it.prev;
        }
        return it;
    }

    private LinkedListNode proceedForward(int i) {
        LinkedListNode it = getListFront();
        for (int j = 0; j < i; j++) {
            it = it.next;
        }
        return it;
    }

    public int getNodeValue(int i) {
        return getNthNode(i).getValue();
    }

    /**
     * Inserts a new node with value value at index n. The node that was previously on position n will now be on n+1.
     *
     * @param n     the index onto which the new node should be added
     * @param value the value of the node to be added
     */
    public void insertNode(int n, int value) {
        LinkedListNode previousNth = getNthNode(n);
        LinkedListNode previousNMinus1th = previousNth.prev;

        previousNth.prev.next = new LinkedListNode(previousNth, value, previousNth.prev);
        previousNth.prev = previousNMinus1th.next;
    }

    // todo: generify
}
