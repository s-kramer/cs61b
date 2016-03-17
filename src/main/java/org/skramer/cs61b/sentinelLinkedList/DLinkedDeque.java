package org.skramer.cs61b.sentinelLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skramer on 3/10/16.
 * A linked list implementation.
 * This implementation ensures that getSize() operates in constant time and that operations on the back of the list
 * are performed in the same time as operations performed on the front.
 */
public class DLinkedDeque<T> implements Deque<T> {
    private DequeNode<T> sentinelNode;
    private int size;

    /**
     * Creates a new linked list using elements from an already existing list.
     * Each of the provided arguments will be used to create a subsequent node of the list.
     *
     * @param args a list of values that will be used to create subsequent linked list nodes
     */
    public DLinkedDeque(List<T> args) {
        sentinelNode = makeSentinelNode();
        args.forEach(this::insertBack);
    }

    /**
     * Creates a linked list with a single node which's value is value
     *
     * @param value the value of the first node of the newly created list
     */
    public DLinkedDeque(T value) {
        sentinelNode = makeSentinelNode();
        sentinelNode.next = new DequeNode<>(sentinelNode, value, sentinelNode);
        sentinelNode.prev = sentinelNode.next;
        size = 1;
    }

    /**
     * Creates an empty linked list
     */
    public DLinkedDeque() {
        sentinelNode = makeSentinelNode();
        size = 0;
    }

    private DequeNode<T> makeSentinelNode() {
        return DequeNode.createSentinelNode();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insertFront(T value) {
        sentinelNode.next = new DequeNode<>(getListFront(), value, sentinelNode);
        size += 1;
    }

    @Override
    public void insertBack(T value) {
        DequeNode<T> it = getLastNode();

        it.next = new DequeNode<>(sentinelNode, value, it);
        sentinelNode.prev = it.next;
        size += 1;
    }


    @Override
    public void insertNode(int n, T value) {
        DequeNode<T> previousNth = getNthNode(n);
        DequeNode<T> previousNMinus1th = previousNth.prev;

        previousNth.prev.next = new DequeNode<>(previousNth, value, previousNth.prev);
        previousNth.prev = previousNMinus1th.next;
        size += 1;
    }

    @Override
    public List<T> getValues() {
        List<T> result = new ArrayList<>(size);

        for (DequeNode<T> it = getListFront(); it != sentinelNode; it = it.next) {
            result.add(it.getValue());
        }

        return result;
    }

    @Override
    public T getNodeValue(int n) {
        return getNthNode(n).getValue();
    }

    private DequeNode<T> getLastNode() {
        return sentinelNode.prev;
    }

    private DequeNode<T> getListFront() {
        return sentinelNode.next;
    }

    @Override
    public void removeFront() {
        removeNode(0);
    }

    @Override
    public void removeBack() {
        removeNode(size - 1);
    }

    private DequeNode<T> getListBack() {
        return sentinelNode.prev;
    }

    @Override
    public void removeNode(int n) {
        DequeNode<T> ithNode = getNthNode(n);
        ithNode.prev.next = ithNode.next;
        ithNode.next.prev = ithNode.prev;
        size -= 1;
    }

    private DequeNode<T> getNthNode(int n) {
        if (n < 0 || n >= size) {
            throw new IllegalArgumentException(String.format("List element %d exceeds the size of the list which is %d",
                                                             n, size));
        }

        if (n <= size / 2) {
            return proceedForward(n);
        } else {
            final int lastIndex = size - 1;
            return proceedBackward(lastIndex - n);
        }
    }

    private DequeNode<T> proceedBackward(int i) {
        DequeNode<T> it = getListBack();
        for (; i > 0; i--) {
            it = it.prev;
        }
        return it;
    }

    private DequeNode<T> proceedForward(int i) {
        DequeNode<T> it = getListFront();
        for (int j = 0; j < i; j++) {
            it = it.next;
        }
        return it;
    }
}
