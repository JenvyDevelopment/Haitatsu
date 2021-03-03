package de.jenvy.haitatsu.api.packet;

public interface HaitatsuPacketFactory {

    void sort();

    void importPacket(HaitatsuPacket packet);

    void importPacket(Class<? extends HaitatsuPacket> packetClass);

    int getPacketId(HaitatsuPacket packet);

    int getPacketId(Class<? extends HaitatsuPacket> packetClass);

    Class<? extends HaitatsuPacket> getPacketClass(int packetId);

    HaitatsuPacket getPacket(int packetId);

}
