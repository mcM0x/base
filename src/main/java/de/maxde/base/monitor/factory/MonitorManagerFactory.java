package de.maxde.base.monitor.factory;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.monitor.AbstractMonitorManager;
import de.maxde.base.monitor.impl.MonitorManagerImpl;
import org.redisson.api.RedissonClient;

public class MonitorManagerFactory {

    public static AbstractMonitorManager create(AbstractDatabase<RedissonClient> database) {
        return new MonitorManagerImpl(database);
    }

}
