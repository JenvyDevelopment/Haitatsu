package de.jenvy.haitatsu.server;

import de.jenvy.haitatsu.api.packet.HaitatsuPacketFactory;
import de.jenvy.haitatsu.api.server.HaitatsuServer;
import org.jetbrains.annotations.Nullable;

public class AbstractHaitatsuServer implements HaitatsuServer {

    @Override
    public void run() {

    }

    @Override
    public void end() {

    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    @Nullable
    public HaitatsuPacketFactory getPacketFactory() {
        return null;
    }
}
