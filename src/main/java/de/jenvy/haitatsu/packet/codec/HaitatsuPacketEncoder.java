package de.jenvy.haitatsu.packet.codec;

import de.jenvy.haitatsu.api.packet.HaitatsuPacket;
import de.jenvy.haitatsu.api.packet.HaitatsuPacketFactory;
import de.jenvy.haitatsu.packet.AbstractHaitatsuByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class HaitatsuPacketEncoder extends MessageToByteEncoder<HaitatsuPacket> {

    private final HaitatsuPacketFactory packetFactory;

    public HaitatsuPacketEncoder(HaitatsuPacketFactory packetFactory) {
        this.packetFactory = packetFactory;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, HaitatsuPacket msg, ByteBuf out) {
        out.writeInt(this.packetFactory.getPacketId(msg));
        msg.set(new AbstractHaitatsuByteBuf(out));
    }
}
