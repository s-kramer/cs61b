package org.skramer.cs61b;

import org.junit.Test;
import org.skramer.cs61b.linkedlist.LinkedListNode;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple LinkedListNode.
 */
public class LinkedListNodeTest {
    @Test
    public void nodeCanBeInsertedAfterAnotherNode() {
        LinkedListNode node = new LinkedListNode(5, null);

        node.insertAfter(10);

        assertEquals(10, node.tail.value);
    }

    @Test
    public void theSizeOfTheListIsCalculated() {
        LinkedListNode node = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        assertEquals(3, node.size());
    }

    @Test
    public void theSizeOfTheListFromSpecificNodeIsCalculated() {
        LinkedListNode node = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        assertEquals(2, node.tail.size());
    }
}
