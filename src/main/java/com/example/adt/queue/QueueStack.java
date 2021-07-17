package com.example.adt.queue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Implement a queue using stack based implementation
 * @param <T>
 */
public class QueueStack<T> {
    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;

    public QueueStack(){
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    // Insertion is O(1) time complexity
    public void enqueue(T data){
        enqueueStack.push(data);
    }

    public T dequeue(){

        if(enqueueStack.empty() && dequeueStack.empty()) throw new RuntimeException("Stacks are empty");

        // If dequeStack is empty we have to add items in O(N) time
        if(dequeueStack.empty()){
            while(!enqueueStack.empty()){
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }
}
