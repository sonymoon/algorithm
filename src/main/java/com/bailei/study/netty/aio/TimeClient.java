package com.bailei.study.netty.aio;

/**
 * Created by bailei on 16/12/28.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 1) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }
        AsyncTimeClientHandler clientHandler = new AsyncTimeClientHandler("127.0.0.1", port);
        new Thread(clientHandler, "AIO-AsyncTimeClientHandler-001").start();
    }
}
