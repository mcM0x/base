package de.maxde.base.player.manipulator;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.player.AbstractPlayer;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class PlayerCoinManipulator extends AbstractDatabaseManipulator<Integer> {

    private AbstractPlayer player;
    private AbstractDatabase<RedissonClient> database;


    @Override
    public Integer get() {
        return (Integer) database.getConnection().getMap("player:" + player.getUniqueId()).get("coins");
    }

    @Override
    public void set(Integer amount) {
        database.getConnection().getMap("player:" + player.getUniqueId()).put("coins", amount);
    }
}
