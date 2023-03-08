package de.maxde.base.uuid.factory;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.uuid.AbstractUUIDManager;
import de.maxde.base.uuid.impl.UUIDManagerImpl;
import org.redisson.api.RedissonClient;

public class UUIDManagerFactory {

    public static AbstractUUIDManager create(AbstractDatabase<RedissonClient> database) {
        return new UUIDManagerImpl(database);
    }

}
