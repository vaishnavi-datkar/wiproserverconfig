package com.wipro.thread;

public class ThreadDemo5 extends Thread {
	
	    Counter counter;

	    public ThreadDemo5(Counter counter) {
	        this.counter = counter;
	    }

	    @Override
	    public void run() {
	        for (int i = 0; i < 10; i++) {  
	            counter.increment();
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}



