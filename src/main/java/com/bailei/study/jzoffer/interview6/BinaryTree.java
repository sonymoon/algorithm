package com.bailei.study.jzoffer.interview6;

/**
 * Created by bailei on 16/12/4.
 * 根据前序遍历和中序遍历数组，重建二叉树
 */
public class BinaryTree {


    public BinaryTreeNode reconstruct(int[] preOrder, int[] inOrder,
                                      int startPre, int endPre,
                                      int startIn, int endIn) {
        int lengthPre = endPre - startPre + 1;
        int lengthIn = endIn - startIn +1;
        if (lengthPre == 0 || lengthIn == 0) {
            return null;
        }
        if (lengthPre == 1 || lengthIn == 1) {
            return new BinaryTreeNode(preOrder[startPre]);
        }
        int rootValue = preOrder[startPre];
        int rootValueIndexOfInOrder = -1;

        for (int i = startIn; i <= endIn; i++) {
            if (rootValue == inOrder[i]) {
                rootValueIndexOfInOrder = i;
                break;
            }
        }
        if (rootValueIndexOfInOrder == -1) {
            throw new RuntimeException("不能重建二叉树，序列不匹配");
        }

        int leftLength = rootValueIndexOfInOrder - startIn;
        int rightLength = endIn - rootValueIndexOfInOrder;

        BinaryTreeNode rootNode = new BinaryTreeNode(rootValue);
        if (leftLength > 0) {
            rootNode.pLeft = reconstruct(preOrder, inOrder,
                    startPre + 1, startPre + leftLength,
                    startIn, startIn + leftLength -1);
        }

        if (rightLength > 0) {
            rootNode.pRight = reconstruct(preOrder, inOrder,
                    startPre + leftLength + 1, startPre + leftLength + rightLength,
                    rootValueIndexOfInOrder + 1, rootValueIndexOfInOrder + rightLength);

        }

        return rootNode;
    }


    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree binaryTree = new BinaryTree();
        BinaryTreeNode root = binaryTree.reconstruct(preOrder, inOrder,
                0, preOrder.length - 1,
                0,inOrder.length - 1);
        System.out.println(root);

        //没有右子结点
        int[] preOrder1 = {1, 2, 3, 4, 5};
        int[] inOrder1 = {5, 4, 3, 2, 1};
         root = binaryTree.reconstruct(preOrder1, inOrder1,
                0, preOrder1.length - 1,
                0,inOrder1.length - 1);
        System.out.println(root);

        //没有左子结点
        int[] preOrder2 = {1, 2, 3, 4, 5};
        int[] inOrder2 = {1, 2, 3, 4, 5};
        root = binaryTree.reconstruct(preOrder2, inOrder2,
                0, preOrder2.length - 1,
                0,inOrder2.length - 1);
        System.out.println(root);

    }
}
