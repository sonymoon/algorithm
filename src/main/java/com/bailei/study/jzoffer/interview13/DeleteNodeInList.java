package com.bailei.study.jzoffer.interview13;

import com.bailei.study.utils.Utils;

/**
 * Created by bailei on 16/12/8.
 * o（1）时间删除链表中结点
 */
public class DeleteNodeInList {

    public void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            throw new RuntimeException("head or toBeDeleted can not be null");
        }
        if (head.next == null && head == toBeDeleted) {//只有一个头结点
            head = null;
        }
        if (toBeDeleted.next != null) {//中间节点
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        } else { // 删除的是尾结点
            ListNode node = head;
            while (node.next != toBeDeleted) {
                node = node.next;
            }
            node.next = null;
            toBeDeleted = null;

        }
    }

    public static void main(String[] args) {
        ListNode toBeDelete = new ListNode(7);
        ListNode head = new ListNode.Builder().node(0).node(toBeDelete)
                .node(1).node(2).node(3).node(4).node(5).build();
        new DeleteNodeInList().deleteNode(head, toBeDelete);
        Utils.printList(head);
    }
}
