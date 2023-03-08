package de.maxde.base.database.factory;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.config.AbstractDatabaseConfig;
import de.maxde.base.database.impl.RedisSingleServerDatabase;
import org.redisson.api.RedissonClient;

import java.sql.Connection;

public class DatabaseFactory {

    public static AbstractDatabase<RedissonClient> createRedisDatabase(AbstractDatabaseConfig config) {
        return new RedisSingleServerDatabase(config);
    }

}
