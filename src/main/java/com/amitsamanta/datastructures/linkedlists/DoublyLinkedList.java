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

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.setPrev(new Node<>(element, null, head));
            head = head.getPrev();
        }

        this.size++;
    }

    // Add an element to the end of the linked list, O(1)
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.setNext(new Node<>(element, tail, null));
            tail = tail.getNext();
        }

        this.size++;
    }

    // Remove the first value at the head of the linked list, O(1)
    public boolean removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        head = head.getNext();
        --size;

        if (isEmpty())
            tail = null;
        else
            head.setPrev(null);

        return true;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public boolean removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        tail = tail.getPrev();
        --size;

        if (isEmpty())
            head = null;
        else
            tail.setNext(null);

        return true;
    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object element) {
        Node<T> current = head;

        // Support searching for null
        if (element == null) {
            for (current = head; current != null; current = current.getNext()) {
                if (current.getData() == null) {
                    remove(current);
                    return true;
                }
            }
        } else {
            for (current = head; current != null; current = current.getNext()) {
                if (element.equals(current.getData())) {
                    remove(current);
                    return true;
                }
            }
        }

        return false;
    }

    // Remove a node at a particular index, O(n)
    public boolean removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Can't be negative, or greater than the elements in list");
        }

        int i;
        Node<T> current;

        // Search from the front of the list
        if (index < size / 2) {
            for (i = 0, current = head; i != index; i++) {
                current = current.getNext();
            }
        } else {
            for (i = size - 1, current = tail; i != index; i--) {
                current = current.getPrev();
            }
        }

        return remove(current);
    }

    // Remove an arbitrary node from the linked list, O(1)
    protected boolean remove(Node<T> node) {
        // If the node to remove is somewhere either at the
        // head or the tail handle those independently
        if (node.getPrev() == null) return removeFirst();
        if (node.getNext() == null) return removeLast();

        // Make the pointers of adjacent nodes skip over 'node'
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());

        // Memory cleanup
        node.setData(null);
        node.setNext(null);
        node.setPrev(null);
        node = null;

        --size;

        return true;
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
