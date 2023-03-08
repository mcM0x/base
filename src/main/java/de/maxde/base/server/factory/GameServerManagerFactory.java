package de.maxde.base.server.factory;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.server.AbstractGameServerManager;
import de.maxde.base.server.impl.GameServerManagerImpl;
import org.redisson.api.RedissonClient;

public class GameServerManagerFactory {

    public static AbstractGameServerManager create(AbstractDatabase<RedissonClient> database) {
        return new GameServerManagerImpl(database);
    }

}
