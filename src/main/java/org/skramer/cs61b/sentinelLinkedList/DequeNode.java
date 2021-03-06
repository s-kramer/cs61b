package org.skramer.cs61b.sentinelLinkedList;

/**
 * Created by skramer on 3/10/16.
 * A linked list implementation.
 * This implementation is a backing implementation that should be only used by LinkedList.
 */
class DequeNode<T> {
    private final T value;
    public DequeNode<T> next;
    public DequeNode<T> prev;

    /**
     * Generates a linked list node with value set to value.
     * The next node is set to next and the previous node is set to prev.
     *
     * @param next  the subsequent node
     * @param value the value to be associated with the node
     * @param prev  the previous node
     */
    public DequeNode(DequeNode<T> next, T value, DequeNode<T> prev) {
        this.next = next;
        this.value = value;
        this.prev = prev;
    }

    /**
     * Creates a sentinel node to be used in the linked list
     *
     * @return a sentinel node for the linked list
     */
    public static <T> DequeNode<T> createSentinelNode() {
        return new DequeNode<>(null);
    }

    private DequeNode(T value) {
        this.value = value;
        this.next = this;
        this.prev = this;
    }

    /**
     * Returns the value associated with this node
     * @return the value associated with this node
     */
    public T getValue() {
        return value;
    }
}
