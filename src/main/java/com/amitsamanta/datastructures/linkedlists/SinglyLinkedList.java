package com.amitsamanta.datastructures.linkedlists;

public class SinglyLinkedList {
    private int size;
    private Node head;

    public SinglyLinkedList() {
        size = 0;
        head = null;
    }

    public void add(int element) {
        addAtLast(element);
    }

    public void insert(int element, int position) {
        int count = size();

        if (position > count) {
            throw new IllegalArgumentException("Position can't be greater than count of elements contained in the list.");
        }

        if (position == 0) {
            addAtBeg(element);
        }

        addAtPos(element, position);
    }

    public boolean remove(int element) {

        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        } else {
            Node current = head;
            Node previous = head;

            while (current.getData() != element) {
                previous = current;
                current = current.getNext();
            }

            if (current == null)
                return false;

            previous.setNext(current.getNext());
            current.setNext(null);

            this.size--;

            return true;
        }
    }

    public boolean removeAt(int position) {
        return false;
    }

    // Check if a value is contained in the Linked List
    public boolean contains(int element) {
        if (isEmpty()) {
            return false;
        } else {
            Node current = head;
            while (current != null) {
                if (current.getData() == element) {
                    return true;
                }

                current = current.getNext();
            }
        }

        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Add a node to the begining of the list
    private void addAtBeg(int element) {
        if (isEmpty()) {
            head = new Node(element, null);
        } else {
            Node current = head;
            head = new Node(element, current);
        }

        this.size++;
    }

    // Add a node to the end of the list
    private void addAtLast(int element) {
        if (isEmpty()) {
            head = new Node(element, null);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(element, null));
        }

        this.size++;
    }

    // Add a node at the given position in the list
    private void addAtPos(int element, int position) {
        if (isEmpty()) {
            head = new Node(element, null);
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            Node newNode = new Node(element, current.getNext());
            current.setNext(newNode);
        }

        this.size++;
    }
}