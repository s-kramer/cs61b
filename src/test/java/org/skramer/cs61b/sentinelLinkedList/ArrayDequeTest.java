package org.skramer.cs61b.sentinelLinkedList;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void underlyingArrayCanBeResized() {
        List<Integer> integerList = IntStream.range(0, 20).boxed().collect(Collectors.toList());
        Deque<Integer> deque = new ArrayDeque<>(integerList);
        assertEquals(20, deque.getSize());
        assertEquals(deque.getValues(), integerList);
    }

    @Test
    public void dequeFunctionsAfterDownsizing() {
        int testElementUpperBound = 128;
        List<Integer> integerList = IntStream.range(0, testElementUpperBound).boxed().collect(Collectors.toList());
        ArrayDeque<Integer> deque = new ArrayDeque<>(integerList);

        for (int i = testElementUpperBound - 1; i >= 16; i--) {
            deque.removeNode(i);
        }

        assertThat(deque.getSize(), equalTo(16));
        assertThat(deque.getValues(), is(IntStream.range(0, 16).boxed().collect(Collectors.toList())));

        float arrayActualUsage = getArrayActualUsage(deque);
        assertThat(String.format("array usage: %f", arrayActualUsage), Float.compare(arrayActualUsage, 0.25f), greaterThanOrEqualTo(0));
    }

    private float getArrayActualUsage(ArrayDeque<?> list) {
        Object[] array = list.array;
        long count = Arrays.stream(array).filter(i -> i != null).count();
        float usageRatio = (float) count / array.length;
        return usageRatio;
    }

    @Test
    public void elementsCanBeAddedToTheFrontOfTheListWhenListFrontIndexIsAtTheBeginningOfTheArray() {
        // assumes that INITIAL_FRONT == 5
        Deque<Integer> deque = new ArrayDeque<>();
        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertFront(3);
        deque.insertFront(4);
        deque.insertFront(5);

        deque.insertNode(0, 10);
        assertThat(deque.getSize(), is(6));
        assertThat(deque.getValues(), is(Arrays.asList(10, 5, 4, 3, 2, 1)));
    }

    @Test
    public void elementsCanBeAddedToTheBackOfTheListWhenListBackIndexIsAtTheEndOfTheArray() {
        // assumes that INITIAL_BACK == 5
        Deque<Integer> deque = new ArrayDeque<>();
        deque.insertBack(1);
        deque.insertBack(2);
        deque.insertBack(3);

        deque.insertNode(2, 10);
        assertThat(deque.getSize(), is(4));
        assertThat(deque.getValues(), is(Arrays.asList(1, 2, 10, 3)));
    }
}
