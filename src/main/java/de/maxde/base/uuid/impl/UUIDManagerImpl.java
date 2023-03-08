package de.maxde.base.uuid.impl;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseGetter;
import de.maxde.base.uuid.AbstractUUIDManager;
import de.maxde.base.uuid.getter.PlayerUUIDGetter;
import de.maxde.base.uuid.getter.PlayerUsernameGetter;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.util.UUID;

@AllArgsConstructor
public class UUIDManagerImpl extends AbstractUUIDManager {

    private AbstractDatabase<RedissonClient> database;

    @Override
    public AbstractDatabaseGetter<String> getUsername(UUID uuid) {
        return new PlayerUsernameGetter(uuid, database);
    }

    @Override
    public AbstractDatabaseGetter<UUID> getUniqueId(String username) {
        return new PlayerUUIDGetter(username, database);
    }
}
