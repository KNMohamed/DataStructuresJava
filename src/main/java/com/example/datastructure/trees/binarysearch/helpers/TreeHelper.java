package com.example.datastructure.trees.binarysearch.helpers;
import com.example.datastructure.trees.binarysearch.Node;

public class TreeHelper<T extends Comparable<T>> {
    /**
     * Recursive in-place solution to find the kth smallest element in the tree given an integer k
     * @param node the root node
     * @param k the kth element
     * @return the data at the kth smallest element
     */
    public T kthSmallestNode(Node<T> node, int k){
        if(k <= 0) throw new IllegalArgumentException("Value k must be a positive integer");

        int leftSubTreeSize = getNumOfNodes(node.getLeftChild());
        if(k == leftSubTreeSize + 1) return node.getData();
        else if(k <= leftSubTreeSize)
            return kthSmallestNode(node.getLeftChild(), k);
        else if(leftSubTreeSize == 0 && node.getRightChild() == null)
            throw new IllegalArgumentException("Value k must be less than size of tree");
        else
            return kthSmallestNode(node.getRightChild(), k-leftSubTreeSize-1);
    }

    /**
     * Recursive solution to determine the total count of nodes
     * @param t
     * @return the total amount of nodes in the tree
     */
    public int getNumOfNodes(Node<T> t){
        if(t == null) return 0;
        return numOfNode(t) - 1;
    }
    private int numOfNode(Node<T> node) {
        if(node == null) return 1;

        return numOfNode(node.getLeftChild()) + numOfNode(node.getRightChild());
    }
}

