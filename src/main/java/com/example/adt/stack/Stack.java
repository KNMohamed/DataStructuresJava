package com.example.adt.stack;

import com.example.adt.stack.IStack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements IStack<T> {
    private int count;
    private T[] stack;

    public Stack(){
        stack = (T[]) new Object[1];
    }


    // This is the bottleneck of the application O(N);
    private void resize(int newSize) {
        stack = (T[]) Arrays.copyOf(stack,newSize,stack.getClass());
    }

    // add to the new item to the end of the array in O(1)
    @Override
    public void push(T data) {
        // Arrays are not dynamic data structures
        // We need to resize the underlying array if necessary
        // If there are too many items in the array we need to double the size
        // If there are too few itmes we decrease the array
        if(count == stack.length){
            resize(2*count);
        }
        stack[count++] = data;
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();;

        T item = stack[--count];

        //Obsolete references - avoid memory leaks
        stack[count] = null;

        //If stack is 25% full resize
        if(count == stack.length/4){
            resize(stack.length/2);
        }
        return item;
    }


    @Override
    public T peek() {
        if(count == 0) throw new EmptyStackException();
        return stack[count-1];
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    // O(1)
    @Override
    public int size() {
        return count;
    }
}
