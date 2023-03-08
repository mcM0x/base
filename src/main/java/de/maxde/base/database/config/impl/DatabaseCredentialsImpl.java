package de.maxde.base.database.config.impl;

import de.maxde.base.database.config.AbstractDatabaseCredentials;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DatabaseCredentialsImpl extends AbstractDatabaseCredentials {

    private String username;
    private String password;

}
