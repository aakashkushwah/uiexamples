package com.akushwah.examples.inmemorycache.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.akushwah.examples.inmemorycache.Cache;

public class ClientThread implements Runnable {

    private Logger LOG = LoggerFactory.getLogger(ClientThread.class);

    private Cache<String, String> cache;

    public ClientThread(Cache<String, String> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        try {

            for (int i = 0; i < 10; i++) {
                cache.put("key-" + i, "value-" + i);
            }
            
            TimeUnit.SECONDS.sleep(1);

            for (int i = 0; i < 5; i++) {
                print(i);
            }

            TimeUnit.SECONDS.sleep(5);

            for (int i = 5; i < 8; i++) {
                print(i);
            }

            TimeUnit.SECONDS.sleep(7);

            for (int i = 8; i < 10; i++) {
                print(i);
            }

        } catch (InterruptedException ie) {
            LOG.error("Error: " + ie);
        }

    }

    private void print(int i) {
        LOG.info(Thread.currentThread().getName() + ": key-" + i + " = "
                + cache.get("key-" + i));
    }

}
