package com.puyan.shengren.agricultural.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author JHS
 */
public class MyEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        String[] str = o.toString().split(" ");
        byteBuf.writeBytes(toByteArray(o.toString()));
        //byteBuf.writeBytes(o.toString().getBytes());
    }

    public byte[] toByteArray(String string) {
        String[] s = string.split(" ");
        byte[] by = new byte[s.length];
        for (int i = 0; i < s.length; i++) {
            by[i] = (byte) Integer.parseInt(s[i], 16);
        }
        return by;
    }
}
