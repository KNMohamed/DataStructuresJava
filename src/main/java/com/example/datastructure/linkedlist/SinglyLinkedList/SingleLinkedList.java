package com.example.datastructure.linkedlist.SinglyLinkedList;

import com.example.datastructure.linkedlist.List;

public class SingleLinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> rootNode;
    private int numberOfNodes;

    @Override
    public void insert(T data) {
        if(rootNode == null){
            rootNode = new Node<>(data);
        }else{
            insertBeggining(data);
        }
    }


    @Override
    public void remove(T data) {
        if(rootNode == null) return;
        if(rootNode.getData().compareTo(data) == 0){
            rootNode = rootNode.getNextNode();
            numberOfNodes--;
        }else{
            remove(data,rootNode, rootNode.getNextNode());
        }
    }

    private void remove(T data, Node<T> prevNode, Node<T> actualNode) {
        // we have to find the node we want to remove
        while(actualNode != null){
            // this is the node we want to remove
            if(actualNode.getData().compareTo(data) == 0){
                // update the size of the list
                numberOfNodes--;

                //update the references
                prevNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            prevNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }


    @Override
    public void traverse() {
        if(rootNode == null) return;
        Node<T> actualNode = rootNode;
        while(actualNode != null){
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return numberOfNodes;
    }

    // First we have to find the last node in O(N) time
    private void insertEnd(T data) {
         Node<T> node = new Node<>(data);
         Node<T> currNode = rootNode;
         while(currNode.getNextNode() != null){
             currNode = currNode.getNextNode();
         }
         currNode.setNextNode(node);

    }

    private void insertBeggining(T data) {
        Node temp = rootNode;
        setRootNode(new Node<>(data));
        rootNode.setNextNode(temp);
        numberOfNodes++;
    }

    public Node<T> getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node<T> rootNode) {
        this.rootNode = rootNode;
    }


    /**
     * In place solution to reverse a singly linked list
     * Time Complexity: O(N)
     */
    public void reverse() {
        if(numberOfNodes == 0) return;
        Node<T> current = rootNode;
        Node<T> previous = null;
        Node<T> next = null;

        while(current != null){
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }

        setRootNode(previous);
    }
}

