package com.example.datastructure.linkedlist.SinglyLinkedList;

public class Node<T extends Comparable<T>> {
    private T data;

    // This is why linked list need more memory than arrays
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
