package de.maxde.base.server.impl;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.server.AbstractGameServer;
import de.maxde.base.server.AbstractGameServerManager;
import de.maxde.base.server.factory.GameServerFactory;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@AllArgsConstructor
public class GameServerManagerImpl extends AbstractGameServerManager {

    private AbstractDatabase<RedissonClient> database;

    @Override
    public AbstractGameServer getGameServer(String name) {
        return GameServerFactory.create(name, database);
    }

    @Override
    public boolean exists(String name) {
        return database.getConnection().getMap("server:" + name).isExists();
    }

    @Override
    public Collection<AbstractGameServer> getAllGameServers() {
        Iterable<String> iterator = database.getConnection().getKeys().getKeysByPattern("server:*");

        Set<AbstractGameServer> result = new HashSet<>();

        for (String s : iterator) {
            String serverName = s.split(":")[1];
            result.add(getGameServer(serverName));
        }

        return result;
    }

    @Override
    public Collection<AbstractGameServer> getAlLGameServers(Predicate<AbstractGameServer>... predicates) {


        Collection<AbstractGameServer> allGameServers = getAllGameServers();

        for (AbstractGameServer server : allGameServers) {
            for (Predicate<AbstractGameServer> predicate : predicates) {
                if (!predicate.test(server)) {
                    allGameServers.remove(server);
                }
            }
        }

        return allGameServers;
    }
}
