package com.bailei.study.jzoffer.interview18;

/**
 * Created by bailei on 16/12/11.
 * 二叉树的插入
 */
public class BTree {

    private BTNode root;

    private int size = 0;

    public BTree() {
    }


    public void createBTree(int[] data) {
        if (data != null) {
            for (int dataItem : data) {
                insert(dataItem);
            }
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new BTNode(value);
        } else {
            BTNode curNode = root;
            BTNode parentNode;
            while (true) {
                parentNode = curNode;
                if (value < curNode.value) {
                    curNode = curNode.left;
                    if (curNode == null) {
                        parentNode.left = new BTNode(value);
                        break;
                    }
                } else {
                    curNode = curNode.right;
                    if (curNode == null) {
                        parentNode.right = new BTNode(value);
                        break;
                    }
                }
            }
        }

    }


    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BTNode root) {
        if (root != null) {
            System.out.println(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BTree bTree = new BTree();
        bTree.createBTree(new int[] {1,2,3,4,5});
        bTree.preOrder();
    }
}
