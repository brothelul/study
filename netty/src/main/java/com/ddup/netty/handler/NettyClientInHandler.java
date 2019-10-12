package com.ddup.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/9/21
 */
public class NettyClientInHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("inactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        Scanner scanner = new Scanner(System.in);
       // while (true) {
            String data = scanner.nextLine();
            byte[] request = data.getBytes();
            ByteBuf byteBuf = Unpooled.buffer(request.length);
            byteBuf.writeBytes(request);
            ctx.writeAndFlush(byteBuf);
       // }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        System.out.println(new String(req, StandardCharsets.UTF_8));

        Scanner scanner = new Scanner(System.in);
        // while (true) {
        String data = scanner.nextLine();
        byte[] request = data.getBytes();
         byteBuf = Unpooled.buffer(request.length);
        byteBuf.writeBytes(request);
        ctx.writeAndFlush(byteBuf);
        // }
    }
}
