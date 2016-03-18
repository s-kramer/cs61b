package org.skramer.cs61b.sentinelLinkedList;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    private static final int RESIZE_FACTOR = 2;
    private static final int STARTING_BACK_INDEX = 5;
    private static final int STARTING_FRONT_INDEX = 5;

    int capacity = 8;
    int size = 0;

    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[capacity];

    int backIndex = STARTING_BACK_INDEX;
    int frontIndex = STARTING_FRONT_INDEX;

    public ArrayDeque() {
    }

    public ArrayDeque(T param) {
        insertBack(param);
    }

    public ArrayDeque(List<T> params) {
        params.forEach(this::insertBack);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insertFront(T value) {
        ensureCapacity();
        frontIndex = getPreviousFront(frontIndex);
        array[frontIndex] = value;
        ++size;
    }

    private int getNextBack(int index) {
        if (index == capacity - 1) {
            return 0;
        }
        return index + 1;
    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        T[] result = (T[]) new Object[capacity * RESIZE_FACTOR];
        System.arraycopy(array, 0, result, 0, array.length);
    }

    @Override
    public void insertBack(T value) {
        ensureCapacity();
        array[backIndex] = value;
        backIndex = getNextBack(backIndex);
        ++size;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            resizeArray();
        }
    }

    private int getPreviousFront(int index) {
        if (index == 0) {
            return capacity - 1;
        }

        return index - 1;
    }

    @Override
    public void insertNode(int n, T value) {
        ensureCapacity();
        // todo: fill this
        ++size;
    }

    @Override
    public List<T> getValues() {
        List<T> result = new ArrayList<>(getSize());
        int index = frontIndex;
        for (int i = 0; i < size; i++) {
            result.add(array[index]);
            index = getNextBack(index);
        }

        return result;
    }

    @Override
    public T getNodeValue(int n) {
        int index = getIndexOfNthNode(n);
        return array[index];
    }

    private int getIndexOfNthNode(int n) {
        return (frontIndex + n) % capacity;
    }

    @Override
    public void removeFront() {
        if (size == 0) {
            throw new IllegalArgumentException("Remove request on empty list");
        }
        array[frontIndex] = null;
        ++frontIndex;
        --size;
    }

    @Override
    public void removeBack() {
        if (size == 0) {
            throw new IllegalArgumentException("Remove request on empty list");
        }
        array[backIndex] = null;
        --backIndex;
        --size;
    }

    @Override
    public void removeNode(int n) {
        int index = getIndexOfNthNode(n);

        int srcPos = index + 1;
        int destPos = index;

        int length = size - 1 - n;
        int lengthUntilBack = length;
        int lengthFromFront = 0;

        if (srcPos + length > capacity) {
            lengthUntilBack = capacity - srcPos;
            lengthFromFront = length - lengthUntilBack;
        }

        // move the back of the array
        System.arraycopy(array, srcPos, array, destPos, lengthUntilBack);
        array[index + lengthUntilBack] = array[0];

        // move the front of the array in necessary
        if (lengthFromFront > 0) {
            System.arraycopy(array, 1, array, 0, lengthFromFront);
        }

        // nullify the last node of the list
        array[getIndexOfNthNode(size - 1)] = null;

        --size;
    }
}
