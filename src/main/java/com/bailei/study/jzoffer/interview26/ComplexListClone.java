package com.bailei.study.jzoffer.interview26;

import com.bailei.study.utils.Utils;

import java.util.HashMap;

/**
 * Created by bailei on 16/12/18.
 * 1、O（n^2）实现不予考虑
 */
public class ComplexListClone {

    /**
     * 用hash标缓存节点配对关系，不推荐
     */
    public ComplexListNode cloneUsingHashTable(ComplexListNode source) {
        ComplexListNode copy, pCopy;
        HashMap<ComplexListNode, ComplexListNode> tables = new HashMap<>();
        for (ComplexListNode p = source; p != null; p = p.next) {
            tables.put(p, new ComplexListNode(p.value)); //copy node
        }
        copy = tables.get(source);
        pCopy = copy;
        for (ComplexListNode p = source; p != null; p = p.next, pCopy = pCopy.next) {
            pCopy.next = tables.get(p.next);
            pCopy.sibling = tables.get(p.sibling);
        }
        return copy;
    }

    /**
     * 原地复制
     * 1、将复制结点放在原来链表后面
     * 2、设置sibling
     * 3、拆分两个链表
     *
     * @param source
     * @return
     */
    public ComplexListNode clone(ComplexListNode source) {
        if (source == null) {
            return null;
        }
        cloneNodes(source);
        cloneSiblings(source);
        return partionList(source);
    }

    private void cloneNodes(ComplexListNode head) {
        ComplexListNode p = head;
        while (p != null) {
            ComplexListNode pCopy = new ComplexListNode(p.value);
            pCopy.next = p.next;
            p.next = pCopy;
            p = pCopy.next;
        }
    }

    private void cloneSiblings(ComplexListNode head) {
        ComplexListNode pCopy = head.next, p = head;
        while (p != null) {
            if (p.sibling != null) {
                pCopy.sibling = p.sibling.next;
            }
            p = pCopy.next;
            pCopy = p == null ? null : p.next;
        }
    }

    private ComplexListNode partionList(ComplexListNode head) {
        ComplexListNode copyHead = head.next;
        ComplexListNode pCopy, p = head;
        while (p != null) {
            pCopy = p.next;
            p.next = pCopy.next;
            pCopy.next = pCopy.next == null ? null : pCopy.next.next;
            p = p.next;
        }
        return copyHead;
    }


    public static void main(String[] args) {
        ComplexListNode head = new ComplexListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{7, 4});
        Utils.printList(new ComplexListClone().clone(head));
        head = new ComplexListNode(new int[]{1},
                new int[]{0, 0});
        Utils.printList(new ComplexListClone().clone(null));
    }
}
