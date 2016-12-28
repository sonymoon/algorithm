package com.bailei.study.nio;

/**
 * Created by bailei on 16/12/28.
 */
public class TimeClient {


    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        new Thread(new TimeClientHandler("127.0.0.1", port)).start();
    }
}
