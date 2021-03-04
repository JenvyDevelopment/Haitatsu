package de.jenvy.haitatsu.packet.codec;

import de.jenvy.haitatsu.api.packet.HaitatsuPacketFactory;
import de.jenvy.haitatsu.packet.AbstractHaitatsuByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HaitatsuPacketDecoder extends ByteToMessageDecoder {

    private final HaitatsuPacketFactory packetFactory;

    public HaitatsuPacketDecoder(@NotNull HaitatsuPacketFactory packetFactory) {
        this.packetFactory = packetFactory;
    }

    @Override
    protected void decode(@NotNull ChannelHandlerContext ctx, @NotNull ByteBuf in, @NotNull List<Object> out) {
        var packet = this.packetFactory.getPacket(in.readInt());
        packet.get(new AbstractHaitatsuByteBuf(in));
        in.clear();
        out.add(packet);
    }
}
