package com.bailei.study.jzoffer.interview18;

import com.bailei.study.jzoffer.interview6.BinaryTree;
import com.bailei.study.jzoffer.interview6.BinaryTreeNode;

/**
 * Created by bailei on 16/12/12.
 * 判断树B是否是树A的子树
 */
public class SubstructureInTree {

    /**
     * 树1是否包含树2
     *
     * @param tree1
     * @param tree2
     */
    public boolean hasSubtree(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        boolean result = false;
        if (tree1 != null && tree2 != null) {
            result = isSame(tree1, tree2);
            if (result) {
                result = isSubTree(tree1, tree2);
            }
            if (!result) {
                result = hasSubtree(tree1.pLeft, tree2);
            }
            if (!result) {
                result = hasSubtree(tree1.pRight, tree2);
            }

        }
        return result;
    }


    public boolean isSubTree(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.value != tree2.value) {
            return false;
        }
        return isSubTree(tree1.pLeft, tree2.pLeft) && isSubTree(tree1.pRight, tree2.pRight);
    }


    private boolean isSame(BinaryTreeNode node1, BinaryTreeNode node2) {
        return node1.value == node2.value;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.reconstruct(new int[]{8, 8, 9, 2, 4, 7, 7}, new int[]{9, 8, 4, 2, 7, 8, 7});

        BinaryTree subTree = new BinaryTree();
        subTree.reconstruct(new int[]{8, 9, 3}, new int[]{9, 8, 3});

        System.out.println(new SubstructureInTree().hasSubtree(binaryTree.getRoot(), subTree.getRoot()));
    }
}
