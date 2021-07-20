package com.example.datastructure.trees.binarysearch;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(8);
        bst.insert(16);
        bst.insert(27);
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
        bst.traverse();
        System.out.println("");
        bst.delete(16);
        bst.delete(20);
        bst.traverse();
    }
}
