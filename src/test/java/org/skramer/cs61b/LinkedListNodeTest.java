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

}
