package com.acquia.example.swf;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

/**
 * Created by jarmes on 5/25/17.
 */
public class GlobalWorker {
    public static void main(String[] args) throws Exception {
        ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70 * 1000);

        AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(config);
        service.setEndpoint("https://swf.us-east-1.amazonaws.com");

        String domain = "HelloDomain";
        String taskListToPoll = "HelloWorldList";

        ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
        aw.addActivitiesImplementation(new GreeterActivitiesImpl());
        aw.addActivitiesImplementation(new HackathonActivitiesImpl());
        aw.start();

        WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
        wfw.addWorkflowImplementationType(GreeterWorkflowImpl.class);
        wfw.addWorkflowImplementationType(HackathonWorkflowImpl.class);
        wfw.start();
    }
}
