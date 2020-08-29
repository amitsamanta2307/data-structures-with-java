package com.amitsamanta.datastructures.linkedlists;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class SinglyLinkedListTest {

    SinglyLinkedList sut;

    @Before
    public void setup() {
        sut = new SinglyLinkedList();
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
        sut.insert(3, 0);

        assertTrue("", sut.contains(3));
    }

    @Test
    public void testContainsElement() {
        sut.add(1);
        sut.add(2);

        assertTrue(sut.contains(1));
        assertFalse(sut.contains(5));
    }
}