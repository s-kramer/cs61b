package org.skramer.cs61b.sentinelLinkedList;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by skramer on 3/10/16.
 * Unit tests for LinkedList - the linked list implementation with a sentinel node
 */
public abstract class AbstractDequeTest {

    private Deque<Integer> emptyIntList;
    private Deque<Integer> singletonIntList;
    private Deque<Integer> multiElementIntList;

    private Deque<String> multiElementStringList;

    public abstract <T> Deque<T> makeInstance();

    public abstract <T> Deque<T> makeInstance(T param);

    public abstract <T> Deque<T> makeInstance(List<T> params);

    @Before
    public void setUp() throws Exception {
        emptyIntList = makeInstance();
        singletonIntList = makeInstance(5);
        multiElementIntList = makeInstance(Arrays.asList(1, 2, 3, 4, 5));

        multiElementStringList = makeInstance(Arrays.asList("S", "T", "R", "I", "N", "G"));
    }

    @Test
    public void EmptyListCreationIsPossible() {
        Deque<Integer> list = makeInstance();
        assertEquals(0, list.getSize());
    }

    @Test
    public void SingleNodeCreation() {
        Deque<Integer> list = makeInstance(5);
        assertEquals(1, list.getSize());
    }

    @Test
    public void nodesCanBeAddedToTheFrontOfTheList() {
        emptyIntList.insertFront(5);
        assertEquals(1, emptyIntList.getSize());
        assertEquals(Collections.singletonList(5), emptyIntList.getValues());

        emptyIntList.insertFront(10);
        assertEquals(2, emptyIntList.getSize());
        assertEquals(Arrays.asList(10, 5), emptyIntList.getValues());
    }

    @Test
    public void nodesCanBeAddedToTheBackOfTheList() {
        emptyIntList.insertBack(5);
        assertEquals(1, emptyIntList.getSize());
        assertEquals(Collections.singletonList(5), emptyIntList.getValues());

        emptyIntList.insertBack(10);
        assertEquals(2, emptyIntList.getSize());
        assertEquals(Arrays.asList(5, 10), emptyIntList.getValues());
    }

