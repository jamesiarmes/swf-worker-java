package com.acquia.example.swf;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

import java.util.UUID;

public class HackathonMain {

   public static void main(String[] args) throws Exception {
     ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);

     AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(config);
     service.setEndpoint("https://swf.us-east-1.amazonaws.com");

     String domain = "HelloDomain";

     HackathonWorkflowClientExternalFactory factory = new HackathonWorkflowClientExternalFactoryImpl(service, domain);
     HackathonWorkflowClientExternal worker = factory.getClient(UUID.randomUUID().toString());
     worker.work();
   }
}
