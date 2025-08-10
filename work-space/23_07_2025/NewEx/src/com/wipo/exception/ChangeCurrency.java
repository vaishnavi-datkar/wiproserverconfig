package com.wipo.exception;

public class ChangeCurrency {

	 public static double changeCurrency(int number)throws NumberFormatException {
		        if (number == 0) {
		            throw new NumberFormatException("Invalid Number");
		        }
		        return number * 80;
		    }

		    public static void main(String[] args) {
		    	// TODO Auto-generated method stub
		        try {
		            int input = 0;
		            double result = changeCurrency(input);
		            System.out.println("Converted currency: ₹" + result);
		        } catch (NumberFormatException e) {
		            System.out.println("Exception caught: " + e.getMessage());
		        }

		        System.out.println("Program continues after handling exception.");
		    }
		}

	


