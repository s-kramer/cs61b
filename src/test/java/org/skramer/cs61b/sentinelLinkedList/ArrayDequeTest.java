package org.skramer.cs61b.sentinelLinkedList;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by skramer on 3/16/16.
 * Specialization of AbstractDequeTest. This implementation uses the ArrayDeque to implement the list.
 */
public class ArrayDequeTest extends AbstractDequeTest {
    @Override
    public <T> Deque<T> makeInstance() {
        return new ArrayDeque<>();
    }

    @Override
    public <T> Deque<T> makeInstance(T param) {
        return new ArrayDeque<T>(param);
    }

    @Override
    public <T> Deque<T> makeInstance(List<T> params) {
        return new ArrayDeque<T>(params);
    }

    @Test
    public void nthNodeCanBeRemovedNoOverflow() {
        Deque<Integer> list = makeInstance(5);
        list.insertBack(6);
        list.insertBack(7);
        assertEquals(3, list.getSize());

        list.removeNode(1);

        assertEquals(2, list.getSize());
        assertEquals(Arrays.asList(5, 7), list.getValues());
    }

    @Test
    public void nthNodeCanBeRemovedBackOverflow() {
        Deque<Integer> list = makeInstance(5);
        list.insertBack(6);
        list.insertBack(7);
        list.insertBack(8);
        list.insertBack(9);
        list.insertBack(10);
        assertEquals(6, list.getSize());

        list.removeNode(1);

        assertEquals(5, list.getSize());
        assertEquals(Arrays.asList(5, 7, 8, 9, 10), list.getValues());

        list.removeNode(3);

        assertEquals(4, list.getSize());
        assertEquals(Arrays.asList(5, 7, 8, 10), list.getValues());
    }
}
