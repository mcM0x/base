package de.maxde.base.uuid.getter;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseGetter;
import de.maxde.base.player.factory.PlayerFactory;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.util.UUID;

@AllArgsConstructor
public class PlayerUsernameGetter extends AbstractDatabaseGetter<String> {

    private UUID uuid;
    private AbstractDatabase<RedissonClient> database;

    @Override
    public String get() {
        return PlayerFactory.create(uuid, database).getNameManipulator().get();
    }
}
