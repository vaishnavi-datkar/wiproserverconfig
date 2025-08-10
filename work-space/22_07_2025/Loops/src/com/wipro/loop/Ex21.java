package com.wipro.loop;

public class Ex21 {

	    public static void main(String[] args) {
	        String str = "Java powerful language";
	      
	        String[] ch = str.split(" ");
	        
	    String shortest =ch[0];

	        for (int i = 1; i < ch.length; i++) {
	            if (ch[i].length() < shortest.length()) {
	                shortest = ch[i]; 
	            }
	        }

	        System.out.println("The shortest word is: " + shortest);
	    }
	}

