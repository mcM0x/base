package de.maxde.base.player.result;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.result.AbstractDatabaseResult;
import org.redisson.api.RedissonClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerExistDatabaseResult extends AbstractDatabaseResult<RedissonClient, Boolean> {

    private UUID uuid;

    public PlayerExistDatabaseResult(UUID uuid, AbstractDatabase<RedissonClient> database) {
        super(database);
        this.uuid = uuid;
    }

    @Override
    public Boolean fetchResult() throws SQLException {
        return database.getConnection().getMap("player:" + uuid).isExists();
    }
}
