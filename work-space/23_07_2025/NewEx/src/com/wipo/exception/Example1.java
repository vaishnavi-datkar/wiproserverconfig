package com.wipo.exception;
import java.util.*;

public class Example1 {
	public static void main(String []s) {
			Scanner sc=new Scanner(System.in);
			String fName = sc.nextLine();

	        try {
     
	            String upperCaseName = fName.toUpperCase();
	            System.out.println("Uppercase Name: " + upperCaseName);
	        } catch (NullPointerException e) {
	            System.out.println("given string is null.");
	        }

	        System.out.println("Program continues after handling exception.");
	        sc.close();
	    }
	}
	


