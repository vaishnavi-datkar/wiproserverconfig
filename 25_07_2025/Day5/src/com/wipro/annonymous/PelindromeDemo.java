package com.wipro.annonymous;

import java.util.function.Predicate;

public class PelindromeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<String> checkpalindrome =str->{
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equalsIgnoreCase(reversed);
        };
        String str1="madam";
       System.out.println(checkpalindrome.test(str1));
        }
	}


