package com.bailei.study.jzoffer.interview15;

import com.bailei.study.jzoffer.interview13.ListNode;

/**
 * Created by bailei on 16/12/9.
 */
public class KthNodeFromEnd {


    public ListNode findKthTail(ListNode root, int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k must be positive");
        }
        if (root == null) {
            throw new IllegalArgumentException("list can not be null");
        }
        ListNode ahead = root;
        ListNode behind = root;
        for (int i = 0; i < k - 1; i++) {
            ahead = ahead.next;
            if (ahead == null) {
                throw new RuntimeException("list size is less than k");
            }
        }
        ahead = ahead.next;
        while (ahead != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        return behind;
    }

    /**
     * 相关题目1
     */
    public ListNode findMiddleNode(ListNode root) {
        if (root == null) {
            return null;
        }
        if (root.next == null || root.next.next == null) { //只有一个或两个结点
            return root;
        }

        ListNode p1 = root, p2 = root;
        while (p2 != null) {
            p1 = p1.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public boolean isLooped(ListNode root) {
        if (root == null) {
            return false;
        }
        ListNode p1 = root, p2 = root;
        while (p2 != null && p2 != p1) {
            p1 = p1.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            } else {
                p2 = p2.next;
            }
        }
        if (p2 == null && p2 != p1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(0, null);
        ListNode node1 = new ListNode(1, tail);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode head = new ListNode(5, node4);

        System.out.println(new KthNodeFromEnd().findKthTail(head, 6));
        System.out.println(new KthNodeFromEnd().findMiddleNode(head));
        tail.next = node2;
        System.out.println(new KthNodeFromEnd().isLooped(head));
    }

}
