package com.bailei.study.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;

/**
 * Created by bailei on 16/12/29.
 */
public class EchoClient {

    public void connect(String host, int port) {
        Bootstrap client = new Bootstrap();
        client.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(
                                1024
                                , Unpooled.copiedBuffer("$_".getBytes())));
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new EchoClientHandler());
                    }
                });
        try {
            ChannelFuture future = client.connect(new InetSocketAddress(host, port)).sync();
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            client.group().shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new EchoClient().connect("127.0.0.1", 8080);
    }

}
