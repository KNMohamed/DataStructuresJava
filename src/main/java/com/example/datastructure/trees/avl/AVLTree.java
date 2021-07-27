package com.example.datastructure.trees.avl;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    public Node<T> root;
    int count;

    public AVLTree() {
        this.count = 0;
    }

    public java.util.ArrayList<T> convertToArr(){
        if(this.root == null) return null;
        return convertToArr(new java.util.ArrayList<T>(count), this.root);
    }

    private java.util.ArrayList<T> convertToArr(java.util.ArrayList<T> arr, Node<T> node){
        if(node.getLeftChild() != null)
            convertToArr(arr,node.getLeftChild());
        arr.add(node.getData());
        if(node.getRightChild() != null)
            convertToArr(arr,node.getRightChild());
        return arr;
    }

    private Node<T> getPredecessor(Node<T> node){
        if(node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        return node;
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
            this.count--;
            /* Element has been found */
            // 1) Leaf node scenario
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
            }else if(node.getLeftChild() != null && node.getRightChild() == null) {
                // 2a) Scenario when node only has a left child
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
            }else if(node.getRightChild() != null & node.getLeftChild() == null){
                // 2b) Scenario when node only has a right child
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
                // 3) Node to delete has two children
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
        // Settle the violation
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
    public void insert(T data){
        // When inserting the first node in the AVL Tree
        if(root == null){
            this.root = new Node(data, null);
            this.count++;
        }else{
            // There are already items in the AVL Tree
            insert(data,root);
        }
    }

    private void insert(T data, Node<T> node){
        if (data.compareTo(node.getData()) > 0) {
            if(node.getRightChild() == null) {
                node.setRightChild(new Node<>(data, node));
                this.count++;
            }
            else {
                insert(data, node.getRightChild());
            }
        } else if (data.compareTo(node.getData()) < 0) {
            if(node.getLeftChild() == null) {
                node.setLeftChild(new Node<>(data, node));
            }
            else {
                insert(data, node.getLeftChild());
                this.count++;
            }
        }else{
            System.out.println("Node with " + data + " already exists");
            return;
        }

        // Settle the violation

    }

//
//    private int height(Node<T> node){
//        if(node == null) return -1;
//        return node.getHeight();
//    }
//
//    //update the height of a given node
//    private void updateHeight(Node<T> node){
//        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
//    }
//
//    //Get the balance factor of the node
//    private int getBalance(Node<T> node){
//        if(node == null) return 0;
//        return height(node.getLeftChild()) - height(node.getRightChild());
//    }

    private int getHeight() {
        if(root == null)
            return -1;
        return getHeight(root);
    }

    private int getHeight(Node<T> node){
        int x = -1;
        int y = -1;

        if(node.getLeftChild() != null)
            x = getHeight(node.getLeftChild());

        if(node.getRightChild() != null)
            y = getHeight(node.getRightChild());

        node.setHeight(Math.max(x,y) + 1);
        return (Math.max(x,y) + 1);
    }

    // Done in O(1)
    public void rightRotation(Node<T> node){
        if(node == null) return;

        Node<T> parentNode = node.getParentNode();
        Node<T> leftChild = node.getLeftChild();

        if(parentNode != null){
            parentNode.setLeftChild(leftChild);
            leftChild.setParentNode(parentNode);
        }else{
            this.root = leftChild;
            this.root.setParentNode(null);
        }

        node.setParentNode(leftChild);
        node.setLeftChild(leftChild.getRightChild());
        leftChild.setRightChild(node);

        if(node.getLeftChild() != null){
            node.getLeftChild().setParentNode(node);
        }
    }

    // Done in O(1)
    public void leftRotation(Node<T> node){
        if(node == null) return;

        Node<T> parent = node.getParentNode();
        Node<T> rightChild = node.getRightChild();

        if(parent != null) {
            parent.setRightChild(rightChild);
            rightChild.setParentNode(parent);
        }else{
            this.root = rightChild;
            this.root.setParentNode(null);
        }

        node.setParentNode(rightChild);
        node.setRightChild(rightChild.getLeftChild());
        rightChild.setLeftChild(node);

        if(node.getRightChild() != null){
            node.getRightChild().setParentNode(node);
        }
    }
}
