package com.bailei.study.jzoffer.interview4;

/**
 * Created by bailei on 16/12/3.
 * 替换空格为％20
 */
public class ReplaceCharSpace {

    public char[] replace(char[] chars) {
        int length = chars.length;
        int spaceNumbers = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                ++spaceNumbers;
            }
        }
        char[] newChars = new char[length + spaceNumbers * 2];
        for (int i = length - 1, j = newChars.length - 1; i >= 0 && j >= 0; ) {
            if (chars[i] == ' ') {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';

                --i;
            } else {
                newChars[j--] = chars[i--];
            }
        }
        return newChars;
    }


    public static void main(String[] args) {
        ReplaceCharSpace replaceCharSpace = new ReplaceCharSpace();
        char[] chars = new char[]{'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y'};
        chars = replaceCharSpace.replace(chars);
        System.out.println(String.valueOf(chars));
    }

}
