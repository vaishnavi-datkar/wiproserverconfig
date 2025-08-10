package com.wipro.thread;

public class ThreadTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Counter counter = new Counter();

		        ThreadDemo5 t1 = new ThreadDemo5(counter);
		        ThreadDemo5 t2 = new ThreadDemo5(counter);

		        t1.start();
		        t2.start();

		        try {
		            t1.join();
		            t2.join();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		        System.out.println(counter.getCount());
		    }
	

	}


