package de.maxde.base.monitor.impl;

import de.maxde.base.database.AbstractDatabase;
import de.maxde.base.monitor.AbstractMonitorData;
import de.maxde.base.monitor.AbstractMonitorManager;
import lombok.AllArgsConstructor;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

import java.util.*;

@AllArgsConstructor
public class MonitorManagerImpl extends AbstractMonitorManager {

    private AbstractDatabase<RedissonClient> database;

    @Override
    public void monitor(AbstractMonitorData data) {
        String redisKey = "monitor:" + data.getKey();
        RList<AbstractMonitorData> map = database.getConnection().getList(redisKey);
        map.add(data);
    }

    @Override
    public Collection<AbstractMonitorData> getAllMonitorData() {

        Iterable<String> keysByPattern = database.getConnection().getKeys().getKeysByPattern("monitor:*");

        Set<AbstractMonitorData> result = new HashSet<>();

        for (String key : keysByPattern) {
            Collection<AbstractMonitorData> monitorData = getMonitorData(key);
            result.addAll(monitorData);
        }

        return result;
    }

    @Override
    public Collection<AbstractMonitorData> getMonitorData(String key) {
        //do not return rlist because we don't want to manipulate the data in the database

        RList<AbstractMonitorData> list = database.getConnection().getList("monitor:" + key);
        Set<AbstractMonitorData> result = new HashSet<>(list);
        return result;
    }

    @Override
    public double getAverageTime(String key) {

        Collection<AbstractMonitorData> monitorData = getMonitorData(key);

        long sum = 0;
        int count = 0;

        for (AbstractMonitorData monitorDatum : monitorData) {
            sum = monitorDatum.getTimeInMs();
            count++;
        }

        return ((float) sum / (float) count);
    }
}
