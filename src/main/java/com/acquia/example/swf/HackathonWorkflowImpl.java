package com.acquia.example.swf;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jarmes on 5/25/17.
 */
public class HackathonWorkflowImpl implements HackathonWorkflow {
    private HackathonActivitesClient client = new HackathonActivitesClientImpl();

    public void work() {
        client.sleep(ThreadLocalRandom.current().nextInt(1, 51));
    }
}
