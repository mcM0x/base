package de.maxde.base.player.manipulator;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.player.AbstractPlayer;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.sql.Connection;

@AllArgsConstructor
public class PlayerNameManipulator extends AbstractDatabaseManipulator<String> {


    private AbstractPlayer player;
    private AbstractDatabase<RedissonClient> database;

    @Override
    public String get() {
        return (String) database.getConnection().getMap("player:" + player.getUniqueId()).get("username");
    }

    @Override
    public void set(String s) {
        database.getConnection().getMap("player:" + player.getUniqueId()).put("username", s);
    }
}
