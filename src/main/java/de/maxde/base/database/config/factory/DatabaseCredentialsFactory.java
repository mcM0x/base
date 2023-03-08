package de.maxde.base.database.config.factory;

import de.maxde.base.database.config.AbstractDatabaseCredentials;
import de.maxde.base.database.config.impl.DatabaseCredentialsImpl;

public class DatabaseCredentialsFactory {

    public static AbstractDatabaseCredentials create(String username, String password){
        return new DatabaseCredentialsImpl(username, password);
    }

}
