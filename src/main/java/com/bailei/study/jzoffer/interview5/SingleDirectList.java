package com.bailei.study.jzoffer.interview5;

import java.util.Stack;

/**
 * Created by bailei on 16/12/3.
 * 单向链表实现，添加，查找，删除，打印
 */
public class SingleDirectList {


    /**
     * 结点定义
     */
    private class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public Node root;

    public SingleDirectList() {
    }

    public void addToTail(int value) {
        Node newNode = new Node(value, null);
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node tailNode = this.root;
        while (tailNode != null && tailNode.next != null) {
            tailNode = tailNode.next;
        }

        tailNode.next = newNode;
    }


    public void removeNode(int value) {
        Node pNode = this.root;
        if (pNode == null) {
            return;
        }

        while (pNode.next.value != value && pNode.next != null) {
            pNode = pNode.next;
        }
        Node toBeDeleted = pNode.next;
        if (toBeDeleted != null && toBeDeleted.value == value) {
            pNode.next = toBeDeleted.next;
        }

        if (toBeDeleted != null) {
            toBeDeleted = null; //加快内存回收
        }
    }


    public void printReversingLy() {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }

    }


    public static void main(String[] args) {
        SingleDirectList singleDirectList = new SingleDirectList();
        singleDirectList.addToTail(1);
        singleDirectList.printReversingLy();

        singleDirectList = new SingleDirectList();
        singleDirectList.addToTail(1);
        singleDirectList.addToTail(2);
        singleDirectList.addToTail(3);
        singleDirectList.addToTail(4);

        singleDirectList.printReversingLy();
    }
}
