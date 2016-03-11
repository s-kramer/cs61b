package org.skramer.cs61b.sentinelLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skramer on 3/10/16.
 * A linked list implementation with a sentinel node
 */
public class LinkedList {
    private LinkedListNode sentinelNode;
    private int size;
    private static int SENTINEL_NODE_VALUE = Integer.MAX_VALUE;

    /**
     * Creates a linked list with a single node which's value is value
     *
     * @param value the value of the first node of the newly created list
     */
    public LinkedList(int value) {
        sentinelNode = makeSentinelNode();
        sentinelNode.next = new LinkedListNode(value);
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
        LinkedListNode sentinelNode = new LinkedListNode(SENTINEL_NODE_VALUE);
        sentinelNode.next = sentinelNode;
        return sentinelNode;
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
        sentinelNode.next = new LinkedListNode(i, getFront());
        size += 1;
    }

    /**
     * Generates a list of all values in the list
     *
     * @return a list of values stored in subsequent nodes of the list
     */
    public List<Integer> getValues() {
        List<Integer> result = new ArrayList<>(size);

        for (LinkedListNode it = getFront(); it != sentinelNode; it = it.next) {
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
        LinkedListNode it = moveToLastNode(getFront());

        it.next = new LinkedListNode(value, sentinelNode);
        size += 1;
    }

    private LinkedListNode moveToLastNode(LinkedListNode node) {
        while (node.next != sentinelNode) {
            node = node.next;
        }
        return node;
    }

    private LinkedListNode getFront() {
        return sentinelNode.next;
    }
}
