package de.maxde.base.server.impl;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.server.AbstractGameServer;
import de.maxde.base.server.manipulators.GameServerMaxPlayersManipulator;
import de.maxde.base.server.manipulators.GameServerOnlinePlayerCountManipulator;
import de.maxde.base.server.manipulators.GameServerStatusManipulator;
import de.maxde.base.server.status.GameServerStatus;
import org.redisson.api.RedissonClient;

public class GameServerImpl extends AbstractGameServer {

    private final String name;
    private final AbstractDatabase<RedissonClient> database;

    private AbstractDatabaseManipulator<Integer> onlinePlayerCountManipulator;
    private AbstractDatabaseManipulator<Integer> maxPlayersManipulator;
    private AbstractDatabaseManipulator<GameServerStatus> statusManipulator;

    public GameServerImpl(String name, AbstractDatabase<RedissonClient> database) {
        this.name = name;
        this.database = database;

        this.onlinePlayerCountManipulator = new GameServerOnlinePlayerCountManipulator(this, database);
        this.maxPlayersManipulator = new GameServerMaxPlayersManipulator(this, database);
        this.statusManipulator = new GameServerStatusManipulator(this, database);

    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public AbstractDatabaseManipulator<Integer> getOnlinePlayerCountManipulator() {
        return this.onlinePlayerCountManipulator;
    }

    @Override
    public AbstractDatabaseManipulator<Integer> getMaxPlayersManipulator() {
        return this.maxPlayersManipulator;
    }

    @Override
    public AbstractDatabaseManipulator<GameServerStatus> getStatusManipulator() {
        return this.statusManipulator;
    }
}
