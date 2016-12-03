package com.bailei.study.jzoffer.interview3;

/**
 * Created by bailei on 16/12/3.
 * 排序二维数组查找
 * 每一行从左至右递增
 * 每一列从上到下递增
 */
public class TwoDimensionArray {
    private static int arr[][] = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}};


    public static boolean find(int value) {
        int rowLength = arr.length;
        int columnLength = 0;
        if (rowLength > 0) {
            columnLength = arr[0].length; //第一行的长度，就是列宽
        }
        if (rowLength < 1 || columnLength < 1) {
            return false;
        }

        for (int row = 0, column = columnLength - 1; row < rowLength && column >= 0; ) {//从右上角开始查找
            if (value > arr[row][column]) {
                ++row;
            } else if (value < arr[row][column]) {
                --column;
            } else { //find
                System.out.println("row: " + (row + 1) + ", column: " + (column + 1));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find(1));
        System.out.println(find(15));
        System.out.println(find(9));
        System.out.println(find(100));
    }
}
