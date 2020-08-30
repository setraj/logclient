package com.workspace;

public class Process {
    String processId;
    long startTime;
    long endTime;
    Process(String processId, long startTime){
        this.processId = processId;
        this.startTime = startTime;
        this.endTime = -1;
    }
}
