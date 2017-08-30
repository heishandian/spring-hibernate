package com.kk.jcs;

import net.sf.ehcache.CacheException;
import org.apache.jcs.JCS;
import org.apache.log4j.Logger;

import java.util.HashMap;


public class CacheUtils {
  
    public static Logger logger = Logger.getLogger(CacheUtils.class);
    public static HashMap<String, CacheWrapper> cacheWrapperMap = new HashMap<String, CacheWrapper>();
    public static String cacheName = "testCache1";

    public static void createCache(String cacheName){
        if(!cacheWrapperMap.containsKey(cacheName)){
            JCS cache = null;
            try {
                try {
                    cache = JCS.getInstance(cacheName);
                } catch (org.apache.jcs.access.exception.CacheException e) {
                    e.printStackTrace();
                }
            } catch (CacheException e) {
                logger.error("获取缓存实例出错："+e.getMessage());
            }
            cacheWrapperMap.put(cacheName, new CacheWrapper(cache));
            logger.info("put "+ cacheName+" in cacheWrapperMap("+cacheWrapperMap+")");
        }else{
            logger.info(cacheName+" cacheObj has existed.");
        }
    }

    public static CacheWrapper getCacheWrapperByName(String name){
        if(cacheWrapperMap.containsKey(name)){
            logger.info("取到缓存对象，"+name);
            return cacheWrapperMap.get(name);
        }else{
            logger.error("没有缓存对象，"+name);
            return null;
        }
    }

    public static void initCache(String cacheName){
        CacheWrapper cacheWrapper = cacheWrapperMap.get(cacheName);
        String key = "test";
        String value ="jizg";
        for (int i = 0; i < 1000; i++) {
              cacheWrapper.put(key+(i+1), value+(i+1));
//            logger.info("put key:"+key+i+", value:"+value+i);
        }
        logger.info("init cacheWarpper "+cacheName+" end !!!");
    }

    /**
     * 缓存测试入口
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(cacheName);

        //创建缓存实例
        createCache(cacheName);

        //初始化缓存数据
        initCache(cacheName);

        CacheWrapper cache = CacheUtils.getCacheWrapperByName(CacheUtils.cacheName);
        System.out.println("test100:"+cache.get("test100"));
        System.out.println("test300:"+cache.get("test998"));
        System.out.println("test1000:"+cache.get("test999"));

        //启动定时任务-定时随机获取缓存数据  
        schedulerTestCacheSafeLifeSecond();
    }
      
    /** 
     * 初始化定时任务 
     */
    static void schedulerTestCacheSafeLifeSecond(){
        SchedulerUtil.initScheduleTestCache();
    }  
      
}  

