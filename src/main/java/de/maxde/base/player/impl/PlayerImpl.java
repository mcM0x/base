package de.maxde.base.player.impl;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.database.manipulator.AbstractDatabaseManipulator;
import de.maxde.base.player.AbstractPlayer;
import de.maxde.base.player.manipulator.PlayerCoinManipulator;
import de.maxde.base.player.manipulator.PlayerNameManipulator;
import de.maxde.base.player.manipulator.PlayerRankManipulator;
import de.maxde.base.player.rank.AbstractRank;
import org.redisson.api.RedissonClient;

import java.util.UUID;

public class PlayerImpl extends AbstractPlayer {


    private UUID uuid;
    private final AbstractDatabaseManipulator<String> nameManipulator;
    private final AbstractDatabaseManipulator<AbstractRank> rankManipulator;
    private final AbstractDatabaseManipulator<Integer> coinManipulator;

    public PlayerImpl(UUID uuid, AbstractDatabase<RedissonClient> database) {
        this.uuid = uuid;

        this.nameManipulator = new PlayerNameManipulator(this, database);
        this.rankManipulator = new PlayerRankManipulator(this, database);
        this.coinManipulator = new PlayerCoinManipulator(this, database);

    }

    @Override
    public UUID getUniqueId() {
        return uuid;
    }

    @Override
    public AbstractDatabaseManipulator<String> getNameManipulator() {
        return this.nameManipulator;
    }

    @Override
    public AbstractDatabaseManipulator<AbstractRank> getRankManipulator() {
        return this.rankManipulator;
    }

    @Override
    public AbstractDatabaseManipulator<Integer> getCoinManipulator() {
        return this.coinManipulator;
    }

}
