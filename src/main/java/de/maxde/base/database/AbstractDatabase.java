package de.maxde.base.database;

import de.maxde.base.database.config.AbstractDatabaseConfig;

import java.sql.SQLException;

public abstract class AbstractDatabase<C> {

    public abstract void connect();

    public abstract void disconnect();

    public abstract C getConnection();

    public abstract AbstractDatabaseConfig getConfig();

}
