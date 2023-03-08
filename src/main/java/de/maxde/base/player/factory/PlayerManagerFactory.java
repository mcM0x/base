package de.maxde.base.player.factory;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.player.AbstractPlayerManager;
import de.maxde.base.player.impl.PlayerManagerImpl;
import org.redisson.api.RedissonClient;

import java.sql.Connection;

public class PlayerManagerFactory {

    public static AbstractPlayerManager create(AbstractDatabase<RedissonClient> database) {
        return new PlayerManagerImpl(database);
    }

}
