package com.example.datastructure.stack;

import com.example.adt.stack.IStack;
import com.example.datastructure.linkedlist.SinglyLinkedList.SingleLinkedList;
import java.util.EmptyStackException;


/**
 * @author Khalid Mohames
 * A Generic Stack implementation using a LinkedList
 */
public class LinkedListStack<T extends Comparable<T>> implements IStack<T> {
    private SingleLinkedList<T> linkedList = new SingleLinkedList<>();
    int count;

    /**
     * @return The last item that was added to the Stack (LIFO)
     * Time Complexity: O(1)
     * @throws EmptyStackException
     */
    @Override
    public T pop() throws EmptyStackException {
        if(count == 0) throw new EmptyStackException();
        T data = linkedList.getRootNode().getData();
        linkedList.remove(data);
        count = linkedList.size();
        return data;
    }

    /**
     * Pushes the data to the stack
     * Time Complexity: O(1)
     * @param data
     */
    @Override
    public void push(T data) {
        linkedList.insert(data);
        count = linkedList.size();
    }

    /**
     * Peeks at the item from the top of the stack without removing it
     * Time Complexity O(1)
     * @return
     */
    @Override
    public T peek() {
        if(count == 0) throw new EmptyStackException();
        T data = linkedList.getRootNode().getData();
        return data;
    }

    /**
     * Checks if the stack is empty
     * Time Complexity O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return count==0 ? true : false;
    }

    /**
     * Returns the size of the stack
     * Time Complexity O(1)
     * @return
     */
    @Override
    public int size() {
        return count;
    }
}