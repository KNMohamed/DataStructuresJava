package com.example.adt.stack;

/**
 * Interface describing the behavior for a LIFO Stack structure
 * Operations include: Pop, Push, Peek
 * @param <T>
 */
public interface IStack<T> {
    public T pop();
    public void push(T data);
    public T peek();
    public boolean isEmpty();
    public int size();
}
