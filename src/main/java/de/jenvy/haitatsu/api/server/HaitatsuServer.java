package de.jenvy.haitatsu.api.server;

import de.jenvy.haitatsu.api.packet.HaitatsuPacketFactory;

public interface HaitatsuServer extends Runnable {

    void end();

    int getPort();

    HaitatsuPacketFactory getPacketFactory();

}
