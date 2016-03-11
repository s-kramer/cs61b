package org.skramer.cs61b.sentinelLinkedList;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static junit.framework.Assert.assertEquals;

/**
 * Created by skramer on 3/10/16.
 * Unit tests for LinkedList - the linked list implementation with a sentinel node
 */
public class LinkedListTest {

    private LinkedList list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList();
    }

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
        list.insertFront(5);
        assertEquals(1, list.getSize());
        assertEquals(Collections.singletonList(5), list.getValues());

        list.insertFront(10);
        assertEquals(2, list.getSize());
        assertEquals(Arrays.asList(10, 5), list.getValues());
    }

    @Test
    public void nodesCanBeAddedToTheBackOfTheList() {
        list.insertBack(5);
        assertEquals(1, list.getSize());
        assertEquals(Collections.singletonList(5), list.getValues());

        list.insertBack(10);
        assertEquals(2, list.getSize());
        assertEquals(Arrays.asList(5, 10), list.getValues());
    }

    @Test
    public void listWithMultipleNodesCanBeCreatedAtOnce() {
        LinkedList multielementList = new LinkedList(1, 2, 3, 4, 5);
        assertEquals(5, multielementList.getSize());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), multielementList.getValues());
    }
}
