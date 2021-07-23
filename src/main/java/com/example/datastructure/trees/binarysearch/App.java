package com.example.datastructure.trees.binarysearch;

import com.example.datastructure.trees.binarysearch.helpers.TreeCompareHelper;
import com.example.datastructure.trees.binarysearch.helpers.TreeHelper;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        bst.insert(new Person("Mark",20));
        bst.insert(new Person("Steve",17));
        bst.insert(new Person("Andrea",25));
        bst.insert(new Person("Michelle",30));
        bst.insert(new Person("Robert",14));
        bst.insert(new Person("Ronald",11));
        int total = bst.getFamilyTotalAge(bst.getRoot());
        System.out.println(total);
    }
}

