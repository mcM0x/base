package de.maxde.base.server;

import java.util.Collection;
import java.util.function.Predicate;

public abstract class AbstractGameServerManager {

    public abstract AbstractGameServer getGameServer(String name);

    public abstract boolean exists(String name);

    public abstract Collection<AbstractGameServer> getAllGameServers();

    public abstract Collection<AbstractGameServer> getAlLGameServers(Predicate<AbstractGameServer>... predicates);

}
