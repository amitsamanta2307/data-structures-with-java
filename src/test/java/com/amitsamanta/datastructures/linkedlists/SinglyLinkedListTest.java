package com.amitsamanta.datastructures.linkedlists;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> sut;

    @Before
    public void setup() {
        sut = new SinglyLinkedList<Integer>();
    }

    @Test
    public void testEmptyList() {
        assertTrue(sut.isEmpty());
        assertEquals(sut.size(), 0);
    }

    @Test
    public void testAddElement() {
        sut.add(1);
        assertEquals(sut.size(), 1);

        sut.add(2);
        sut.add(3);
        assertEquals(sut.size(), 3);
    }

    @Test
    public void testAddAtPostionZero() {
        sut.add(2);
        sut.add(3);
        sut.add(4);
        sut.insert(5, 2);

        assertTrue("", sut.contains(5));
    }

    @Test
    public void testContainsElement() {
        sut.add(1);
        sut.add(2);

        assertTrue(sut.contains(1));
        assertFalse(sut.contains(5));
    }
}