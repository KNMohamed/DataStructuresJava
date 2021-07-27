package com.example.datastructure.trees.avl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AVLTreeTest {
    AVLTree<Integer> a;
    AVLTree<Integer> emptyTree;
    @BeforeEach
    public void setup(){
        emptyTree = new AVLTree<>();
        // Create Balanced AVL Tree of Integers
        a = new AVLTree<Integer>();
        a.insert(6);
        a.insert(10);
        a.insert(3);
        a.insert(15);
        a.insert(8);
        a.insert(1);
        a.insert(5);
    }

    @Test
    public void isEmpty(){
        assertEquals(0,emptyTree.count);
    }

    @Test
    public void insert_ShouldIncrementCountByOne(){
        emptyTree.insert(1);
        assertEquals(1,emptyTree.count);
    }

    @Test
    public void insert_ShouldNotIncrementCountOnDuplicateInsert(){
        emptyTree.insert(1);
        emptyTree.insert(1);
        assertEquals(1,emptyTree.count);
    }

    @Test
    public void traverse_ShouldYieldCorrectInorderTraversal(){
        int[] expectedOutput = {1,3,5,6,8,10,15};
        int[] arr = a.convertToArr().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(arr,expectedOutput);
    }
}
