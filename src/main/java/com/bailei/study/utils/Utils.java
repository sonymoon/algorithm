package com.bailei.study.utils;

import com.bailei.study.jzoffer.interview13.ListNode;
import com.bailei.study.jzoffer.interview26.ComplexListNode;

/**
 * Created by bailei on 16/12/10.
 */
public class Utils {


    public static void main(String[] args) {
        System.out.println(System.getProperty("PATH"));
        System.out.println(System.getenv("ROCKETMQ_HOME"));
    }

    public static void printList(ListNode head) {
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

    public static void printList(ComplexListNode head) {
        if (head == null) return;
        StringBuilder str = new StringBuilder("head");
        ComplexListNode p = head;
        while (p != null) {
            if (p != null) {
                if (p.sibling != null) {
                    System.out.println(p + "=>" + p.sibling);
                }
                str.append("=>" + p.value);
            }
            p = p.next;
        }
        System.out.println(str.toString());
    }


}
