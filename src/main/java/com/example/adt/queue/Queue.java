package com.example.adt.queue;

public class Queue<T extends Comparable<T>> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public boolean isEmpty(){
        return this.firstNode == null;
    }

    public int size(){
        return this.count;
    }

    // O(1) Time complexity
    public void enqueue(T data){
        this.count++;

        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node(data);
        this.lastNode.setNextNode(null);
        if(isEmpty()){
            this.firstNode = this.lastNode;
        }else{
            oldLastNode.setNextNode(this.lastNode);
        }
    }

    // O(1)
    public T dequeue(){
        if(isEmpty()) return null;
        this.count--;
        Node<T> oldFirstNode = this.firstNode;
        T data = this.firstNode.getData();
        this.firstNode = firstNode.getNextNode();

        if(isEmpty()){
            this.lastNode = null;
        }else{
            this.firstNode.setNextNode(this.firstNode.getNextNode());
        }
        //Remove old reference
        oldFirstNode = null;
        return data;
    }

    public T peek() {
        if (isEmpty()) return null;
        return this.firstNode.getData();
    }
}
