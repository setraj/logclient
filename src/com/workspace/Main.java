package com.workspace;
/*
* Problem Statement:
* We need to implement an interface: a LogClient. This client has three methods: start, end and poll.
  The start and end method are event listeners. They are notified of a process start and end.
  The poll method waits on the first task in queue to complete, and then prints it.
*
* */

public class Main {

    public static void main(String[] args) {

     /* test cases
     * P1 ( 3 4)
     * P2 (1 5)
     * P3 (4 6)
     *
     * P2 -> P1 -> P3
     * */

       LogClient lc = new LogClient();

       lc.start("P1", 3);
       System.out.println("Polls: "+lc.poll());

       lc.start("P2",1);
       System.out.println("Polls: "+lc.poll());

       lc.start("P3",4);
       System.out.println("Polls: "+lc.poll());

       lc.end("P1",4);
       System.out.println("Polls: "+lc.poll());

       lc.end("P2",5);
       System.out.println("Polls: "+lc.poll());

       lc.end("P3",6);
       System.out.println("Polls: "+lc.poll());
       System.out.println("Polls: "+lc.poll());
    }
}
