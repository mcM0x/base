package de.maxde.base.player.impl;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.player.AbstractPlayer;
import de.maxde.base.player.AbstractPlayerManager;
import de.maxde.base.player.factory.PlayerFactory;
import de.maxde.base.player.result.PlayerExistDatabaseResult;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.sql.SQLException;
import java.util.UUID;

@AllArgsConstructor
public class PlayerManagerImpl extends AbstractPlayerManager {

    private AbstractDatabase<RedissonClient> database;

    @Override
    public AbstractPlayer getPlayer(UUID uuid) {
        return PlayerFactory.create(uuid, database);
    }

    @Override
    public void registerNewPlayer(UUID playerUUID, String playerName) {

    }

    @Override
    public boolean exists(UUID uuid) {
        try {
            return new PlayerExistDatabaseResult(uuid, this.database).fetchResult();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
