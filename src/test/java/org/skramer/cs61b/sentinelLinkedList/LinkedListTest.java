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

    private LinkedList emptyList;
    private LinkedList multiElementList;
    private LinkedList singletonList;

    @Before
    public void setUp() throws Exception {
        emptyList = new LinkedList();
        multiElementList = new LinkedList(1, 2, 3, 4, 5);
        singletonList = new LinkedList(5);
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
        emptyList.insertFront(5);
        assertEquals(1, emptyList.getSize());
        assertEquals(Collections.singletonList(5), emptyList.getValues());

        emptyList.insertFront(10);
        assertEquals(2, emptyList.getSize());
        assertEquals(Arrays.asList(10, 5), emptyList.getValues());
    }

    @Test
    public void nodesCanBeAddedToTheBackOfTheList() {
        emptyList.insertBack(5);
        assertEquals(1, emptyList.getSize());
        assertEquals(Collections.singletonList(5), emptyList.getValues());

        emptyList.insertBack(10);
        assertEquals(2, emptyList.getSize());
        assertEquals(Arrays.asList(5, 10), emptyList.getValues());
    }

    @Test
    public void listWithMultipleNodesCanBeCreatedAtOnce() {
        LinkedList multiElementList = new LinkedList(1, 2, 3, 4, 5);
        assertEquals(5, multiElementList.getSize());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), multiElementList.getValues());
    }

    @Test
    public void frontNodeCanBeRemoved() {
        multiElementList.removeFront();
        assertEquals(4, multiElementList.getSize());
        assertEquals(Arrays.asList(2, 3, 4, 5), multiElementList.getValues());
    }

    @Test
    public void backNodeCanBeRemoved() {
        multiElementList.removeBack();
        assertEquals(4, multiElementList.getSize());
        assertEquals(Arrays.asList(1, 2, 3, 4), multiElementList.getValues());
    }

    @Test
    public void removeFrontNodeFromASingletonList() {
        singletonList.removeFront();
        assertEquals(0, singletonList.getSize());
    }

    @Test
    public void removeBackNodeFromASingletonList() {
        singletonList.removeBack();
        assertEquals(0, singletonList.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void frontNodeRemovalOfEmptyListThrows() {
        emptyList.removeBack();
    }

    @Test(expected = IllegalArgumentException.class)
    public void backNodeRemovalOfEmptyListThrows() {
        emptyList.removeFront();
    }

    @Test
    public void nthNodeCanBeRemoved() {
        multiElementList.removeNode(2);
        assertEquals(4, multiElementList.getSize());
        assertEquals(Arrays.asList(1, 2, 4, 5), multiElementList.getValues());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidRemovalRequestThrowsNegativeArgument() {
        multiElementList.removeNode(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidRemovalRequestThrowsExceedingArgument() {
        multiElementList.removeNode(11);
    }

    @Test
    public void valueOfNthNodeCanBeRetrived() {
        assertEquals(3, multiElementList.getNodeValue(2));
    }

    @Test
    public void valueOfBoundaryNodesCanBeRetrived() {
        assertEquals(1, multiElementList.getNodeValue(0));
        assertEquals(5, multiElementList.getNodeValue(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueRequestForIncorrectNodeThrows() {
        assertEquals(1, multiElementList.getNodeValue(11));
    }

    @Test
    public void nodeCanBeInsertedInTheMiddleOfTheList() {
        int index = 2;
        int value = 15;
        multiElementList.insertNode(index, value);
        assertEquals(Arrays.asList(1, 2, 15, 3, 4, 5), multiElementList.getValues());
    }

    @Test
    public void nodeCanBeInsertedInTheFrontOfTheList() {
        int index = 0;
        int value = 15;
        multiElementList.insertNode(index, value);
        assertEquals(Arrays.asList(15, 1, 2, 3, 4, 5), multiElementList.getValues());
    }

    @Test
    public void nodeCanBeInsertedToTheBackOfTheList() {
        int index = 4;
        int value = 15;
        multiElementList.insertNode(index, value);
        assertEquals(Arrays.asList(1, 2, 3, 4, 15, 5), multiElementList.getValues());
    }
}
