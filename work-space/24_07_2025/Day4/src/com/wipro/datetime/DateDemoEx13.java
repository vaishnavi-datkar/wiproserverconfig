package com.wipro.datetime;
import java.time.LocalDate;

	public class DateDemoEx13 {
	   
	    public static boolean checkLeapYear(LocalDate date){
	        int year = date.getYear();
	        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
	    }

	    public static void main(String[] args) {
	        
	        LocalDate date = LocalDate.of(2024, 2, 20);

	        if (checkLeapYear(date)) {
	            System.out.println(date.getYear() + " is a leap year.");
	        } else {
	            System.out.println(date.getYear() + " is not a leap year.");
	        }
	    }
	}

