package com.example.datastructure.linkedlist;

import com.example.datastructure.linkedlist.SingeLinkedList.SingleLinkedList;
import com.example.datastructure.linkedlist.DoublyLinkedList.DoublyLinkedList;


public class App {
    public static void main(String[] args) {
        SingleLinkedList<Person> singleLinkedList = new SingleLinkedList<>();
        Person p = new Person(24,"adam");

        singleLinkedList.insert(p);
        singleLinkedList.insert(new Person(34,"steve"));
        singleLinkedList.insert(new Person(64,"greg"));
        singleLinkedList.remove(p);
        singleLinkedList.traverse();
        System.out.println("");

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertEnd("Robert");
        doublyLinkedList.insertEnd("Carol");
        doublyLinkedList.insertBeggining("Greg");
        doublyLinkedList.traverse();
    }
}
