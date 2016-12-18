package com.bailei.study.jzoffer.interview25;

import com.bailei.study.jzoffer.interview6.BinaryTree;
import com.bailei.study.jzoffer.interview6.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by bailei on 16/12/18.
 * 打印二叉树所有和为指定整数的路径
 * 其实就是preOrder啊
 */
public class PathInTree {

    private Stack<BinaryTreeNode> pathStack;

    public PathInTree() {
        this.pathStack = new Stack<>();
    }

    public void findPath(BinaryTree tree, int sum) {
        findPath(tree.getRoot(), sum, 0);
    }

    private void findPath(BinaryTreeNode node, int expectedSum, int currentSum) {
        if (node == null) {
            return;
        }
        currentSum += node.value;
        pathStack.push(node);
        boolean isLeaf = node.pLeft == null && node.pRight == null;
        if (isLeaf && currentSum == expectedSum) { //叶结点并且和相等了
            System.out.println("Path found: ");
            pathStack.forEach(node1 -> System.out.print(">" + node1.value));
            System.out.println();
        }

        if (node.pLeft != null) {
            findPath(node.pLeft, expectedSum, currentSum);
        }
        if (node.pRight != null) {
            findPath(node.pRight, expectedSum, currentSum);
        }
        pathStack.pop();
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.reconstruct(new int[]{10, 5, 4, 7, 12}, new int[]{4, 5, 7, 10, 12});
        new PathInTree().findPath(tree, 19);
    }

}
