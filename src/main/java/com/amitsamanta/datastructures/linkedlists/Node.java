package com.amitsamanta.datastructures.linkedlists;

public class Node {
    private int data;
    private Node next;
    private Node prev;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    // getters & setters
    public int getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int value) {
        this.data = value;
    }

    public void setPrev(Node value) {
        this.prev = value;
    }

    public void setNext(Node value) {
        this.next = value;
    }
}