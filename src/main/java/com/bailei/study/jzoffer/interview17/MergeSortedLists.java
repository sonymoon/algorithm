package com.bailei.study.jzoffer.interview17;

import com.bailei.study.jzoffer.interview13.ListNode;
import com.bailei.study.utils.Utils;

/**
 * Created by bailei on 16/12/10.
 * 合并两个已排序的链表，结果也是排序的
 */
public class MergeSortedLists {

    /**
     * 头节点谁小谁是遍历表
     * 从头结点值小的表1开始遍历，碰到比表2中大的元素，则画出plast－>表2->p1的next引用
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeSortedLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            if (head1 == null) return head2;
            if (head2 == null) return head1;
        }
        ListNode p1, p2, pLast, newRoot;
        if (head1.value < head2.value) {
            p1 = pLast = head1;
            p2 = head2;
            newRoot = head1;
        } else {
            p1 = pLast = head2;
            p2 = head1;
            newRoot = head2;
        }
        while (p1 != null && p2 != null) {
            while (p1 != null && p2 != null && p1.value <= p2.value) {
                pLast = p1;
                p1 = p1.next;
            }
            if (p1 != null && p2 != null) {
                pLast.next = p2;
                pLast = p2;
                p2 = p2.next;
                pLast.next = p1;
            }
        }
        if (p1 == null) { //list1 to tail
            pLast.next = p2;
        }
        if (p2 == null) { //list2 to tail
            pLast.next = p1;
        }
        return newRoot;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode.Builder().node(1).node(2).node(3).node(6).node(7).build();
        ListNode head2 = new ListNode.Builder().node(2).node(8).node(10).node(12).build();
        Utils.printList(new MergeSortedLists().mergeSortedLists(head2, head1));
    }
}
