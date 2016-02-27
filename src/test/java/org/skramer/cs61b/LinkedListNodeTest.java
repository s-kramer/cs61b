package org.skramer.cs61b;

import org.junit.Before;
import org.junit.Test;
import org.skramer.cs61b.linkedlist.LinkedListNode;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple LinkedListNode.
 */
public class LinkedListNodeTest {

    private LinkedListNode linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));
    }

    @Test
    public void nodeCanBeInsertedAfterAnotherNode() {
        LinkedListNode node = new LinkedListNode(5, null);

        node.insertAfter(10);

        assertEquals(10, node.tail.value);
    }

    @Test
    public void theSizeOfTheListIsCalculated() {
        LinkedListNode listNode = linkedList;

        assertEquals(3, listNode.size());
    }

    @Test
    public void theSizeOfTheListFromSpecificNodeIsCalculated() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(2, listNode.tail.size());
    }
}
