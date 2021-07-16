package com.example.datastructure.linkedlist.DoublyLinkedList;
import com.example.datastructure.linkedlist.List;

public class DoublyLinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void insert(T data) {
        if(head == null) {
            head = new Node<>(data);
            head.setNext(tail);
            size++;
            return;
        }
        insertEnd(data);
        insertBeggining(data);
    }

    public void insertBeggining(T data) {
        if(head == null){ insert(data); return; }
        Node temp = head;
        head = new Node<>(data);
        temp.setPrev(head);
        head.setNext(temp);
        if(tail == null)
            tail = temp;
        size++;
    }

    public void insertEnd(T data) {
        if(head == null){ insert(data); return; }
        if(tail == null){
            tail = new Node<>(data);
            head.setNext(tail);
            tail.setPrev(head);
            size++;
            return;
        }
        Node temp = tail;
        tail = new Node<>(data);
        temp.setNext(tail);
        tail.setPrev(temp);
        size++;
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traverse() {
        Node temp = head;
        while(temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
