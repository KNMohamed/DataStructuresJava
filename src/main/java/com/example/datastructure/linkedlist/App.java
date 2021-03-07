package com.example.datastructure.linkedlist;

import com.example.adt.stack.Stack;
import com.example.datastructure.linkedlist.SinglyLinkedList.SingleLinkedList;
import com.example.datastructure.linkedlist.DoublyLinkedList.DoublyLinkedList;
import com.example.datastructure.stack.LinkedListStack;


public class App {
    public static void main(String[] args) {
        Stack<String> s = new LinkedListStack<>();

        s.push("Khalid");
        System.out.println(s.size());
        s.push("Mohamed");
        s.push("Adam");
        s.push("Xavier");
        s.push("Joe");
        s.push("James");


        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.pop());
    }
}
