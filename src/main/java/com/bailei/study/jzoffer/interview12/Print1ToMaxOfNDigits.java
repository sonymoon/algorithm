package com.bailei.study.jzoffer.interview12;

/**
 * Created by bailei on 16/12/7.
 * 打印N位数 从1到999.。。。
 */
public class Print1ToMaxOfNDigits {

    /**
     * 自增1方式
     *
     * @param N
     */
    public void print1ToMaxNDigits(int N) {
        if (N <= 0) {
            System.out.println("invalid N, must greater than 0");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(N);
        for (int i = 0; i < N; i++) { //init
            stringBuilder.append('0');
        }

//        while (!incrementByOne(stringBuilder)) {
//            printStrOfNumber(stringBuilder);
//        }
        print1ToMaxNRecursively(stringBuilder, 0);
    }

    private void print1ToMaxNRecursively(StringBuilder number, int index) {
        if (index > number.length() - 1) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            number.setCharAt(index, (char) (i + 48));
            printStrOfNumber(number);
            print1ToMaxNRecursively(number, index + 1);
        }

    }


    private boolean incrementByOne(StringBuilder stringBuilder) {
        boolean isOverFlow = false; //是否溢出
        int takeOverDigits = 0; //进位标识
        int sum;

        for (int i = stringBuilder.length() - 1; i >= 0; --i) {
            sum = (stringBuilder.charAt(i) - '0') + takeOverDigits;
            if (i == stringBuilder.length() - 1) {
                ++sum;
            }
            if (sum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    sum -= 10;
                    takeOverDigits = 1;
                    stringBuilder.setCharAt(i, (char) (sum + 48));
                }

            } else {
                takeOverDigits = 0;
                stringBuilder.setCharAt(i, (char) (sum + 48));
            }
        }
        return isOverFlow;
    }


    private void printStrOfNumber(StringBuilder number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                System.out.print(number.subSequence(i, number.length()));
                break;
            }
        }
        System.out.print(", ");
    }


    public static void main(String[] args) {
        new Print1ToMaxOfNDigits().print1ToMaxNDigits(3);
    }
}
