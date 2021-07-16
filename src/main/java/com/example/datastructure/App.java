package com.example.datastructure;

import com.example.adt.stack.IStack;
import com.example.adt.stack.Stack;


public class App {
    public static void main(String[] args) {
        IStack<String> s = new Stack<>();

        s.push("Khalid");
        s.push("Mohamed");
        s.push("Adam");
        s.push("Xavier");
        s.push("Joe");
        s.push("James");


        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
