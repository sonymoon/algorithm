package com.bailei.study.jzoffer.interview20;

/**
 * Created by bailei on 16/12/13.
 * 打印二维矩阵，顺时针从外到内打印
 */
public class PrintMatrixInCircle {

    void print(int[][] numbers) {
        if (numbers == null) {
            return;
        }

        int rows = numbers.length;
        if (rows == 0) {
            return;
        }
        int columns = rows > 0 ? numbers[0].length : 0;

        for (int start = 0; 2 * start < rows && 2 * start < columns; start++) {
            print(numbers, rows, columns, start);
        }
    }

    /**
     * four step
     * 1 the row above
     * 2 the column right side
     * 3 the row below
     * 4 the column left side
     *
     * @param numbers
     * @param rows
     * @param columns
     * @param start
     */
    private void print(int[][] numbers, int rows, int columns, int start) {
        if (rows - 2 * start > 0) {
            for (int i = start; i <= columns - 1 - start; i++) {
                System.out.print(numbers[start][i] + "\t");
            }
        }
        if (columns - 2 * start > 0) {
            for (int i = start + 1; i <= rows - 1 - start; i++) {
                System.out.print(numbers[i][columns - start - 1] + "\t");
            }
        }
        if (rows - 2 * start > 1) {
            for (int i = columns - 1 - start - 1; i >= start; i--) {
                System.out.print(numbers[rows - 1 - start][i] + "\t");
            }
        }
        if (columns - 2 * start > 1) {
            for (int i = rows - 1 - start - 1; i >= start + 1; i--) {
                System.out.print(numbers[i][start] + "\t");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[][] numbers1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        new PrintMatrixInCircle().print(numbers1);


        int[][] numbers2 = new int[][]{
                {1, 2, 3, 4}
        };
        new PrintMatrixInCircle().print(numbers2);


        int[][] numbers3 = new int[][]{
                {1},
                {5},
                {9},
                {13}
        };
        new PrintMatrixInCircle().print(numbers3);

        int[][] numbers4 = new int[][]{
                {1}
        };
        new PrintMatrixInCircle().print(numbers4);


        int[][] numbers5 = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},
                {13, 14, 15},
                {20, 21, 22},
                {30, 31, 32}
        };
        new PrintMatrixInCircle().print(numbers5);

    }
}
