package com.kk.thread;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
  
public class MainExecutor {  
    private TaskExecutor taskExecutor;  
    public MainExecutor (TaskExecutor taskExecutor) {      
        this.taskExecutor = taskExecutor;    
    }  
    public void printMessages() {      
        for(int i = 0; i < 25; i++) {        
            taskExecutor.execute(new MessagePrinterTask("Message" + i));      
        }    
    }  
      
      
    private class MessagePrinterTask implements Runnable {      
        private String message;      
        public MessagePrinterTask(String message) {        
            this.message = message;      
        }      
        public void run() {        
            System.out.println(message);      
        }  
    }

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MainExecutor te = (MainExecutor)appContext.getBean("mainExecutor");
        te.printMessages();
        System.out.println("11111111111111111111111");
    }
}  