    @Test
    public void listWithMultipleNodesCanBeCreatedAtOnce() {
        Deque<Integer> multiElementList = makeInstance(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, multiElementList.getSize());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), multiElementList.getValues());
    }

    @Test
    public void frontNodeCanBeRemoved() {
        multiElementIntList.removeFront();
        assertEquals(4, multiElementIntList.getSize());
        assertEquals(Arrays.asList(2, 3, 4, 5), multiElementIntList.getValues());
    }

    @Test
    public void backNodeCanBeRemoved() {
        multiElementIntList.removeBack();
        assertEquals(4, multiElementIntList.getSize());
        assertEquals(Arrays.asList(1, 2, 3, 4), multiElementIntList.getValues());
    }

    @Test
    public void removeFrontNodeFromASingletonList() {
        singletonIntList.removeFront();
        assertEquals(0, singletonIntList.getSize());
    }

    @Test
    public void removeBackNodeFromASingletonList() {
        singletonIntList.removeBack();
        assertEquals(0, singletonIntList.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void frontNodeRemovalOfEmptyListThrows() {
        emptyIntList.removeFront();
    }

    @Test(expected = IllegalArgumentException.class)
    public void backNodeRemovalOfEmptyListThrows() {
        emptyIntList.removeBack();
    }

    @Test
    public void nthNodeCanBeRemoved() {
        multiElementIntList.removeNode(2);
        assertEquals(4, multiElementIntList.getSize());
        assertEquals(Arrays.asList(1, 2, 4, 5), multiElementIntList.getValues());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidRemovalRequestThrowsNegativeArgument() {
        multiElementIntList.removeNode(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidRemovalRequestThrowsExceedingArgument() {
        multiElementIntList.removeNode(11);
    }

    @Test
    public void valueOfNthNodeCanBeRetrieved() {
        assertEquals(3, (int) multiElementIntList.getNodeValue(2));
    }

    @Test
    public void valueOfBoundaryNodesCanBeRetrieved() {
        assertEquals(1, (int) multiElementIntList.getNodeValue(0));
        assertEquals(5, (int) multiElementIntList.getNodeValue(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueRequestForIncorrectNodeThrows() {
        assertEquals(1, (int) multiElementIntList.getNodeValue(11));
    }

    @Test
    public void nodeCanBeInsertedInTheMiddleOfTheList() {
        int index = 2;
        int value = 15;
        multiElementIntList.insertNode(index, value);
        assertEquals(Arrays.asList(1, 2, 15, 3, 4, 5), multiElementIntList.getValues());
    }

    @Test
    public void nodeCanBeInsertedInTheFrontOfTheList() {
        int index = 0;
        int value = 15;
        multiElementIntList.insertNode(index, value);
        assertEquals(Arrays.asList(15, 1, 2, 3, 4, 5), multiElementIntList.getValues());
    }

    @Test
    public void nodeCanBeInsertedToTheBackOfTheList() {
        int index = 4;
        int value = 15;
        multiElementIntList.insertNode(index, value);
        assertEquals(Arrays.asList(1, 2, 3, 4, 15, 5), multiElementIntList.getValues());
    }

    @Test
    public void stringListCanBeOperatedOn() {
        assertEquals(Arrays.asList("S", "T", "R", "I", "N", "G"), multiElementStringList.getValues());

        multiElementStringList.removeFront();
        assertEquals(5, multiElementStringList.getSize());
        assertEquals(Arrays.asList("T", "R", "I", "N", "G"), multiElementStringList.getValues());

        multiElementStringList.removeBack();
        assertEquals(4, multiElementStringList.getSize());
        assertEquals(Arrays.asList("T", "R", "I", "N"), multiElementStringList.getValues());

        multiElementStringList.removeNode(2);
        assertEquals(3, multiElementStringList.getSize());
        assertEquals(Arrays.asList("T", "R", "N"), multiElementStringList.getValues());

        multiElementStringList.insertFront("A");
        assertEquals(4, multiElementStringList.getSize());
        assertEquals(Arrays.asList("A", "T", "R", "N"), multiElementStringList.getValues());

        multiElementStringList.insertBack("Z");
        assertEquals(5, multiElementStringList.getSize());
        assertEquals(Arrays.asList("A", "T", "R", "N", "Z"), multiElementStringList.getValues());

        multiElementStringList.insertNode(3, "K");
        assertEquals(6, multiElementStringList.getSize());
        assertEquals(Arrays.asList("A", "T", "R", "K", "N", "Z"), multiElementStringList.getValues());

        assertEquals("N", multiElementStringList.getNodeValue(4));
        assertEquals(6, multiElementStringList.getSize());

        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        assertEquals(0, multiElementStringList.getSize());

        multiElementStringList.insertBack("Z");
        multiElementStringList.insertBack("Z");
        multiElementStringList.insertBack("Z");
        multiElementStringList.insertBack("Z");
        multiElementStringList.insertBack("Z");
        multiElementStringList.insertBack("Z");
        assertEquals(6, multiElementStringList.getSize());

        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        multiElementStringList.removeFront();
        assertEquals(0, multiElementStringList.getSize());

        multiElementStringList.insertFront("Z");
        multiElementStringList.insertFront("Z");
        multiElementStringList.insertFront("Z");
        multiElementStringList.insertFront("Z");
        multiElementStringList.insertFront("Z");
        multiElementStringList.insertFront("Z");
        assertEquals(6, multiElementStringList.getSize());

        multiElementStringList.removeBack();
        multiElementStringList.removeBack();
        multiElementStringList.removeBack();
        multiElementStringList.removeBack();
        multiElementStringList.removeBack();
        multiElementStringList.removeBack();
        assertEquals(0, multiElementStringList.getSize());
    }

}
