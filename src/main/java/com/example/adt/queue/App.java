package com.example.adt.queue;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        QueueStack<Integer> q = new QueueStack<>();
        q.enqueue(5);
        q.enqueue(9);
        q.enqueue(12);

        System.out.println(q.dequeue());

        q.enqueue(100);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
}
