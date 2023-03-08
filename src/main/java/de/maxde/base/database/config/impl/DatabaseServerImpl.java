package de.maxde.base.database.config.impl;

import de.maxde.base.database.config.AbstractDatabaseServer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DatabaseServerImpl extends AbstractDatabaseServer {

    private String host;
    private int port;
    private String databaseName;

}
