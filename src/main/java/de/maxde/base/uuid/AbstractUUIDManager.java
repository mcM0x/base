package de.maxde.base.uuid;

import de.maxde.base.database.manipulator.AbstractDatabaseGetter;

import java.util.UUID;

public abstract class AbstractUUIDManager {

    public abstract AbstractDatabaseGetter<String> getUsername(UUID uuid);

    public abstract AbstractDatabaseGetter<UUID> getUniqueId(String username);

}
