package com.wipro.loop;

public class Loops1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
	   	int sum=0;
	   	
	   	System.out.println(sum);
	   	int[] num= {100,67,98,678,45,123};
/*	   	int max=num[0];
	   	for(int i=0;i<num.length;i++) {
	   		if(num[i]>max) {
	   			max=num[i];
	   		}
	   		System.out.println(max);
	   	}
*/	   	
	   	int k=2;
		int count=0;
		for(int i=0;i<num.length;i++){
		
			if(num[i]!=num[i+1]){

				count++;

			
			
			}
				if(count==k){
				System.out.println(" second largest element is : " + num[i+1]);
				break;
				}
	   	String []names= {"abc","aa","vvv"};
	   	System.out.println(names[2]);
	   	//float[][] regionalSalesData= {{}}
	   	//int num[][]={{1000,1010,1020,1030},{2000,2010,2020,2030},{3000,3010,3020,3030},{4000,4010,4020,4030}};
		//for(int i=0;i<num.length;i++)
		//{
			//for(int j=0;j<num[i].length;j++)
			//{
				//System.out.print(num[i][j]+"  ");
			//}
			//System.out.println();
			
		}
	}
	


