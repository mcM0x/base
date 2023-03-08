package de.maxde.base.server;

import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.server.status.GameServerStatus;

public abstract class AbstractGameServer {

    public abstract String getName();

    public abstract AbstractDatabaseManipulator<Integer> getOnlinePlayerCountManipulator();

    public abstract AbstractDatabaseManipulator<Integer> getMaxPlayersManipulator();

    public abstract AbstractDatabaseManipulator<GameServerStatus> getStatusManipulator();


}
