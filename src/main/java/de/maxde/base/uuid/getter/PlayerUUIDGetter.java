package de.maxde.base.uuid.getter;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseGetter;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.util.UUID;

@AllArgsConstructor
public class PlayerUUIDGetter extends AbstractDatabaseGetter<UUID> {

    private String username;
    private AbstractDatabase<RedissonClient> database;

    @Override
    public UUID get() {
        return UUID.fromString((String) database.getConnection().getMap("usernames").get(username.toLowerCase()));
    }
}
