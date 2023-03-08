package de.maxde.base.server.factory;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.server.AbstractGameServer;
import de.maxde.base.server.impl.GameServerImpl;
import org.redisson.api.RedissonClient;

public class GameServerFactory {

    public static AbstractGameServer create(String name, AbstractDatabase<RedissonClient> database){
        return new GameServerImpl(name, database);
    }

}
