package com.kk.jcs;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.TimerTask;

public class TestCacheSafeLifeSecondTask extends TimerTask {
    private Logger logger = Logger.getLogger(TestCacheSafeLifeSecondTask.class);
    private static int runNumber = 1;  
    private static TestCacheSafeLifeSecondTask initcachetask = null;
  
    public static TestCacheSafeLifeSecondTask getInstance(long nextTimelong) {
        if (initcachetask == null) {  
            initcachetask = new TestCacheSafeLifeSecondTask();
        }  
        return initcachetask;  
    }  
  
    @Override  
    public void run() {  
       CacheWrapper cache = CacheUtils.getCacheWrapperByName(CacheUtils.cacheName);
       Random random = new Random();
       String cacheKey = "test"+random.nextInt(1000);  
         
       logger.info(runNumber+"  随机取得cache key:"+cacheKey+" ,cache value："+cache.get(cacheKey));  
       if(runNumber==4){  
           //重新初始化缓存对象  
           CacheUtils.initCache(CacheUtils.cacheName);  
       }  
       runNumber+=1;  
    }  
}  
