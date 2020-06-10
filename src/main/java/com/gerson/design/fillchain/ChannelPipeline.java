package com.gerson.design.fillchain;

/**
 * @author gezz
 * @description
 * @date 2020/5/28.
 */
public interface ChannelPipeline {

    void addLast(ChannelHandler channelHandler);
}
