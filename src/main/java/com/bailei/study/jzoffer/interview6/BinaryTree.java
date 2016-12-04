package com.bailei.study.jzoffer.interview6;

/**
 * Created by bailei on 16/12/4.
 * 根据前序遍历和中序遍历，重建二叉树
 */
public class BinaryTree {


    public BinaryTreeNode reconstruct(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        if (preOrder.length == 1 || inOrder.length == 1) {
            return new BinaryTreeNode(preOrder[0]);
        }
        int rootValue = preOrder[0];
        int rootValueIndexOfInOrder = -1;

        for (int i = 0; i < inOrder.length; i++) {
            if (rootValue == inOrder[i]) {
                rootValueIndexOfInOrder = i;
                break;
            }
        }

        //leftTreeOrder & rightTreeOrder
        int leftTreeLength = rootValueIndexOfInOrder;
        int rightTreeLength = preOrder.length - 1 - leftTreeLength;
        int[] leftTreePreOrder = new int[leftTreeLength];
        int[] rightTreePreOrder = new int[rightTreeLength];
        int[] leftTreeInOrder = new int[leftTreeLength];
        int[] rightTreeInOrder = new int[rightTreeLength];
        if (leftTreeLength > 0) {
            for (int i = 0; i < leftTreeLength; ++i) {
                leftTreePreOrder[i] = preOrder[i + 1];
                leftTreeInOrder[i] = inOrder[i];
            }
        }
        if (rightTreeLength > 0) {
            for (int i = 0; i < rightTreeLength; ++i) {
                rightTreePreOrder[i] = preOrder[rightTreeLength + i];
                rightTreeInOrder[i] = inOrder[rightTreeLength + i];
            }
        }

        BinaryTreeNode rootNode = new BinaryTreeNode(rootValue);

        rootNode.pLeft = reconstruct(leftTreePreOrder, leftTreeInOrder);
        rootNode.pRight = reconstruct(rightTreePreOrder, rightTreeInOrder);

        return rootNode;
    }


    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree binaryTree = new BinaryTree();
        BinaryTreeNode root = binaryTree.reconstruct(preOrder, inOrder);
        System.out.println(root);
    }
}
