package com.bailei.study.jzoffer.interview19;

import com.bailei.study.jzoffer.interview6.BinaryTree;
import com.bailei.study.jzoffer.interview6.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by bailei on 2016/12/12.
 * 求树的镜像
 */
public class MirrorOfBinaryTree {

    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public BinaryTreeNode mirroOfTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        BinaryTreeNode mirrorRoot = copy(root);
        return mirrorRoot;
    }

    private BinaryTreeNode copy(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node != null && node.pLeft == null && node.pRight == null) {
            return new BinaryTreeNode(node.value);
        } //叶子节点
        BinaryTreeNode mirrorNode = new BinaryTreeNode(node.value);
        mirrorNode.pLeft = copy(node.pRight);
        mirrorNode.pRight = copy(node.pLeft);
        return mirrorNode;
    }


    /**
     * TODO 非递归，借助栈，前序遍历
     *
     * @param node
     * @return
     */
    public BinaryTreeNode noReursively(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = node;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.pLeft;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();

            }
        }
        BinaryTreeNode mirror = new BinaryTreeNode(node.value);
        return mirror;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.reconstruct(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        BinaryTreeNode mirror = new MirrorOfBinaryTree().mirroOfTree(binaryTree.getRoot());
        new BinaryTree(mirror).preOrder();
    }

}
