package com.wipro.ser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Main().isEven(2));
		System.out.println(new Main().isEven(3));
	}
	public boolean isEven(int i) {
		if(i%2==0) {
			return true;
		}else {
			return false;
		}
	}

}
