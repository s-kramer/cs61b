package org.skramer.cs61b.sentinelLinkedList;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

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

    @Ignore
    @Test
    @Override
    public void valueRequestForIncorrectNodeThrows() {
        super.valueRequestForIncorrectNodeThrows();
    }

    @Ignore
    @Test
    @Override
    public void frontNodeCanBeRemoved() {
        super.frontNodeCanBeRemoved();
    }

    @Ignore
    @Test
    @Override
    public void frontNodeRemovalOfEmptyListThrows() {
        super.frontNodeRemovalOfEmptyListThrows();
    }

    @Ignore
    @Test
    @Override
    public void invalidRemovalRequestThrowsExceedingArgument() {
        super.invalidRemovalRequestThrowsExceedingArgument();
    }

    @Ignore
    @Test
    @Override
    public void invalidRemovalRequestThrowsNegativeArgument() {
        super.invalidRemovalRequestThrowsNegativeArgument();
    }

    @Ignore
    @Test
    @Override
    public void nodeCanBeInsertedInTheFrontOfTheList() {
        super.nodeCanBeInsertedInTheFrontOfTheList();
    }

    @Ignore
    @Test
    @Override
    public void nodeCanBeInsertedInTheMiddleOfTheList() {
        super.nodeCanBeInsertedInTheMiddleOfTheList();
    }

    @Ignore
    @Test
    @Override
    public void nodeCanBeInsertedToTheBackOfTheList() {
        super.nodeCanBeInsertedToTheBackOfTheList();
    }

    @Ignore
    @Test
    @Override
    public void nodesCanBeAddedToTheFrontOfTheList() {
        super.nodesCanBeAddedToTheFrontOfTheList();
    }

    @Ignore
    @Test
    @Override
    public void nthNodeCanBeRemoved() {
        super.nthNodeCanBeRemoved();
    }

    @Ignore
    @Test
    @Override
    public void removeFrontNodeFromASingletonList() {
        super.removeFrontNodeFromASingletonList();
    }

    @Ignore
    @Test
    @Override
    public void stringListCanBeOperatedOn() {
        super.stringListCanBeOperatedOn();
    }
}
