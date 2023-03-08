package de.maxde.base.player.manipulator;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.player.AbstractPlayer;
import de.maxde.base.player.rank.AbstractRank;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.sql.Connection;

@AllArgsConstructor
public class PlayerRankManipulator extends AbstractDatabaseManipulator<AbstractRank> {

    private AbstractPlayer player;
    private AbstractDatabase<RedissonClient> database;

    @Override
    public AbstractRank get() {
        return null;
    }

    @Override
    public void set(AbstractRank abstractRank) {

    }
}
