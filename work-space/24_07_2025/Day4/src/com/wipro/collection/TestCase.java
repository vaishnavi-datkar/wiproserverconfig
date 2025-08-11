package com.wipro.collection;

public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		        Box<Integer> box1 = new Box<>();
		        box1.add(22);
		        System.out.println("Integer Value: " + box1.getData());
		        
		        Box<String> box2 = new Box<>();
		        box2.add("Vaishnavi");
		        System.out.println("String Value: " + box2.getData());

		        
		        Box<Double> box3 = new Box<>();
		        box3.add(200.6);
		        System.out.println("Double Value: " + box3.getData());
		    }
		}


	


