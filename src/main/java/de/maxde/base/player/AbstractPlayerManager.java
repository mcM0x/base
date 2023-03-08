package de.maxde.base.player;

import java.util.UUID;

public abstract class AbstractPlayerManager {

    public abstract AbstractPlayer getPlayer(UUID uuid);

    public abstract void registerNewPlayer(UUID playerUUID, String playerName);

    public abstract boolean exists(UUID uuid);

}
