package com.wipro.loop;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="madam";
		String str1="";
		/*  for(int i =str.length()-1;i>= 0;i--) {
	            str1 = str1+str.charAt(i); 
	        } */

	       /* if(str.equals(str1)) {
	            System.out.println(str + "palindrome");
	        } else {
	            System.out.println(str + " not a palindrome.");
	        } */
	        StringBuilder sb=new StringBuilder("madam");
	       sb.reverse();
	       if(.equals(str)) {
	        	System.out.println(str + "palindrome");
	        } else {
	            System.out.println(str + " not a palindrome.");
	        }
	        }
	    }


