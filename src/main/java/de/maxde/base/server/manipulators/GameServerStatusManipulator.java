package de.maxde.base.server.manipulators;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.server.AbstractGameServer;
import de.maxde.base.server.status.GameServerStatus;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

@AllArgsConstructor
public class GameServerStatusManipulator extends AbstractDatabaseManipulator<GameServerStatus> {

    private AbstractGameServer gameServer;
    private AbstractDatabase<RedissonClient> database;

    @Override
    public GameServerStatus get() {
        return GameServerStatus.valueOf((String) database.getConnection().getMap("server:" + gameServer.getName()).get("status"));
    }

    @Override
    public void set(GameServerStatus amount) {
        database.getConnection().getMap("server:" + gameServer.getName()).put("status", amount);
    }
}
