package com.wipro.collection;
import java.util.ArrayList;

public class DemoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			        ArrayList<Integer> list = new ArrayList<>();
			        list.add(10);
		        list.add(20);
		         list.add(30);
		        list.add(40);
		        list.add(50);

		        System.out.println(list);

		        
		        list.remove(2);

		        System.out.println("After removing index 2: " + list);

		       
		        list.add(60);

		        System.out.println("After adding new element at end: " + list);
		    

	}

}
