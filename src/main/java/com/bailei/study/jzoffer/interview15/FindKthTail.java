package com.bailei.study.jzoffer.interview15;

import com.bailei.study.jzoffer.interview13.ListNode;

/**
 * Created by bailei on 16/12/9.
 */
public class FindKthTail {

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

    public static void main(String[] args) {
        ListNode tail = new ListNode(0, null);
        ListNode node1 = new ListNode(1, tail);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode head = new ListNode(5, node4);

        System.out.println(new FindKthTail().findKthTail(head, 7));
    }

}
