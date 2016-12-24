package com.bailei.study.jvm;

/**
 * Created by bailei on 16/12/23.
 */
public class DeadLockDemo {

    static class SynAddRunable implements Runnable {
        int a, b;

        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new SynAddRunable(1, 2)).start();
        new Thread(new SynAddRunable(2, 1)).start();
    }
}
