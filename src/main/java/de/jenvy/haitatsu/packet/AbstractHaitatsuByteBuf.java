package de.jenvy.haitatsu.packet;

import de.jenvy.haitatsu.api.packet.HaitatsuByteBuf;
import de.jenvy.haitatsu.misc.Utility;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class AbstractHaitatsuByteBuf implements HaitatsuByteBuf {

    private final ByteBuf byteBuf;

    public AbstractHaitatsuByteBuf(@NotNull ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    @Override
    public void writeList(@NotNull List<?> param) {
        this.writeString(Utility.listToString(param));
    }

    @Override
    public void writeList(@NotNull List<?> param, @NotNull String delimiter) {
        this.writeString(Utility.listToString(param, delimiter));
    }

    @Override
    @NotNull
    public List<String> readList() {
        return Utility.stringToList(this.readString());
    }

    @Override
    @NotNull
    public List<String> readList(@NotNull String delimiter) {
        return Utility.stringToList(this.readString(), delimiter);
    }

    @Override
    public void writeString(@NotNull String param) {
        if (param.isEmpty())
            throw new IllegalArgumentException("Parameters are empty.");
        this.byteBuf.writeInt(param.length());
        this.byteBuf.writeBytes(param.getBytes());
    }

    @Override
    @NotNull
    public String readString() {
        int length = this.byteBuf.readInt();
        byte[] bytes = new byte[length];
        this.byteBuf.readBytes(bytes, 0, length);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    public void writeInt(int param) {
        this.byteBuf.writeInt(param);
    }

    @Override
    public int readInt() {
        return this.byteBuf.readInt();
    }

    @Override
    public void writeShort(short param) {
        this.byteBuf.writeShort(param);
    }

    @Override
    public short readShort() {
        return this.byteBuf.readShort();
    }

    @Override
    public void writeLong(long param) {
        this.byteBuf.writeLong(param);
    }

    @Override
    public long readLong() {
        return this.byteBuf.readLong();
    }

    @Override
    public void writeFloat(float param) {
        this.byteBuf.writeFloat(param);
    }

    @Override
    public float readFloat() {
        return this.byteBuf.readFloat();
    }

    @Override
    public void writeDouble(double param) {
        this.byteBuf.writeDouble(param);
    }

    @Override
    public double readDouble() {
        return this.byteBuf.readDouble();
    }

    @Override
    public void writeChar(char param) {
        this.byteBuf.writeChar(param);
    }

    @Override
    public char readChar() {
        return this.byteBuf.readChar();
    }

    @Override
    @NotNull
    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }
}
