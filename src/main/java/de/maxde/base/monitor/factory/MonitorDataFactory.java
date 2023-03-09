package de.maxde.base.monitor.factory;

import de.maxde.base.monitor.AbstractMonitorData;
import de.maxde.base.monitor.impl.MonitorDataImpl;

public class MonitorDataFactory {

    public static AbstractMonitorData create(String key, long time, long timestamp, String comment) {
        return new MonitorDataImpl(key, time, timestamp, comment);
    }
}
