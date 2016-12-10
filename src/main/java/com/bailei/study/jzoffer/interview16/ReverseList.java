package com.bailei.study.jzoffer.interview16;

import com.bailei.study.jzoffer.interview13.ListNode;
import com.bailei.study.utils.Utils;

/**
 * Created by bailei on 16/12/10.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head, p2 = head.next, p3 = head.next.next;
        p1.next = null; //tail
        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        head = p2;
        return head;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(0, null);
        ListNode node1 = new ListNode(1, tail);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode head = new ListNode(5, node4);

        Utils.printList(new ReverseList().reverseList(head));
    }
}
