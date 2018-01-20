package com.bailei.study.jzoffer.interview26;

import com.bailei.study.jzoffer.interview13.ListNode;

/**
 * Created by bailei on 16/12/18.
 * 复杂链表的结点表示
 */
public class ComplexListNode extends ListNode {

    public int value;

    public ComplexListNode next;
    /**
     * 指向任意其它节点的链接
     */
    public ComplexListNode sibling;


    /**
     * 通过一个数组和配对构造复杂链表
     *
     * @param values
     * @param siblings
     */
    public ComplexListNode(int[] values, int[]... siblings) {
        if (values == null || values.length == 0) {
            return;
        }
        ComplexListNode p = this;
        p.value = values[0];
        for (int i = 1; i < values.length; i++) {
            p.next = new ComplexListNode(values[i]);
            p = p.next;
        }
        //设置siblings
        for (int[] sibling : siblings) {
            int from = sibling[0];
            int end = sibling[1];
            if (from > values.length - 1 || end > values.length - 1) {
                continue;
            }
            ComplexListNode pFrom = this;
            ComplexListNode pTo = this;
            for (int i = 0; i < from; i++) {
                pFrom = pFrom.next;
            }
            for (int i = 0; i < end; i++) {
                pTo = pTo.next;
            }
            pFrom.sibling = pTo;
        }
    }

    public ComplexListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}
