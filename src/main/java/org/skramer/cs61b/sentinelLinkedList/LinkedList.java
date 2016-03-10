package org.skramer.cs61b.sentinelLinkedList;

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
     * Returns the length of the list, i.e. the number of nodes that were added to the list
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
        sentinelNode.next = new LinkedListNode(i, sentinelNode.next);
        size += 1;
    }
}
