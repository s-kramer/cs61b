package org.skramer.cs61b;

import org.junit.Before;
import org.junit.Test;
import org.skramer.cs61b.linkedlist.LinkedListNode;

import java.util.Arrays;
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
        LinkedListNode node = new LinkedListNode(5, new LinkedListNode(15, null));

        node.insertAfter(10);

        assertEquals(3, node.size());
        assertEquals(5, node.getElement(0));
        assertEquals(10, node.getElement(1));
        assertEquals(15, node.getElement(2));
    }

    @Test
    public void theSizeOfTheListIsCalculated() {
        LinkedListNode listNode = linkedList;

        assertEquals(3, listNode.sizeRecursive());
    }

    @Test
    public void theSizeOfTheListIsCalculatedIterativeApproach() {
        LinkedListNode listNode = linkedList;

        assertEquals(3, listNode.size());
    }

    @Test
    public void nthElementCanBeRequested() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(10, listNode.getElement(1));
    }

    @Test
    public void nthElementCanBeRequestedRecursive() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(5, listNode.getElementRecursive(0));
        assertEquals(10, listNode.getElementRecursive(1));
        assertEquals(15, listNode.getElementRecursive(2));
    }

    @Test
    public void nthElementFromSpecificNodeCanBeRequested() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(15, listNode.getElement(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void requestingNonExistingElementThrowsRecursive() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(10, listNode.getElement(15));
    }

    @Test(expected = NoSuchElementException.class)
    public void requestingNonExistingElementThrows() {
        LinkedListNode listNode = this.linkedList;

        assertEquals(10, listNode.getElement(15));
    }

    @Test
    public void allNodesGetModifiedImmutably() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        LinkedListNode modifiedList = LinkedListNode.incrListIterative(listNode, 2);

        assertEquals(5, listNode.getElement(0));
        assertEquals(10, listNode.getElement(1));
        assertEquals(15, listNode.getElement(2));

        assertNotNull(modifiedList);
        assertEquals(7, modifiedList.getElement(0));
        assertEquals(12, modifiedList.getElement(1));
        assertEquals(17, modifiedList.getElement(2));
    }

    @Test
    public void allNodesGetModifiedImmutablyRecursive() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        LinkedListNode modifiedList = LinkedListNode.incrListRecursive(listNode, 2);

        assertEquals(5, listNode.getElement(0));
        assertEquals(10, listNode.getElement(1));
        assertEquals(15, listNode.getElement(2));

        assertNotNull(modifiedList);
        assertEquals(7, modifiedList.getElement(0));
        assertEquals(12, modifiedList.getElement(1));
        assertEquals(17, modifiedList.getElement(2));
    }

    @Test
    public void toStringGeneratesSpaceSeparatedValues() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));
        String expectation = String.join(" ", Arrays.asList("5", "10", "15"));

        assertEquals(expectation, listNode.toString());
    }

    @Test
    public void listCanBeReversed() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        LinkedListNode reversed = LinkedListNode.reverseRecursive(listNode);

        assertEquals(15, reversed.getElement(0));
        assertEquals(10, reversed.getElement(1));
        assertEquals(5, reversed.getElement(2));
    }

    @Test
    public void listCanBeReversedIterative() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));

        LinkedListNode reversed = LinkedListNode.reverse(listNode);

        assertEquals(15, reversed.getElement(0));
        assertEquals(10, reversed.getElement(1));
        assertEquals(5, reversed.getElement(2));
    }

    @Test
    public void generatesReversedStringDescriptorList() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));
        String expectation = String.join(" ", Arrays.asList("15", "10", "5"));

        assertEquals(expectation, listNode.getReversedStringRepresentation());
    }

    @Test
    public void listsGetContatenatedInAMutableWay() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));
        LinkedListNode listNode2 = new LinkedListNode(6, new LinkedListNode(11, new LinkedListNode(16, null)));

        LinkedListNode result = LinkedListNode.dcatenate(listNode, listNode2);

        assertEquals(5, result.getElement(0));
        assertEquals(10, result.getElement(1));
        assertEquals(15, result.getElement(2));
        assertEquals(6, result.getElement(3));
        assertEquals(11, result.getElement(4));
        assertEquals(16, result.getElement(5));
    }

    @Test
    public void listsGetContatenatedInAnImmutableWayRecursive() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));
        LinkedListNode listNode2 = new LinkedListNode(6, new LinkedListNode(11, new LinkedListNode(16, null)));

        LinkedListNode result = LinkedListNode.catenateRecursive(listNode, listNode2);

        assertEquals(3, listNode.sizeRecursive());
        assertEquals(3, listNode2.sizeRecursive());

        assertEquals(5, result.getElement(0));
        assertEquals(10, result.getElement(1));
        assertEquals(15, result.getElement(2));
        assertEquals(6, result.getElement(3));
        assertEquals(11, result.getElement(4));
        assertEquals(16, result.getElement(5));
    }

    @Test
    public void listsGetContatenatedInAnImmutableWayIterative() {
        LinkedListNode listNode = new LinkedListNode(5, new LinkedListNode(10, new LinkedListNode(15, null)));
        LinkedListNode listNode2 = new LinkedListNode(6, new LinkedListNode(11, new LinkedListNode(16, null)));

        LinkedListNode result = LinkedListNode.catenateIterative(listNode, listNode2);

        assertEquals(3, listNode.sizeRecursive());
        assertEquals(5, listNode.getElement(0));
        assertEquals(10, listNode.getElement(1));
        assertEquals(15, listNode.getElement(2));

        assertEquals(3, listNode2.sizeRecursive());
        assertEquals(6, listNode2.getElement(0));
        assertEquals(11, listNode2.getElement(1));
        assertEquals(16, listNode2.getElement(2));

        assertEquals(5, result.getElement(0));
        assertEquals(10, result.getElement(1));
        assertEquals(15, result.getElement(2));
        assertEquals(6, result.getElement(3));
        assertEquals(11, result.getElement(4));
        assertEquals(16, result.getElement(5));
    }

    @Test
    public void elementsCanBeInsertedInFrontOfTheList() {
        LinkedListNode listNode = linkedList;

        LinkedListNode front = LinkedListNode.insertFront(linkedList, new LinkedListNode(0, null));

        assertEquals(4, front.size());
        assertEquals(0, front.getElement(0));
        assertEquals(5, front.getElement(1));
        assertEquals(10, front.getElement(2));
        assertEquals(15, front.getElement(3));
    }

    @Test
    public void elementsCanBeInsertedToBeBackOfTheList() {
        LinkedListNode listNode = linkedList;

        LinkedListNode front = LinkedListNode.insertBack(linkedList, new LinkedListNode(0, null));

        assertEquals(4, front.size());
        assertEquals(5, front.getElement(0));
        assertEquals(10, front.getElement(1));
        assertEquals(15, front.getElement(2));
        assertEquals(0, front.getElement(3));
    }
}

