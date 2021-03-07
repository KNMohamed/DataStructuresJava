package com.example.datastructure.stack;

import com.example.adt.stack.Stack;
import com.example.datastructure.linkedlist.SinglyLinkedList.SingleLinkedList;

import java.util.EmptyStackException;

public class LinkedListStack<T extends Comparable<T>> implements Stack<T> {
    private SingleLinkedList<T> linkedList = new SingleLinkedList<>();
    int count;

    @Override
    public T pop() throws EmptyStackException {
        if(count == 0) throw new EmptyStackException();
        T data = linkedList.getRootNode().getData();
        linkedList.remove(data);
        count = linkedList.size();
        return data;
    }

    @Override
    public void push(T data) {
        linkedList.insert(data);
        count = linkedList.size();
    }

    @Override
    public T peek() {
        if(count == 0) throw new EmptyStackException();
        T data = linkedList.getRootNode().getData();
        return data;
    }

    @Override
    public boolean isEmpty() {
        return count==0 ? true : false;
    }

    @Override
    public int size() {
        return count;
    }
}