package com.example.dijkistra;

import com.example.adt.stack.IStack;
import com.example.datastructure.stack.LinkedListStack;
import java.util.Scanner;

public class Interpreter {
    public static void main(String[] args) {
        IStack<Integer> valueStack = new LinkedListStack<Integer>();
        IStack<Character> operationStack = new LinkedListStack<Character>();

        Scanner sc = new Scanner(System.in);
        String equation = sc.nextLine();
        equation.replaceAll("\\s+",""); //Remove whitespace

        for (Character c : equation.toCharArray()) {
            if (Character.isDigit(c)) {
                valueStack.push(Integer.parseInt(c.toString()));
            } else if (c == '%' || c == '/' || c == '*' || c == '+' || c == '-') {
                operationStack.push(c);
            }

            if(Character.valueOf(c) == ')'){
                if(operationStack.isEmpty()) continue;

                int x = valueStack.pop();
                int y = valueStack.pop();
                char o = operationStack.pop();

                switch (o){
                    case '*':
                        valueStack.push(y*x);
                        break;
                    case '/':
                        valueStack.push(y/x);
                        break;
                    case '+':
                        valueStack.push(y+x);
                        break;
                    case '-':
                        valueStack.push(y-x);
                        break;
                    case '%':
                        valueStack.push(y%x);
                        break;
                }
            }
        }
        System.out.println(valueStack.peek());
    }
}
