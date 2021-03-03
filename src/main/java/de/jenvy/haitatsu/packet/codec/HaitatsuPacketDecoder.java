package de.jenvy.haitatsu.packet.codec;

import de.jenvy.haitatsu.api.packet.HaitatsuPacket;
import de.jenvy.haitatsu.api.packet.HaitatsuPacketFactory;
import de.jenvy.haitatsu.packet.AbstractHaitatsuByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class HaitatsuPacketDecoder extends ByteToMessageDecoder {

    private final HaitatsuPacketFactory packetFactory;

    public HaitatsuPacketDecoder(HaitatsuPacketFactory packetFactory) {
        this.packetFactory = packetFactory;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        HaitatsuPacket packet = this.packetFactory.getPacket(in.readInt());
        packet.get(new AbstractHaitatsuByteBuf(in));
        in.clear();
        out.add(packet);
    }
}
