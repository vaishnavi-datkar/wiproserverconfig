package com.wipro.thread;

public class Counter {
	int count=0;
	synchronized void increment(){
		count++;
		
	}
	int getCount() {
		return count;	
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Counter [count=" + count + "]";
	}

}
