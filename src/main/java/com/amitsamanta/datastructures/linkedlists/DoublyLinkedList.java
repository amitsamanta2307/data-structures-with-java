package com.amitsamanta.datastructures.linkedlists;

public class DoublyLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the beginning of this linked list
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.setPrev(new Node<>(element, null, head));
            head = head.getPrev();
        }

        this.size++;
    }

    // Add an element to the end of the linked list
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.setNext(new Node<>(element, tail, null));
            tail = tail.getNext();
        }

        this.size++;
    }
}
