package com.example.challenges.maxinstack;

import java.util.EmptyStackException;
import java.util.Stack;

public class CustomStack extends Stack<Integer> {
    private Stack<Integer> maxStack;

    public Stack<Integer> getMaxStack() {
        return maxStack;
    }

    public CustomStack(){
        super();
        this.maxStack = new Stack<Integer>();
    }

    @Override
    public Integer push(Integer item) {
        super.push(item);

        if(this.size() == 1){
          this.maxStack.push(item);
        } else if(item.intValue() > this.maxStack.peek()){
            this.maxStack.push(item);
        }else{
            this.maxStack.push(this.maxStack.peek());
        }
        return this.peek();
    }

    @Override
    public synchronized Integer pop() {
        maxStack.pop();
        return super.pop();
    }

    public int getMaxItem(){
        if(this.size() == 0) throw new EmptyStackException();
        return this.maxStack.peek().intValue();
    }

}
