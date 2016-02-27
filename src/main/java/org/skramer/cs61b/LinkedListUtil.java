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
        // todo: recursive approach
        // todo: move this to LinkedListNode class
        LinkedListNode current = listNode;

        while (current != null) {
            current.setValue(current.getValue() + modification);
            current = current.tail;
        }
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a immutable way.
     * The result list is independent of @code listNode.
     *
     * @param listNode     the head of the linked list that should be copied and modified
     * @param modification the integer value that should be added to all the nodes
     */
    // todo: fix tail visibility
    public static LinkedListNode incrList(LinkedListNode listNode, int modification) {
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
}
