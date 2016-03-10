package org.skramer.cs61b.sentinelLinkedList;

/**
 * Created by skramer on 3/10/16.
 * A linked list implementation.
 * This implementation is a backing implementation that should be only used by LinkedList.
 */
class LinkedListNode {
    private final int value;
    public LinkedListNode next;

    public LinkedListNode(int value, LinkedListNode next) {
        this.next = next;
        this.value = value;
    }

    public LinkedListNode(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
