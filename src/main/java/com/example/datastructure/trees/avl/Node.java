package com.example.datastructure.trees.avl;

public class Node<T> {
    private Node<T> parentNode;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private T data;
    private int height;

    public Node(T data, Node<T> parent) {
        this.parentNode = parent;
        this.data = data;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "N[" +
                data +
                ']';
    }
}
