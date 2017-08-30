package com.kk.jcs;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

import java.util.HashMap;

/**
 * Created by kk on 2017/8/30.
 */
public class MyJCSTest {
    public static void main(String[] args) {
        //1.创建缓存实例
        HashMap<String, CacheWrapper> cacheWrapperMap = new HashMap<String, CacheWrapper>();
        try {
            JCS cache = JCS.getInstance("cache01");
            cacheWrapperMap.put("cache01",new CacheWrapper(cache));
        } catch (CacheException e) {
            e.printStackTrace();
        }

        //2. 初始化缓存数据
        CacheWrapper cacheWrapper = cacheWrapperMap.get("cache01");
        cacheWrapper.put("key1","huangkai");
        cacheWrapper.put("key2","jiangnan");

        //3. 获取缓存数据
        System.out.println(cacheWrapper.get("key1"));
    }
}
