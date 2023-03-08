package de.maxde.base.database.config.factory;

import de.maxde.base.database.config.AbstractDatabaseConfig;
import de.maxde.base.database.config.AbstractDatabaseCredentials;
import de.maxde.base.database.config.AbstractDatabaseServer;
import de.maxde.base.database.config.impl.DatabaseConfigImpl;

public class DatabaseConfigFactory {

    public static AbstractDatabaseConfig create(String host, int port, String username, String password, String database) {

        AbstractDatabaseCredentials credentials = DatabaseCredentialsFactory.create(username, password);
        AbstractDatabaseServer server = DatabaseServerFactory.create(host, port, database);

        return new DatabaseConfigImpl(server, credentials);
    }

}
