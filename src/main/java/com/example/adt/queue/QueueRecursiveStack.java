package com.example.adt.queue;

import java.util.Stack;

public class QueueRecursiveStack<T> {
    Stack<T> stack;

    public QueueRecursiveStack(){
        stack = new Stack<>();
    }

    public void enqueue(T data){
        this.stack.push(data);
    }

    public T dequeue(){
        if(stack.empty()) throw new RuntimeException("Queue is empty");

        //base case
        if(stack.size() == 1){
            return stack.pop();
        }

        T item = stack.pop();

        //Recursively call to get last item
        T lastItem = dequeue();

        //Add items back
        enqueue(item);

        return lastItem;
    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }

}
