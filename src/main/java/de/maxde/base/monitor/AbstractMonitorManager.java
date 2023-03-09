package de.maxde.base.monitor;

import java.util.Collection;

public abstract class AbstractMonitorManager {

    public abstract void monitor(AbstractMonitorData data);

    public abstract Collection<AbstractMonitorData> getAllMonitorData();

    public abstract Collection<AbstractMonitorData> getMonitorData(String key);

    public abstract double getAverageTime(String key);

}
