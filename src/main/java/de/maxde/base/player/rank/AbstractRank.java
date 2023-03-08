package de.maxde.base.player.rank;

import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.player.rank.permissions.AbstractPermissionList;

public abstract class AbstractRank {

    public abstract AbstractDatabaseManipulator<String> getName();

    public abstract AbstractDatabaseManipulator<String> getPrefix();

    public abstract AbstractDatabaseManipulator<String> getColorCode();

    public abstract AbstractDatabaseManipulator<AbstractPermissionList> getPermissions();

}
