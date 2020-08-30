package com.workspace;

import java.util.*;

public class LogClient {
    Comparator<Process> compare = new Comparator<Process>() {
        @Override
        public int compare(Process p1, Process p2){
            if(p1.startTime < p2.startTime){
                return -1;
            }
            return  1;
        }
    };
    private Map<String, Process> processMap = new HashMap<>();

    private TreeSet<Process> processesQ = new TreeSet<Process>(compare);

    public void start(String processId, long startTime) {
        Process p = new Process(processId, startTime);
        processMap.put(processId, p);
        processesQ.add(p);
    }
    public void end(String processId, long endTime) {
        if(processMap.containsKey(processId)) {
            processMap.get(processId).endTime = endTime;
        }else{
            System.out.println("Process doesn't exist!\n");
        }
    }
    public String poll() {
        if (processesQ.size()>0){
            System.out.println();
            Process tempP = processesQ.iterator().next();
            if(tempP.endTime != -1){
                //remove from processMap
                processMap.remove(tempP.processId);
                // remove from processQ
               return  processesQ.pollFirst().processId;
            }
        }
        return "";
    }
}
