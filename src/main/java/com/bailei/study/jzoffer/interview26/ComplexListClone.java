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

    public static void main(String[] args) {
        ComplexListNode head = new ComplexListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                new int[]{0, 2},
                new int[]{3, 7},
                new int[]{7, 4});
        Utils.printList(new ComplexListClone().cloneUsingHashTable(head));
    }
}
