package com.wipro.loop;

public class Target {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {2, 7, 1, 8};
	    int target=9;
	    int[] output= {0,0};
	    
		
		for(int i=0;i<arr.length;i++)
		{
			if(((i+1)<arr.length)&&(arr[i]+arr[i+1]==target))
			{
				
				
				output[0]=i;
				output[1]=i+1;
			}
			
		}
	
		System.out.println(output[0] + "," + output[1]);
 
			
}
}


