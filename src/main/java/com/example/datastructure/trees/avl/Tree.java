package com.example.datastructure.trees.avl;

public interface Tree<T> {
    public void insert(T data);
    public void delete(T data);
    public void traverse();
}
