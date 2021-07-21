package com.example.datastructure.trees.binarysearch.helpers;

import com.example.datastructure.trees.binarysearch.BinarySearchTree;
import com.example.datastructure.trees.binarysearch.Node;

public class TreeCompareHelper<T extends Comparable<T>> {
    /**
     * Takes two Binary Search Trees and compares their topology and values
     * @param b1 the first binary search tree to compare
     * @param b2 the second binary search tree to compare
     * @return true if the topology and values of the two BST are identical, otherwise false
     */
    public static boolean compareBST(BinarySearchTree b1, BinarySearchTree b2){
        TreeCompareHelper t = new TreeCompareHelper();
        return t.compareNodes(b1.getRoot(),b2.getRoot());
    }

    private boolean compareNodes(Node<T> x, Node<T> y) {
        if (x == null || y == null) {
            return x == y;
        }
        if(x.getData().compareTo(y.getData()) != 0){
            return false;
        }

        return compareNodes(x.getLeftChild(),y.getLeftChild()) && compareNodes(x.getRightChild(),y.getRightChild());
    }
}
