package org.skramer.cs61b.sentinelLinkedList;

/**
 * Created by skramer on 3/10/16.
 * A linked list implementation with a sentinel node
 */
public class LinkedList {
    private LinkedListNode listNode;
    private int size;
    private static int SENTINEL_NODE_VALUE = Integer.MAX_VALUE;

    /**
     * Creates a linked list with a single node which's value is value
     *
     * @param value the value of the first node of the newly created list
     */
    public LinkedList(int value) {
        size = 1;
        listNode = makeSentinelNode();
        listNode.next = new LinkedListNode(value);
    }

    /**
     * Creates an empty linked list
     */
    public LinkedList() {
        size = 0;
        listNode = makeSentinelNode();
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
}
