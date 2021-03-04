package de.jenvy.haitatsu.packet;

import de.jenvy.haitatsu.api.packet.HaitatsuPacket;
import de.jenvy.haitatsu.api.packet.HaitatsuPacketFactory;
import de.jenvy.haitatsu.misc.NoSuchPacketException;
import org.jetbrains.annotations.NotNull;

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
    public void importPacket(@NotNull HaitatsuPacket packet) {
        importPacket(packet.getClass());
    }

    @Override
    public void importPacket(@NotNull Class<? extends HaitatsuPacket> packetClass) {
        if (this.packetList.contains(packetClass)) throw new IllegalArgumentException("Packet is already bound.");
        this.packetList.add(packetClass);
    }

    @Override
    public int getPacketId(@NotNull HaitatsuPacket packet) {
        return getPacketId(packet.getClass());
    }

    @Override
    public int getPacketId(@NotNull Class<? extends HaitatsuPacket> packetClass) {
        return packetList.indexOf(packetClass);
    }

    @Override
    @NotNull
    public Class<? extends HaitatsuPacket> getPacketClass(int packetId) {
        return this.packetList.get(packetId);
    }

    @Override
    @NotNull
    public HaitatsuPacket getPacket(int packetId) {
        if (this.packetList.get(packetId) == null) {
            throw new NoSuchPacketException("The given ID has no associated packet");
        }
        try {
            return this.getPacketClass(packetId).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new NoSuchPacketException("Error while loading associated packet");
    }

}
