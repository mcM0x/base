package de.maxde.base.database.config;

public abstract class AbstractDatabaseConfig {

    public abstract AbstractDatabaseServer getDatabaseServer();

    public abstract AbstractDatabaseCredentials getDatabaseCredentials();

}
