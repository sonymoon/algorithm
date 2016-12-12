package com.bailei.study.jzoffer.interview6;

/**
 * Created by bailei on 16/12/4.
 */
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode pLeft;

    public BinaryTreeNode pRight;


    public BinaryTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
