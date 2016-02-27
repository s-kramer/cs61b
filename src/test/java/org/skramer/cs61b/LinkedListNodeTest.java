package org.skramer.cs61b;

import org.junit.Before;
import org.junit.Test;
import org.skramer.cs61b.linkedlist.LinkedListNode;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

        assertEquals(10, node.tail.getValue());
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

    @Test
    public void theSizeOfTheListIsCalculatedIterativeApproach() {
        LinkedListNode listNode = linkedList;

        assertEquals(3, listNode.sizeIterative());
    }

    @Test
    public void theSizeOfTheListFromSpecificNodeIsCalculatedIterativeApproach() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(2, listNode.tail.sizeIterative());
    }

    @Test
    public void nthElementCanBeRequested() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(10, listNode.getElement(1));
    }

    @Test
    public void nthElementFromSpecificNodeCanBeRequested() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(15, listNode.tail.getElement(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void requestingNonExistingElementThrows() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(10, listNode.getElement(15));
    }

    @Test
    public void allNodesGetModifiedInPlace() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        LinkedListUtil.dincrList(listNode, 2);

        assertEquals(7, listNode.getElement(0));
        assertEquals(12, listNode.getElement(1));
        assertEquals(17, listNode.getElement(2));
    }

    @Test
    public void allNodesGetModifiedImmutably() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        LinkedListNode modifiedList = LinkedListUtil.incrList(listNode, 2);

        assertEquals(5, listNode.getElement(0));
        assertEquals(10, listNode.getElement(1));
        assertEquals(15, listNode.getElement(2));

        assertNotNull(modifiedList);
        assertEquals(7, modifiedList.getElement(0));
        assertEquals(12, modifiedList.getElement(1));
        assertEquals(17, modifiedList.getElement(2));
    }
}

