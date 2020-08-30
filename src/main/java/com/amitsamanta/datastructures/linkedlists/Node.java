package com.amitsamanta.datastructures.linkedlists;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    // getters & setters
    public T getData() {
        return data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T value) {
        this.data = value;
    }

    public void setPrev(Node<T> value) {
        this.prev = value;
    }

    public void setNext(Node<T> value) {
        this.next = value;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}