package de.maxde.base.server.manipulators;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.server.AbstractGameServer;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

@AllArgsConstructor
public class GameServerMaxPlayersManipulator extends AbstractDatabaseManipulator<Integer> {

    private AbstractGameServer gameServer;

    private AbstractDatabase<RedissonClient> database;


    @Override
    public Integer get() {
        return (Integer) database.getConnection().getMap("server:" + gameServer.getName()).get("maxPlayers");
    }

    @Override
    public void set(Integer amount) {
        database.getConnection().getMap("server:" + gameServer.getName()).put("maxPlayers", amount);
    }
}