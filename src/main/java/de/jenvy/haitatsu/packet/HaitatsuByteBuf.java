package de.jenvy.haitatsu.packet;

import de.jenvy.haitatsu.misc.Utility;
import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HaitatsuByteBuf {

    private final ByteBuf byteBuf;

    public HaitatsuByteBuf(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    public void writeList(List<?> param) {
        this.writeString(Utility.listToString(param));
    }

    public void writeList(List<?> param, String delimiter) {
        this.writeString(Utility.listToString(param, delimiter));
    }

    public List<String> readList() {
        return Utility.stringToList(this.readString());
    }

    public List<String> readList(String delimiter) {
        return Utility.stringToList(this.readString(), delimiter);
    }

    public void writeString(String param) {
        if (param == null || param.isEmpty())
            throw new NullPointerException();
        this.byteBuf.writeInt(param.length());
        this.byteBuf.writeBytes(param.getBytes());
    }

    public String readString() {
        int length = this.byteBuf.readInt();
        byte[] bytes = new byte[length];
        this.byteBuf.readBytes(bytes, 0, length);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public void writeInt(int param) {
        this.byteBuf.writeInt(param);
    }

    public int readInt() {
        return this.byteBuf.readInt();
    }

    public void writeShort(short param) {
        this.byteBuf.writeShort(param);
    }

    public short readShort() {
        return this.byteBuf.readShort();
    }

    public void writeLong(long param) {
        this.byteBuf.writeLong(param);
    }

    public long readLong() {
        return this.byteBuf.readLong();
    }

    public void writeFloat(float param) {
        this.byteBuf.writeFloat(param);
    }

    public float readFloat() {
        return this.byteBuf.readFloat();
    }

    public void writeDouble(double param) {
        this.byteBuf.writeDouble(param);
    }

    public double readDouble() {
        return this.byteBuf.readDouble();
    }

    public void writeChar(char param) {
        this.byteBuf.writeChar(param);
    }

    public char readChar() {
        return this.byteBuf.readChar();
    }

    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }
}
