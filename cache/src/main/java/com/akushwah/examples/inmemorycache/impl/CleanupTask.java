package com.akushwah.examples.inmemorycache.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.akushwah.examples.inmemorycache.Cache;

public final class CleanupTask<K, V> implements Runnable {
    
    private Logger LOG = LoggerFactory.getLogger(CleanupTask.class);

    private final Cache<K, V> instance;
    
    public CleanupTask(Cache<K, V> instance) {
        this.instance = instance;
    }

    @Override
    public void run() {    
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
                instance.cleanUp();
            }
            
            catch(InterruptedException ie){
                LOG.error("Error: " + ie);
            }
        }

    }
}

