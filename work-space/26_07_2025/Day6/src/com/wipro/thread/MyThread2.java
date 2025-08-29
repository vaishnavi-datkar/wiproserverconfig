package com.wipro.thread;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'J'; ch++) {
            System.out.println("Alphabet: " + ch);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
