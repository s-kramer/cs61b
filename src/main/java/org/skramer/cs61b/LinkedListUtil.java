package org.skramer.cs61b;

import org.skramer.cs61b.linkedlist.LinkedListNode;

/**
 * Created by skramer on 2/27/16.
 * Utility functions for LinkedList class
 */
public class LinkedListUtil {
    /**
     * Increments all the nodes of @code listNode by @code modification in a mutable way.
     * The modification is made in place, that is listNode will be modified after this method returns.
     *
     * @param listNode     the head of the linked list that should be modified
     * @param modification the integer value that should be added to all the nodes
     */
    public static void dincrList(LinkedListNode listNode, int modification) {
        LinkedListNode current = listNode;

        while (current != null) {
            current.setValue(current.getValue() + modification);
            current = current.tail;
        }
    }
}
