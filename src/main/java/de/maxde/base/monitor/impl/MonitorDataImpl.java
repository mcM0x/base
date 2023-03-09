package de.maxde.base.monitor.impl;

import de.maxde.base.monitor.AbstractMonitorData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MonitorDataImpl extends AbstractMonitorData {

    private String key;
    private long timeInMs;
    private long timestamp;
    private String comment;

}
