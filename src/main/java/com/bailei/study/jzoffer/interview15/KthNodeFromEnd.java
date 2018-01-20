package com.bailei.study.jzoffer.interview15;

import com.bailei.study.jzoffer.interview13.ListNode;

/**
 * Created by bailei on 16/12/9.
 * 找到倒数第K个结点
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
        ListNode head = new ListNode.Builder().node(0)
                .node(1).node(2).node(3).node(4).node(5).build();

        System.out.println(new KthNodeFromEnd().findKthTail(head, 6));
        ListNode middleNode = new KthNodeFromEnd().findMiddleNode(head);
        System.out.println(middleNode);
        middleNode.next = head;
        System.out.println(new KthNodeFromEnd().isLooped(head));
    }

}
