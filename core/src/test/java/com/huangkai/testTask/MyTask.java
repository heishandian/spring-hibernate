package com.huangkai.testTask;

import org.geowebcache.GeoWebCacheException;
import org.geowebcache.seed.GWCTask;

/**
 * Created by kk on 2017/8/20.
 */
public class MyTask extends GWCTask {
    @Override
    protected void dispose() {
        System.out.println("dispose...");
    }

    @Override
    protected void doActionInternal() throws GeoWebCacheException, InterruptedException {
        System.out.println("doActionInternal....");
    }

    public GWCTask[] createTasks( int threadCount, boolean filterUpdate) throws GeoWebCacheException {

        if (threadCount < 1) {
            threadCount = 1;
        }

        GWCTask[] tasks = new MyTask[threadCount];

        return tasks;
    }
}
