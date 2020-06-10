package com.gerson.design.fillchain;

/**
 * 对外的接口
 * @author gezz
 * @description
 * @date 2020/5/28.
 */
public interface ChannelHandler {

    void channelRead(ChannelHandlerContext ctx, Object msg);

    void channelWrite(ChannelHandlerContext ctx);
}
