package com.wipro.annonymous;

public class TestCaseEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			AnnoInterface savingAc=new AnnoInterface()
					{

						@Override
						public void deposit(double amount) {
							// TODO Auto-generated method stub
							System.out.println("Inside Saving");
						}	};
						
						savingAc.deposit(5000.0);
						
						AnnoInterface currentAc=new AnnoInterface()
								{

									@Override
									public void deposit(double amount) {
										// TODO Auto-generated method stub
										System.out.println("Inside CurrentAc");
									}
									
								};
								currentAc.deposit(200.0);
						}

}
