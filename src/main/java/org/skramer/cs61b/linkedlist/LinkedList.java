package org.skramer.cs61b.linkedlist;

/**
 * Created by skramer on 2/27/16.
 * Linked list representation
 */
public class LinkedList {
    private LinkedListNode head;

    public void addNode(LinkedListNode node) {
        if (head == null) {
            head = node;
        }
    }

    /**
     * Returns the head of the linked list
     *
     * @return head of the linked list
     */
    public LinkedListNode getHead() {
        return head;
    }
}
