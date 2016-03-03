package org.skramer.cs61b.linkedlist;

import java.util.NoSuchElementException;

/**
 * A linked list node
 */
public class LinkedListNode {
    private int value;
    private LinkedListNode tail;

    /**
     * Increments all the nodes of @code listNode by @code modification in a mutable (destructive) way.
     * The modification is made in place, that is listNode will be modified after this method returns.
     * This method uses iterative approach.
     *
     * @param listNode     the head of the linked list that should be modified
     * @param modification the integer value that should be added to all the nodes
     */
    public static void dincrListIterative(LinkedListNode listNode, int modification) {
        LinkedListNode current = listNode;

        while (current != null) {
            current.setValue(current.getValue() + modification);
            current = current.tail;
        }
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a mutable way.
     * The modification is made in place, that is @code listNode will be modified after this method returns.
     * This method uses recursive approach.
     *
     * @param listNode     the list that should be modified
     * @param modification the value that should be added to all the nodes of the list
     */
    public static void dincrListRecursive(LinkedListNode listNode, int modification) {
        if (listNode == null) {
            return;
        }

        listNode.setValue(listNode.getValue() + modification);
        dincrListRecursive(listNode.tail, modification);
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a immutable way.
     * The result list is independent of @code listNode.
     * This method uses iterative approach.
     *
     * @param listNode     the head of the linked list that should be copied and modified
     * @param modification the integer value that should be added to all the nodes
     */
    public static LinkedListNode incrListIterative(LinkedListNode listNode, int modification) {
        LinkedListNode result = new LinkedListNode(listNode.getValue() + modification, null);

        LinkedListNode current_source = listNode.tail;
        LinkedListNode current_result = result;

        while (current_source != null) {
            current_result.tail = new LinkedListNode(current_source.getValue() + modification, null);
            current_result = current_result.tail;
            current_source = current_source.tail;
        }

        return result;
    }

    /**
     * Increments all the nodes of @code listNode by @code modification in a immutable way.
     * The result list is independent of @code listNode.
     * This method uses recursive approach.
     *
     * @param listNode     the head of the linked list that should be copied and modified
     * @param modification the integer value that should be added to all the nodes
     */
    public static LinkedListNode incrListRecursive(LinkedListNode listNode, int modification) {
        if (listNode.tail == null) {
            return new LinkedListNode(listNode.getValue() + modification, null);
        }

        return new LinkedListNode(listNode.getValue() + modification,
                                  incrListRecursive(listNode.tail, modification));
    }

    /**
     * Reverses the list for which the @code head is the head.
     * This method uses iterative approach
     *
     * @param head the head of the list that should be reversed
     * @return the head of the reversed list
     */
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode previous = null;
        LinkedListNode next;
        while (head != null) {
            next = head.tail;

            head.tail = previous;

            previous = head;
            head = next;
        }

        return previous;
    }

    /**
     * Reverses the linked list of which the @code node is the head. The reversion is made in place.
     * The list provided inside @code node will be modified.
     *
     * @param node the head of the list to be reversed
     * @return the head of the reversed list
     */
    public static LinkedListNode reverseRecursive(LinkedListNode node) {
        LinkedListNode initialTail = node;
        initialTail = moveToTheEndOfTheList(initialTail);

        reverseImpl(node);

        return initialTail;
    }

    private static LinkedListNode reverseImpl(LinkedListNode head) {
        if (head.tail != null) {
            LinkedListNode reverse = reverseImpl(head.tail);
            reverse.tail = head;
            head.tail = null;

            return head;
        }
        return head;
    }

    /**
     * Concatenates @code lhs and @code rhs using an iterative approach. This is a mutable version.
     *
     * @param lhs linked list to be concatenated. Rhs will be appended to this list
     * @param rhs linked list to be concatenated. This list will be appended to @code lhs
     * @return the head of a list that is the concatenation of @code lhs and @code rhs
     */
    public static LinkedListNode dcatenate(LinkedListNode lhs, LinkedListNode rhs) {
        LinkedListNode lhsTail = lhs;
        lhsTail = moveToTheEndOfTheList(lhsTail);

        lhsTail.tail = rhs;

        return lhs;
    }

    /**
     * Concatenates @code lhs and @code rhs using the recursive approach. This is an immutable version.
     *
     * @param lhs linked list to be concatenated. Rhs will be appended to this list
     * @param rhs linked list to be concatenated. This list will be appended to @code lhs
     * @return the head of a list that is the concatenation of @code lhs and @code rhs
     */
    public static LinkedListNode catenateRecursive(LinkedListNode lhs, LinkedListNode rhs) {
        if (lhs != null) {
            return new LinkedListNode(lhs.getValue(), catenateRecursive(lhs.tail, rhs));
        }

        if (rhs.tail != null) {
            return new LinkedListNode(rhs.getValue(), catenateRecursive(null, rhs.tail));
        }

        return new LinkedListNode(rhs.getValue(), null);
    }

    /**
     * Concatenates @code lhs and @code rhs in a immutable way.
     *
     * @param lhs the head of the LinkedList to be concatenated.
     * @param rhs the head of the second LinkedList to be concatenated.
     * @return the head of the concatenated list
     */
    public static LinkedListNode catenateIterative(LinkedListNode lhs, LinkedListNode rhs) {
        LinkedListNode current = new LinkedListNode(lhs.getValue(), null);
        LinkedListNode head = current;
        for (lhs = lhs.tail; lhs != null; current = current.tail, lhs = lhs.tail) {
            current.tail = new LinkedListNode(lhs.getValue(), null);
        }

        for (; rhs != null; current = current.tail, rhs = rhs.tail) {
            current.tail = new LinkedListNode(rhs.getValue(), null);
        }

        return head;
    }

    /**
     * Inserts the @code element to the front of the @code linkedList.
     * The @code linkedList becomes the tail of the element.
     *
     * @param linkedList the linked list that should be prepended with @code element
     * @param element    the LinkedListNode that should be the new head of the list
     * @return the head of the modified list
     */
    public static LinkedListNode insertFront(LinkedListNode linkedList, LinkedListNode element) {
        element.tail = linkedList;
        return element;
    }

    /**
     * Inserts the @code element to the back of the @code linkedList.
     *
     * @param linkedList the linked list that should be extended with @code element
     * @param element    the LinkedListNode that should be the new tail of the list
     * @return the head of the modified list
     */
    public static LinkedListNode insertBack(LinkedListNode linkedList, LinkedListNode element) {
        LinkedListNode current = linkedList;
        current = moveToTheEndOfTheList(current);

        current.tail = element;

        return linkedList;
    }

    private static LinkedListNode moveToTheEndOfTheList(LinkedListNode current) {
        while (current.tail != null) {
            current = current.tail;
        }
        return current;
    }

    /**
     * Constructor
     *
     * @param value The value associated with this node
     * @param next  Points to the tail node in the linked list. Should be null if this is the last node.
     */
    public LinkedListNode(int value, LinkedListNode next) {
        this.tail = next;
        this.value = value;
    }

    /**
     * Returns the value associated with this node
     *
     * @return the value associated wit this node
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value associated with this node
     * This is required only because of the dincrList methods. Otherwise LinkedListNode can be made immutable
     */
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (tail == null) {
            return Integer.toString(value);
        }

        return value + " " + tail.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListNode node = (LinkedListNode) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    // todo: find, deleteNth

    /**
     * Inserts a new LinkedListNode after this one
     *
     * @param value The value of the node that will be added after current node
     */
    public void insertAfter(int value) {
        tail = new LinkedListNode(value, tail);
    }

    /**
     * Counts the size of the list from the current node to the terminator node.
     * The list terminator is considered to be a null object.
     * This method uses iterative approach.
     *
     * @return the number of nodes from the current node to the terminator node (null object).
     */
    public int size() {
        LinkedListNode current = this;
        int size = 0;
        while (current != null) {
            size += 1;
            current = current.tail;
        }

        return size;
    }

    /**
     * Returns the size of the list from the current node.
     * The list terminator is considered to be a null object.
     * This method uses recursive approach.
     *
     * @return the number of nodes from the current node to the terminator node (null object).
     */
    public int sizeRecursive() {
        if (tail == null) {
            return 1;
        }

        return 1 + tail.sizeRecursive();
    }

    /**
     * Finds the n-th subsequent element counting from the current node and returns its value.
     *
     * @param i the index of the node that should be returned.
     * @return the value associated with the i-th node
     * @throws NoSuchElementException if requested index does not exist
     */
    public int getElement(int i) {
        LinkedListNode current = this;
        while (i > 0 && current != null) {
            i -= 1;
            current = current.tail;
        }

        if (current != null) {
            return current.value;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Finds the n-th subsequent element counting from the current node and returns its value.
     * This method uses recursive approach.
     *
     * @param i the index of the node that should be returned.
     * @return the value associated with the i-th node
     * @throws NoSuchElementException if requested index does not exist
     */
    public int getElementRecursive(int i) {
        if (i == 0) {
            return value;
        }

        if (tail == null) {
            throw new NoSuchElementException();
        }

        return tail.getElementRecursive(i - 1);
    }

    /**
     * Returns a space-separated list of values in reversed order.
     *
     * @return String with String representations of all the nodes in the list in reverse order
     */
    public String getReversedStringRepresentation() {
        return getReversedStringRepresentationImpl().toString();
    }

    private StringBuilder getReversedStringRepresentationImpl() {
        if (tail == null) {
            return new StringBuilder(Integer.toString(value));
        }

        StringBuilder representation = tail.getReversedStringRepresentationImpl();
        representation.append(" ");
        representation.append(value);

        return representation;
    }

}
