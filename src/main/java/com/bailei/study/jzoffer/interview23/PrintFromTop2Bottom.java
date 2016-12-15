package com.bailei.study.jzoffer.interview23;

import com.bailei.study.jzoffer.interview6.BinaryTree;
import com.bailei.study.jzoffer.interview6.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by bailei on 16/12/15.
 * 从上往下打印二叉树
 */
public class PrintFromTop2Bottom {

    private Queue<BinaryTreeNode> queue;

    public PrintFromTop2Bottom() {
        queue = new ArrayDeque<>();
    }

    public void print(BinaryTree binaryTree) {
        add(binaryTree.getRoot());
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node);
            if (node.pLeft != null) {
                add(node.pLeft);
            }
            if (node.pRight != null) {
                add(node.pRight);
            }
        }
    }

    public void add(BinaryTreeNode node) {
        if (node != null) {
            queue.offer(node);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.reconstruct(new int[]{8, 6, 5, 7, 10, 9, 11}, new int[]{5, 6, 7, 8, 9, 10 ,11});
        new PrintFromTop2Bottom().print(binaryTree);
    }
}
