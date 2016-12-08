package com.bailei.study.jzoffer.interview13;

/**
 * Created by bailei on 16/12/8.
 * o（1）时间删除结点
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
        ListNode tail = new ListNode(0, null);
        ListNode node1 = new ListNode(1, tail);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode head = new ListNode(5, node4);

        new DeleteNodeInList().deleteNode(null, null);
        System.out.println(head);
    }
}
