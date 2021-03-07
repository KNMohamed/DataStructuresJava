package com.example.challenges;

import com.example.datastructure.linkedlist.SinglyLinkedList.SingleLinkedList;
public class ReverseLinkedList {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.insert("Khalid");
        list.insert("Jonah");
        list.insert("Gabriel");
        list.insert("Steve");
        list.insert("Mark");

        list.traverse();

        list.reverse();

        list.traverse();
    }
}
