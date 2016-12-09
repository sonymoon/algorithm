package com.bailei.study.jzoffer.interview13;

/**
 * Created by bailei on 16/12/8.
 * 链表结点
 */
public class ListNode {

    public int value;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}
