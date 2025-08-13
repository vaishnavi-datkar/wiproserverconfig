package com.wipro.basic;

public class conditional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		boolean flag=false;
		int i=1;
		float abs=Math.abs(i);
		if((num==0)) {
			System.out.println("zero ");
		}else if(num>0 ) {
			System.out.println("positive");
		}else if(num<0) {
			System.out.println("negative");
		}else if(abs <1 ) {
			System.out.println("small");
			
		}
			//else if((num==5) || (num==6) || (num==9)) {
			//	System.out.println("");
		float n=789.9f;
		float n2=789.5f;
		float r=Math.round(n*1000);
		float r2=Math.round(n2*1000);
		
		if(n==n2) {
			System.out.println("same");
		}else 
			System.out.println("not same");
		//	}	
	//	int x=5;
	//	if(x>5) {
			System.out.println("");
			
		}
	//	System.out.println(x>5?"x>5":"x<5");
		
   int num5=3;
   String str=num5%2==0 ?"even":"odd";
   		System.out.println(str);
	}

}
