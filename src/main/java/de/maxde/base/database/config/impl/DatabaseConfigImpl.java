package de.maxde.base.database.config.impl;

import de.maxde.base.database.config.AbstractDatabaseConfig;
import de.maxde.base.database.config.AbstractDatabaseCredentials;
import de.maxde.base.database.config.AbstractDatabaseServer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DatabaseConfigImpl extends AbstractDatabaseConfig {

    private AbstractDatabaseServer databaseServer;
    private AbstractDatabaseCredentials databaseCredentials;

}
