package com.acquia.example.swf;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300, defaultTaskStartToCloseTimeoutSeconds = 90)
@Activities(version = "1.0")
public interface HackathonActivites {
    public String sleep(Integer time) throws InterruptedException;
}
