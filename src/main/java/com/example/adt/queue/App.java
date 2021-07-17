package com.example.adt.queue;

public class App {
    public static void main(String[] args) {
        QueueRecursiveStack<Integer> q = new QueueRecursiveStack<>();
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
