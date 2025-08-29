package com.wipro.datetime;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

	public class DateDemo {
	    public static void main(String[] args) {
	        LocalDate dt1 = LocalDate.of(2023, Month.NOVEMBER, 1);
	        System.out.println(dt1);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String formattedDate = dt1.format(formatter);

	        System.out.println("Formatted Date: " + formattedDate);
	    }
	}


