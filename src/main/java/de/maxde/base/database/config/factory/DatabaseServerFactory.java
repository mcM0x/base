package de.maxde.base.database.config.factory;

import de.maxde.base.database.config.AbstractDatabaseServer;
import de.maxde.base.database.config.impl.DatabaseServerImpl;

public class DatabaseServerFactory {

    public static AbstractDatabaseServer create(String host, int port, String database) {
        return new DatabaseServerImpl(host, port, database);
    }

}
