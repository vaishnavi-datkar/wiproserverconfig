package com.wipro.collection;
import java.util.HashSet;
import java.util.Set;
public class SetOperations {
	public static void main(String[] args) {
	       
	        Set<Integer> set1 = new HashSet<>();
	        set1.add(10);
	        set1.add(20);
	        set1.add(30);
	        set1.add(40);
	        
	        	Set<Integer> set2 = new HashSet<>();
	        set2.add(15);
	        	set2.add(5);
	        	set2.add(60);
	        	set2.add(17);

	       
	        Set<Integer>difference = new HashSet<>(set1); 
	        difference.removeAll(set2); 
	        System.out.println("Set 1: " + set1);
	        System.out.println("Set 2: " + set2);
	        System.out.println("Difference (Set1 - Set2): " + difference);
	    }
	}


