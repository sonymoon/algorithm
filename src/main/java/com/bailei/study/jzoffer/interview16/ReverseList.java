package com.bailei.study.jzoffer.interview16;

import com.bailei.study.jzoffer.interview13.ListNode;
import com.bailei.study.utils.Utils;

/**
 * Created by bailei on 16/12/10.
 * 反向排列数组
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
        ListNode head = new ListNode.Builder().node(0)
                .node(1).node(2).node(3).node(4).node(5).build();

        Utils.printList(new ReverseList().reverseList(head));
    }
}
