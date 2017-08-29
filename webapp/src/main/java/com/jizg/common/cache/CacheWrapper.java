/* 
 * @copyright(disclaimer) 
 * 
 * Licensed Materials - Property of IBM 
 * (C) Copyright IBM Corp. 2010  All Rights Reserved. 
 * 
 * The source code for this program is not published or otherwise 
 * divested of its trade secrets, irrespective of what has been 
 * deposited with the U.S. Copyright Office. 
 * 
 * @endCopyright 
 */  
package com.jizg.common.cache;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.apache.jcs.engine.CacheElement;
import org.apache.log4j.Logger;

import java.io.Serializable;
/** 
 *  
 *  
 * @version $Rev: 1046 $ $Date: 2012-01-12 17:41:24 +0800 $ 
 */  
public class CacheWrapper {  
    private final Logger logger = Logger.getLogger(CacheWrapper.class);  
      
    /** 
     * Cache实例 
     *  
     */  
    public JCS cache;
  
    public CacheWrapper(JCS cache) {  
        this.cache = cache;  
    }  
  
    public void put(String key, Serializable value) {  
        try {  
            cache.put(key, value);  
        } catch (CacheException e) {  
            logger.error("Method put(String key, Serializable value),Put Element to the Cache Error,Key is ["+ key + "] Val is [" + value + "]", e);  
        }  
    }  
  
    public void put(String key, Object value) {  
        try {  
            cache.put(key, value);  
        } catch (CacheException e) {  
            logger.error("Method put(String key, Serializable value),Put Element to the Cache Error,Key is [" + key + "] Val is [" + value + "]", e);  
        }  
    }  
  
    public Serializable get(String key) {  
        CacheElement cacheElement = (CacheElement) cache.getCacheElement(key);  
        if (null != cacheElement) {  
            Serializable serializable = cacheElement.val;  
            return serializable;  
        }  
        return null;  
    }  
  
    public Object getObject(String key) {  
        CacheElement cacheElement = (CacheElement) cache.getCacheElement(key);  
        if (null != cacheElement) {  
            Object object = cacheElement.val;  
            return object;  
        }  
        return null;  
    }  
  
    public boolean remove(String key) {  
        try {  
            cache.remove(key);  
            return true;  
        } catch (CacheException e) {  
            logger.error("Method remove(String key),Not remove CacheElement from the Cache by Key is["+ key + "], remove Error", e);  
            return false;  
        }  
    }  
  
}  