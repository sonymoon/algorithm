package com.bailei.study.utils;

import com.bailei.study.jzoffer.interview13.ListNode;

/**
 * Created by bailei on 16/12/10.
 */
public class Utils {

    public static  void printList(ListNode head) {
        if (head == null) return;
        StringBuilder str = new StringBuilder();
        str.append(head.value);
        ListNode p = head;
        while (p != null) {
            p = p.next;
            if (p != null)
                str.append("=>" + p.value);
        }
        System.out.println(str.toString());
    }

}
