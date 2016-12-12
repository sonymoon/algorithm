package com.bailei.study.jzoffer.interview6;

/**
 * Created by bailei on 16/12/4.
 * 根据前序遍历和中序遍历数组，重建二叉树
 */
public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTreeNode reconstruct(int[] preOrder, int[] inOrder) {
        root = null;
        return reconstruct(preOrder, inOrder, 0, preOrder.length - 1,
                0, inOrder.length - 1);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    private void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root + ", ");
            preOrder(root.pLeft);
            preOrder(root.pRight);
        }
    }

    private BinaryTreeNode reconstruct(int[] preOrder, int[] inOrder,
                                       int startPre, int endPre,
                                       int startIn, int endIn) {
        int lengthPre = endPre - startPre + 1;
        int lengthIn = endIn - startIn + 1;
        if (lengthPre == 0 || lengthIn == 0) {
            return null;
        }
        if (lengthPre == 1 || lengthIn == 1) {
            return new BinaryTreeNode(preOrder[startPre]);
        }
        int rootValue = preOrder[startPre];
        int rootValueIndexOfInOrder = -1;

        for (int i = endIn; i >= startIn; i--) {
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
        if (root == null) {
            root = rootNode;
        }
        if (leftLength > 0) {
            rootNode.pLeft = reconstruct(preOrder, inOrder,
                    startPre + 1, startPre + leftLength,
                    startIn, startIn + leftLength - 1);
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
        binaryTree.reconstruct(preOrder, inOrder);
        binaryTree.preOrder();

        //没有右子结点
        int[] preOrder1 = {1, 2, 3, 4, 5};
        int[] inOrder1 = {5, 4, 3, 2, 1};
        binaryTree.reconstruct(preOrder1, inOrder1);
        binaryTree.preOrder();

        //没有左子结点
        int[] preOrder2 = {1, 2, 3, 4, 5};
        int[] inOrder2 = {1, 2, 3, 4, 5};
        binaryTree.reconstruct(preOrder2, inOrder2);
        binaryTree.preOrder();
    }
}
