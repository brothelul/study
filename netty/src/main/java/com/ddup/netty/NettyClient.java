package com.ddup.netty;

import com.ddup.netty.handler.NettyClientInHandler;
import com.ddup.netty.handler.NettyClientOutHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/9/21
 */
public class NettyClient {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap().group(group)
                .option(ChannelOption.TCP_NODELAY, true)
                .remoteAddress("39.105.121.64", 9458).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyClientInHandler());
                        ch.pipeline().addLast(new NettyClientOutHandler());
                    }
                });
        try {
            ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
