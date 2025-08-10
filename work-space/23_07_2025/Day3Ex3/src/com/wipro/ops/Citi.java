package com.wipro.ops;

public class Citi implements BankOps {

	private double balance;
    private String accountNumber;

	public Citi(double balance, String accountNumber) {
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
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
		return "Citi [balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}
	
			
}
