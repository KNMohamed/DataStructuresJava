package com.example.datastructure.trees.binarysearch;

import com.example.datastructure.trees.binarysearch.helpers.TreeCompareHelper;
import com.example.datastructure.trees.binarysearch.helpers.TreeHelper;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(6);
        bst.insert(20);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(14);
        bst.insert(15);
        bst.insert(24);
        bst.insert(22);
        bst.insert(12);
        bst.insert(11);
        bst.insert(21);
        bst.insert(25);

        TreeHelper t = new TreeHelper();
        System.out.println(t.kthSmallestNode(bst.getRoot(),11));

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.insert(30);
        bst2.insert(20);
        bst2.insert(10);
        bst2.insert(40);
        bst2.insert(70);
        bst2.insert(25);
        bst2.insert(35);
        bst2.insert(15);
        bst2.insert(5);
        bst2.insert(45);
        bst2.insert(75);
        bst2.insert(80);
        bst2.insert(2);
        bst2.insert(1);

        boolean r = TreeCompareHelper.compareBST(bst,bst2);
        System.out.println(r);
    }
}

