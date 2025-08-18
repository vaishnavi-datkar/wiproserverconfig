package com.wipro.loop;

public class Exp13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,20,5,3,4};
		int k=2;
		int count=0;
		for(int i=0;i<arr.length;i++){
		
			if(arr[i]!=arr[i+1]){

				count++;
	
			}
				if(count==k){
				System.out.println(" second largest element is : " + arr[i+1]);
				break;
	}

}
	}
}
