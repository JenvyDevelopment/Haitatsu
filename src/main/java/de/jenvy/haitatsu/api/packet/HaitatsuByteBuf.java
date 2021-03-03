package de.jenvy.haitatsu.api.packet;

import io.netty.buffer.ByteBuf;

import java.util.List;

public interface HaitatsuByteBuf {

    void writeList(List<?> param);

    void writeList(List<?> param, String delimiter);

    List<String> readList();

    List<String> readList(String delimiter);

    void writeString(String param);

    String readString();

    void writeInt(int param);

    int readInt();

    void writeShort(short param);

    short readShort();

    void writeLong(long param);

    long readLong();

    void writeFloat(float param);

    float readFloat();

    void writeDouble(double param);

    double readDouble();

    void writeChar(char param);

    char readChar();

    ByteBuf getByteBuf();

}
