package com.example.challenges.maxinstack;

public class App {
    public static void main(String[] args) {
        CustomStack c = new CustomStack();
        c.push(6);
        c.push(10);
        c.push(26);
        c.push(22);
        c.push(3);
        c.push(8);

        System.out.println(c.getMaxItem());

        c.pop();
        c.pop();
        c.pop();
        c.pop();

        System.out.println(c);
        System.out.println(c.getMaxItem());


    }
}
