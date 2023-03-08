package de.maxde.base.database.impl;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.config.AbstractDatabaseConfig;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

@RequiredArgsConstructor
public class RedisSingleServerDatabase extends AbstractDatabase<RedissonClient> {

    private RedissonClient client;

    private final AbstractDatabaseConfig databaseConfig;

    @Override
    public void connect() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + databaseConfig.getDatabaseServer().getHost() + ":" + databaseConfig.getDatabaseServer().getPort());
    }

    @Override
    public void disconnect() {
        this.client = null;
    }

    @Override
    public RedissonClient getConnection() {
        return client;
    }

    @Override
    public AbstractDatabaseConfig getConfig() {
        return databaseConfig;
    }
}
