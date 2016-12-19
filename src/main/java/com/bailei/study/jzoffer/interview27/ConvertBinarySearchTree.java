package com.bailei.study.jzoffer.interview27;

import com.bailei.study.utils.StdOut;

/**
 * Created by bailei on 2016/12/19.
 * 将一个二叉搜索树转换成一个排序的双向链表
 * 要求，不能创建新的结点，只能调整结点指针的指向
 * 二叉搜索树的构建 引用了算法4中的实现
 */
public class ConvertBinarySearchTree {

    public void convert(BST bst) {
        BST.Node root = bst.getRoot();  //改了BST.Node可见性为包级别
        

    }


    public static void main(String[] args) {
        BST<Integer, Integer> st = new BST<>();
        st.put(10, 10).put(6, 6).put(14, 14).put(4, 4).put(8, 8)
                .put(12, 12).put(16, 16);
        for (Integer s : st.levelOrder())
            StdOut.println(s + "<->" + st.get(s));
        StdOut.println();


    }
}
