package com.bailei.study.jzoffer.interview7;

import java.util.Stack;

/**
 * Created by bailei on 16/12/4.
 * 两个stack实现的栈
 */
public class CQueue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(T element) {
        stack1.push(element);
    }

    public T deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        CQueue<String> cQueue = new CQueue<>();
        cQueue.appendTail("a");
        cQueue.appendTail("b");
        cQueue.appendTail("c");
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail("d");
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail("e");
        cQueue.appendTail("f");
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }
}
