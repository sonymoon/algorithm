package com.bailei.study.jzoffer.interview18;

/**
 * Created by bailei on 16/12/11.
 */
public class BTNode {

    int value;

    BTNode left, right;

    public BTNode(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "" + value;
    }
}
