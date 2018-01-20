package com.bailei.study.netty.nio;

/**
 * Created by bailei on 16/12/28.
 * NIO 实现回写 时间戳
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }
        MultiplexerTimeServer mutiplexerTimeServer = new MultiplexerTimeServer(port);
        new Thread(mutiplexerTimeServer, "NIO-MultiplexerTimeServer").start();
    }
}
