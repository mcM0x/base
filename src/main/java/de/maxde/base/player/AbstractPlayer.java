package de.maxde.base.player;

import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.player.rank.AbstractRank;

import java.util.UUID;

public abstract class AbstractPlayer {

    public abstract UUID getUniqueId();

    public abstract AbstractDatabaseManipulator<String> getNameManipulator();

    public abstract AbstractDatabaseManipulator<AbstractRank> getRankManipulator();

    public abstract AbstractDatabaseManipulator<Integer> getCoinManipulator();


}
