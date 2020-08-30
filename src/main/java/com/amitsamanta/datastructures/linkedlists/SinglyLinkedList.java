package com.amitsamanta.datastructures.linkedlists;

public class SinglyLinkedList<T> {
    private int size;
    private Node<T> head;

    public SinglyLinkedList() {
        size = 0;
        head = null;
    }

    public void add(T element) {
        addAtLast(element);
    }

    public void insert(T element, int position) {
        int count = size();

        if (position > count) {
            throw new IllegalArgumentException("Position can't be greater than count of elements contained in the list.");
        }

        if (position == 0) {
            addAtBeg(element);
        }

        addAtPos(element, position);
    }

    public boolean remove(T element) {

        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        } else {
            Node<T> current = head;
            Node<T> previous = head;

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
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        return false;
    }

    // Check if a value is contained in the Linked List
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        } else {
            Node<T> current = head;
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
    private void addAtBeg(T element) {
        if (isEmpty()) {
            head = new Node<T>(element, null);
        } else {
            Node<T> current = head;
            head = new Node<T>(element, current);
        }

        this.size++;
    }

    // Add a node to the end of the list
    private void addAtLast(T element) {
        if (isEmpty()) {
            head = new Node<T>(element, null);
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(element, null));
        }

        this.size++;
    }

    // Add a node at the given position in the list
    private void addAtPos(T element, int position) {
        if (isEmpty()) {
            head = new Node<T>(element, null);
        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(element, current.getNext());
            current.setNext(newNode);
        }

        this.size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData() + ", ");
            current = current.getNext();
        }
        sb.append(" ]");

        return sb.toString();
    }
}