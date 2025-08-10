package com.wipro.loop;

public class Vowels {
	public static void main(String[] args) {
	        String str = "Hello World";
	        int vCount = 0, consCount = 0;

	        str = str.toLowerCase();

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);

	            if (ch >= 'a' && ch <= 'z') {
	                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                    vCount++;
	                } else {
	                    consCount++;
	                }
	            }
	        }

	        System.out.println("for vowels " + vCount);
	        System.out.println("constant is " + consCount);
	    }
	}

