package com.ddup.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/9/21
 */
public class NettyClientOutHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("write");
        super.write(ctx,msg,promise);
    }
}
