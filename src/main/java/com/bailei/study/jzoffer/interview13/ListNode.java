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
        return "" + this.value;
    }


    public static class Builder {

        private ListNode head;

        private ListNode tail;

        public Builder node(int value) {
            if (head == null) {
                head = new ListNode(value);
                tail = head;
            } else {
                this.tail.next = new ListNode(value);
                this.tail = this.tail.next;
            }
            return this;
        }

        public Builder node(ListNode node) {
            if (head == null) {
                head = node;
                tail = head;
            } else {
                this.tail.next = node;
                this.tail = this.tail.next;
            }
            return this;
        }


        public ListNode build() {
            return this.head;
        }
    }
}
