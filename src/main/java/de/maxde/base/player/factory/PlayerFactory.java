package de.maxde.base.player.factory;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.player.AbstractPlayer;
import de.maxde.base.player.impl.PlayerImpl;
import org.redisson.api.RedissonClient;

import java.sql.Connection;
import java.util.UUID;

public class PlayerFactory {

    public static AbstractPlayer create(UUID uuid, AbstractDatabase<RedissonClient> database) {
        return new PlayerImpl(uuid, database);
    }

}
