package org.skramer.cs61b.sentinelLinkedList;

import java.util.List;

/**
 * Created by skramer on 3/16/16.
 * Specialization of AbstractDequeTest. This implementation uses the DLinkedDeque to implement the list.
 */
public class DLinkedDequeTest extends AbstractDequeTest {
    @Override
    public <T> Deque<T> makeInstance() {
        return new DLinkedDeque<>();
    }

    @Override
    public <T> Deque<T> makeInstance(T param) {
        return new DLinkedDeque<>(param);
    }

    @Override
    public <T> Deque<T> makeInstance(List<T> params) {
        return new DLinkedDeque<>(params);

    }
}
