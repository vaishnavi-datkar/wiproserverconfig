package com.wipro.newp;
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Main2().isEven(2));
		System.out.println(new Main2().isEven(2));
	}
	public boolean isEven(int i) {
		if(i%2==0) {
			return true;
		}else {
			return false;
		}
	}

}
