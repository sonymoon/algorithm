package com.bailei.study.jzoffer.interview24;

/**
 * Created by bailei on 16/12/17.
 * 判断某序列是不是二叉搜索树的后续遍历序列
 */
public class IsPostOrder {


    public boolean check(int[] arry) {
        if (arry == null || arry.length == 0) {
            return false;
        }
        return check(arry, 0, arry.length - 1);
    }

    private boolean check(int[] arry, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        }
        int root = arry[endIndex];
        int leftIndex = startIndex - 1, rightIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            leftIndex = i - 1;
            if (arry[i] >= root) {
                break;
            }
        }
        rightIndex = leftIndex + 1;
        if (leftIndex >= startIndex && leftIndex <= endIndex) { //左子树所有结点必须小于跟节点
            for (int i = startIndex; i <= leftIndex; i++) {
                if (arry[i] > root) {
                    return false;
                }
            }
            return check(arry, startIndex, leftIndex); //左子树序列递归验证
        }
        if (rightIndex >= startIndex && rightIndex <= endIndex) {//左子树所有结点必须大于跟节点
            for (int i = rightIndex; i <= endIndex; i++) {
                if (arry[i] < root) {
                    return false;
                }
            }
            return check(arry, rightIndex, endIndex - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPostOrder().check(new int[]{}));
        System.out.println(new IsPostOrder().check(new int[]{1})); //只有一个结点
        System.out.println(new IsPostOrder().check(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(new IsPostOrder().check(new int[]{7, 4, 6, 5}));
        System.out.println(new IsPostOrder().check(new int[]{11, 10, 8})); //没有右子结点
        System.out.println(new IsPostOrder().check(new int[]{5, 6, 8})); //没有左子结点
    }

}
