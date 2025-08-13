package com.wipro.ops;

public class HDFC implements BankOps{

	private double balance;
    private String accountNumber;

	public HDFC(double d, String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deposit(double amount, String accNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double withdraw(double amount, String accNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "HDFC [balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}
	

}
