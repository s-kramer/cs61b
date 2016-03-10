package org.skramer.cs61b.sentinelLinkedList;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Created by skramer on 3/10/16.
 * Unit tests for LinkedList - the linked list implementation with a sentinel node
 */
public class LinkedListTest {

    @Test
    public void EmptyListCreationIsPossible() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.getSize());
    }

    @Test
    public void SingleNodeCreation() {
        LinkedList list = new LinkedList(5);
        assertEquals(1, list.getSize());
    }

    @Test
    public void nodesCanBeAddedToTheFrontOfTheList() {
        LinkedList list = new LinkedList();
        list.insertFront(5);
        assertEquals(1, list.getSize());
        assertEquals(Arrays.asList(5), list.getValues());

        list.insertFront(10);
        assertEquals(2, list.getSize());
        assertEquals(Arrays.asList(10, 5), list.getValues());
    }
}
