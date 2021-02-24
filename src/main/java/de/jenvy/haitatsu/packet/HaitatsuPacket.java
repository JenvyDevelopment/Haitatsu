package de.jenvy.haitatsu.packet;

public interface HaitatsuPacket {

    int getId();

    void set(HaitatsuByteBuf byteBuffer);

    void get(HaitatsuByteBuf byteBuffer);

}
