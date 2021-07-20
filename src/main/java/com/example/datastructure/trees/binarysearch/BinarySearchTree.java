package com.example.datastructure.trees.binarysearch;

import com.example.datastructure.trees.Tree;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{
    private Node<T> root;

    @Override
    public void insert(T data) {
        //When inserting the first node in the BST
        if(root == null){
            root = new Node<>(data,null);
        } else{
            //there are already items in the BST
            insert(data,root);
        }
    }

    private void insert(T data, Node<T> node) {
        if(data.compareTo(node.getData()) < 0){
            if(node.getLeftChild() != null)
                insert(data,node.getLeftChild());
            else
                node.setLeftChild(new Node<>(data,node));
        } else if(data.compareTo(node.getData()) > 0) {
            if(node.getRightChild() != null)
                insert(data,node.getRightChild());
            else
                node.setRightChild(new Node<>(data,node));
        }
    }


    @Override
    public void delete(T data){
        if(root != null)
            delete(data,root);
    }

    private void delete(T data, Node<T> node) {

        //Base case if node is not found
        if(node == null) return;

        if(data.compareTo(node.getData()) < 0){
            delete(data,node.getLeftChild());
        }else if(data.compareTo(node.getData()) > 0){
            delete(data,node.getRightChild());
        }else{
            /* Element has been found */
            // Leaf node scenario
            if(node.getRightChild() == null && node.getLeftChild() == null){
                Node<T> parent = node.getParentNode();

                //If the node is a left child
                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(null);
                } else if(parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(null);
                }

                if(parent == null)
                    this.root = null;

                node = null;
            }else if(node.getLeftChild() != null && node.getRightChild() == null) {     // Scenario when node only has a left child
                Node<T> parent = node.getParentNode();

                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getLeftChild());
                    node.getLeftChild().setParentNode(parent) ;
                } else if(parent != null && parent.getRightChild() == node){
                    parent.setRightChild(node.getLeftChild());
                    node.getLeftChild().setParentNode(parent) ;
                }

                if(parent == null){
                    this.root = node.getLeftChild();
                    this.root.setParentNode(null);
                }else{
                    node.getLeftChild().setParentNode(parent);
                }
                node = null;
            }else if(node.getRightChild() != null & node.getLeftChild() == null){     // Scenario when node only has a right child
                Node<T> parent = node.getParentNode();

                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getRightChild());
                } else if (parent != null && parent.getRightChild() == node){
                    parent.setRightChild(node.getRightChild());
                }

                if(parent == null){
                    this.root = node.getRightChild();
                    this.root.setParentNode(null);
                }else{
                    node.getRightChild().setParentNode(parent);
                }
                node = null;
            }else{
                // Node to delete has two children
                // Find the Predecessor (The max item in the left subtree)
                Node<T> predecessor = getPredecessor(node.getLeftChild());

                //Swap the values
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                //We have to call the delete method recursively on the predecessor
                delete(data,predecessor);
            }
        }
    }

    private Node<T> getPredecessor(Node<T> node){
        if(node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public void traverse() {
        //in-order traversal in O(N) time
        if(root == null) return;
        traverse(root);
    }

    private void traverse(Node<T> node) {
        if(node.getLeftChild() != null)
            traverse(node.getLeftChild());
        System.out.print(node + " ");
        if(node.getRightChild() != null)
            traverse(node.getRightChild());
    }

    @Override
    public T getMin() {
        if(root != null){
            return getMin(root);
        }
        return null;
    }

    private T getMin(Node<T> node) {
        if(node.getLeftChild() != null){
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }


    @Override
    public T getMax() {
        if(root != null){
            return getMax(root);
        }
        return null;
    }

    private T getMax(Node<T> node){
        if(node.getRightChild() != null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }
}
