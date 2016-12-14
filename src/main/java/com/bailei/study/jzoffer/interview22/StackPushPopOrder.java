package com.bailei.study.jzoffer.interview22;

import java.util.Stack;

/**
 * Created by bailei on 2016/12/14.
 */
public class StackPushPopOrder {

    private Stack<Integer> stackForPush;

    private Stack<Integer> stackForPop;

    public StackPushPopOrder() {
        stackForPush = new Stack<>();
        stackForPop = new Stack<>();
    }

    /**
     * 和书中不同的是，用了两个栈，一个存储上一次pop的元素，一个存储push序列的元素
     *
     * @param pushArry
     * @param popArry
     * @return
     */
    public boolean isPopOrder(int[] pushArry, int[] popArry) {
        for (int popValue : popArry) {
            if (!stackForPush.isEmpty() && stackForPush.peek() == popValue) {
                stackForPush.pop();
                stackForPop.push(popValue);
            } else {
                int pushIndex = -1;
                int popIndex = -1;
                for (int i = 0; i < pushArry.length; i++) {
                    if (popValue == pushArry[i]) {
                        pushIndex = i;
                    }
                    if (!stackForPop.isEmpty() && stackForPop.peek() == pushArry[i]) {
                        popIndex = i;
                    }
                }
                if (popIndex > pushIndex) { //pop的元素竟然在push的前面弹出来了
                    return false;
                }
                for (int i = popIndex + 1; i <= pushIndex; i++) {
                    stackForPush.push(pushArry[i]);
                }
                if (stackForPush.peek() == popValue) {
                    stackForPush.pop();
                    stackForPop.push(popValue);
                } else {//该入栈的都入栈了，弹出的数却不在栈顶，只能说明这个数不能在此刻弹出
                    return false;
                }
            }


        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new StackPushPopOrder().isPopOrder(
                new int[]{1, 2, 3, 4, 5},
                new int[]{1, 2, 3, 4, 5}
        ));
    }
}
