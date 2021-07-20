package com.example.datastructure.trees;

public interface Tree<T> {
    public void insert(T data);
    public void delete(T data);
    // in-order traversal yields the natural ordering
    public void traverse();
    public T getMin();
    public T getMax();

}
