package org.skramer.cs61b.sentinelLinkedList;

import java.util.ArrayList;
import java.util.List;

// todo: add docs
public class ArrayDeque<T> implements Deque<T> {
    private final int INITIAL_CAPACITY = 8;
    private static final int RESIZE_FACTOR = 2;
    private float DOWNSIZE_FACTOR = 0.25f;
    private static final int STARTING_BACK_INDEX = 5;
    private static final int STARTING_FRONT_INDEX = 5;

    private int capacity = INITIAL_CAPACITY;
    private int size = 0;

    // package-private for testing
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[capacity];

    private int backIndex = STARTING_BACK_INDEX;
    private int frontIndex = STARTING_FRONT_INDEX;

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
        frontIndex = getPreviousIndex(frontIndex);
        array[frontIndex] = value;
        ++size;
    }

    private int getNextIndex(int index) {
        if (index == capacity - 1) {
            return 0;
        }
        return index + 1;
    }

    private void resizeArray() {
        final int newCapacity = capacity * RESIZE_FACTOR;
        resizeArray(newCapacity);
    }

    private void resizeArray(int newCapacity) {
        T[] result = makeNewArray(newCapacity);

        final int elementCountUntilBack = getElementCountUntilBack();
        final int newFrontIndex = newCapacity - elementCountUntilBack;
        System.arraycopy(array, frontIndex, result, newFrontIndex, elementCountUntilBack);
        frontIndex = newFrontIndex;

        System.arraycopy(array, 0, result, 0, backIndex);

        array = result;
        capacity = newCapacity;
    }

    private T[] makeNewArray(int newCapacity) {
        // The suppression is safe because it's just a resize
        // and because old array is not exposed to end users
        @SuppressWarnings("unchecked")
        T[] ts = (T[]) new Object[newCapacity];
        return ts;
    }

    private int getElementCountUntilBack() {
        return capacity - frontIndex;
    }

    @Override
    public void insertBack(T value) {
        ensureCapacity();
        array[backIndex] = value;
        backIndex = getNextIndex(backIndex);
        ++size;
    }

    private void ensureCapacity() {
        // todo: add downsizing
        if (size == capacity) {
            resizeArray();
        } else if (size > INITIAL_CAPACITY && (float) size / capacity < DOWNSIZE_FACTOR) {
            downsizeArray();
        }
    }

    private void downsizeArray() {
        final int newCapacity = getMinimalNewCapacity();
        resizeArray(newCapacity);
    }

    private int getMinimalNewCapacity() {
        int result = 1;
        while (result < size) {
            result *= 2;
        }

        return result;
    }

    private int getPreviousIndex(int index) {
        if (index == 0) {
            return capacity - 1;
        }

        return index - 1;
    }

    // todo: 2 variants
    // todo: simplify this!!
    @Override
    public void insertNode(int n, T value) {
        checkIndexArgumentSanity(n);
        ensureCapacity();

        int index = getIndexOfNthNode(n);

        int srcPos = index;
        int destPos = index + 1;

        int length = size - n;
        int lengthUntilBack = length;
        int lengthFromFront = 0;

        if (destPos + length > capacity) {
            lengthUntilBack = capacity - destPos;
            lengthFromFront = length - lengthUntilBack;
        }

        // move the front of the array in necessary
        if (lengthFromFront > 0) {
            System.arraycopy(array, 0, array, 1, lengthFromFront);
            array[0] = array[capacity - 1];
        }

        // move the back of the array
        System.arraycopy(array, srcPos, array, destPos, lengthUntilBack);
        array[index] = value;

        backIndex = getNextIndex(backIndex);
        ++size;
    }

    @Override
    public List<T> getValues() {
        List<T> result = new ArrayList<>(getSize());
        int index = frontIndex;
        for (int i = 0; i < size; i++) {
            result.add(array[index]);
            index = getNextIndex(index);
        }

        return result;
    }

    @Override
    public T getNodeValue(int n) {
        checkIndexArgumentSanity(n);
        int index = getIndexOfNthNode(n);
        return array[index];
    }

    private int getIndexOfNthNode(int n) {
        return (frontIndex + n) % capacity;
    }

    private void checkIndexArgumentSanity(int n) {
        if (n >= size || n < 0) {
            throw new IllegalArgumentException(String.format("%d node requested but list is only %d long", n, size));
        }
    }

    @Override
    public void removeFront() {
        checkSizeSanity();

        array[frontIndex] = null;
        frontIndex = getNextIndex(frontIndex);
        --size;

        ensureCapacity();
    }

    @Override
    public void removeBack() {
        checkSizeSanity();
        backIndex = getPreviousIndex(backIndex);
        array[backIndex] = null;
        --size;

        ensureCapacity();
    }

    private void checkSizeSanity() {
        if (size == 0) {
            throw new IllegalArgumentException("Remove request on empty list");
        }
    }

    // todo: simplify this
    @Override
    public void removeNode(int n) {
        checkIndexArgumentSanity(n);
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

        backIndex = getPreviousIndex(backIndex);
        --size;

        ensureCapacity();
    }
}
