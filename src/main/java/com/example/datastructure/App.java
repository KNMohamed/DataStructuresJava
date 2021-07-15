package com.example.datastructure;

import com.example.adt.stack.IStack;
import com.example.datastructure.stack.LinkedListStack;


public class App {
    public static void main(String[] args) {
        IStack<String> s = new LinkedListStack<>();

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
