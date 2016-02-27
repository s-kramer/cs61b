package org.skramer.cs61b;

import org.junit.Assert;
import org.junit.Test;
import org.skramer.cs61b.linkedlist.LinkedList;
import org.skramer.cs61b.linkedlist.LinkedListNode;

/**
 * Unit test for simple LinkedListNode.
 */
public class LinkedListNodeTest {
    @Test
    public void firstNodeIsAdded() {
        LinkedList linkedList = new LinkedList();
        LinkedListNode node = new LinkedListNode(5, null);

        linkedList.addNode(node);

        Assert.assertEquals(node, linkedList.getHead());
    }
}
