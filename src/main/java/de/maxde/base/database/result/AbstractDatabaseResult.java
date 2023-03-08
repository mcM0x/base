package de.maxde.base.database.result;

import de.maxde.base.database.AbstractDatabase;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDatabaseResult<C, T> {

    protected final AbstractDatabase<C> database;

    protected AbstractDatabaseResult(AbstractDatabase<C> database) {
        this.database = database;
    }

    public abstract T fetchResult() throws SQLException;

}
