/* 
 * @copyright(disclaimer) 
 * 
 * Licensed Materials - Property of IBM 
 * (C) Copyright IBM Corp. 2013  All Rights Reserved. 
 * 
 * The source code for this program is not published or otherwise 
 * divested of its trade secrets, irrespective of what has been 
 * deposited with the U.S. Copyright Office. 
 * 
 * @endCopyright 
 */
package com.jizg.common.cache;
  
import org.apache.log4j.Logger;

import java.util.Timer;
  
  
/** 
 * Scheduler 定时任务 
 * 
 * @version $Rev$ $Date$ 
 */  
public class SchedulerUtil {  
    public static Logger logger = Logger.getLogger(SchedulerUtil.class);  
    private static Timer initSchedulerTestTimer = null;  
  
    public static void initScheduleTestCache() {  
        logger.info(" initScheduleTestCache ");  
        initSchedulerTestTimer = new Timer("INIT_SCHEDULER_TIMER_TASK_TEST_CACHE_JOB", false);  
          
        long nextTime = 60 * 1000;  //定义定时任务的时间间隔  
        TestCacheSafeLifeSecondTask myTimeTask = TestCacheSafeLifeSecondTask.getInstance(nextTime);  
          
        //立即执行定时任务，每隔nextTime间隔执行一次  
        initSchedulerTestTimer.scheduleAtFixedRate(myTimeTask, 0, nextTime);   
          
    }  
      
}  
