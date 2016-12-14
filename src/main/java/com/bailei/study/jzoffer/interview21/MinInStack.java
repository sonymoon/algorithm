package com.bailei.study.jzoffer.interview21;

import java.util.Stack;

/**
 * Created by bailei on 16/12/14.
 * 包含min函数的Stack实现
 */
public class MinInStack<T extends Comparable> {

    private Stack<T> stack;

    private Stack<T> minStack;

    public MinInStack() {
        stack = new Stack<T>();
        minStack = new Stack<T>();
    }

    public void push(T value) {
        stack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            T minValue = minStack.peek();
            if (value.compareTo(minValue) > 0) {
                minStack.push(minValue);
            } else {
                minStack.push(value);
            }
        }
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        } else {
            minStack.pop();
            return stack.pop();
        }
    }

    public T min() {
        if (minStack.isEmpty()) {
            return null;
        } else {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinInStack<Integer> stack = new MinInStack<>();
        stack.push(4);
        stack.push(3);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
    }

}
