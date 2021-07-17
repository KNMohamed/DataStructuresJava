package com.example.adt.queue;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(5);
        q.add(9);
        q.add(12);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
