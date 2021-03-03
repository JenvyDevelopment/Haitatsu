package de.jenvy.haitatsu.api.packet;

import de.jenvy.haitatsu.packet.AbstractHaitatsuByteBuf;

public interface HaitatsuPacket {

    void set(AbstractHaitatsuByteBuf byteBuffer);

    void get(AbstractHaitatsuByteBuf byteBuffer);

}
