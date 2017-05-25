package com.acquia.example.swf;

import java.util.concurrent.TimeUnit;

/**
 * Created by jarmes on 5/25/17.
 */
public class HackathonActivitiesImpl implements HackathonActivites {
    @Override
    public String sleep(Integer time) throws InterruptedException {
        System.out.println("About to sleep for " + time + " seconds.");
        TimeUnit.SECONDS.sleep(time);
        return "Slept for " + time + " seconds.";
    }
}
