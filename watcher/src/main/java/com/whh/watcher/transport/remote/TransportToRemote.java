package com.whh.watcher.transport.remote;

import com.whh.watcher.domain.Event;
import com.whh.watcher.config.ConfigFactory;
import com.whh.watcher.spi.TransportService;

import java.util.Arrays;
import java.util.List;

/**
 * Dept：
 * User:wanghanghang
 * Date:2016/5/4
 * Version:1.0
 */
public class TransportToRemote implements TransportService {
    private RemoteSendHelper remoteSendHelper = new RemoteSendHelper();
    public static final String appName = ConfigFactory.getSystemConfig().getAppName();

    @Override
    public void sendEvent(Event event) {
        remoteSendHelper.sendEvent(appName, Arrays.asList(new Event[]{event}), 1000);
    }

    @Override
    public void sendEvent(List<Event> events) {
        remoteSendHelper.sendEvent(appName, events, 1000);
    }
}
