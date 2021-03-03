package de.jenvy.haitatsu.packet;

import de.jenvy.haitatsu.api.packet.HaitatsuPacket;
import de.jenvy.haitatsu.api.packet.HaitatsuPacketFactory;
import de.jenvy.haitatsu.misc.NoSuchPacketException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;

public class AbstractHaitatsuPacketFactory implements HaitatsuPacketFactory {

    private final ArrayList<Class<? extends HaitatsuPacket>> packetList = new ArrayList<>();

    @Override
    public void sort() {
        packetList.sort((Comparator.comparing(Class::getName)));
    }

    @Override
    public void importPacket(HaitatsuPacket packet) {
        importPacket(packet.getClass());
    }

    @Override
    public void importPacket(Class<? extends HaitatsuPacket> packetClass) {
        if (this.packetList.contains(packetClass)) throw new IllegalArgumentException("Packet is already bound.");
        this.packetList.add(packetClass);
    }

    @Override
    public int getPacketId(HaitatsuPacket packet) {
        return getPacketId(packet.getClass());
    }

    @Override
    public int getPacketId(Class<? extends HaitatsuPacket> packetClass) {
        return packetList.indexOf(packetClass);
    }

    @Override
    public Class<? extends HaitatsuPacket> getPacketClass(int packetId) {
        return this.packetList.get(packetId);
    }

    @Override
    public HaitatsuPacket getPacket(int packetId) {
        if (this.packetList.get(packetId) == null) {
            throw new NoSuchPacketException("The given ID has no associated packet");
        }
        try {
            return this.getPacketClass(packetId).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
