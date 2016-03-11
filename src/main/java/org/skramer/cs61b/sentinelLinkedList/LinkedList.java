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
        LinkedListNode it = moveToLastNode(getListFront());

        it.next = new LinkedListNode(sentinelNode, value, it);
        sentinelNode.prev = it.next;
        size += 1;
    }

    private LinkedListNode moveToLastNode(LinkedListNode node) {
        while (node.next != sentinelNode) {
            node = node.next;
        }
        return node;
    }

    private LinkedListNode getListFront() {
        // todo: handle empty list ond one element list cases
        return sentinelNode.next;
    }

    /**
     * Removes the first node of the list
     */
    public void removeFront() {
        sentinelNode.next = getListFront().next;
        size -= 1;
    }

    public void removeBack() {
        LinkedListNode last = getListBack();
        sentinelNode.prev = last.prev;
        last.prev.next = sentinelNode;
        size -= 1;
    }

    private LinkedListNode getListBack() {
        return sentinelNode.prev;
    }
}
