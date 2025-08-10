package com.wipro.annonymous;
import java.time.LocalDate;
import java.util.function.Supplier;
public class SupplierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supplier<LocalDate> dt=()->{return LocalDate.now().plusDays(1);};
		
		System.out.println(dt.get().getDayOfWeek());
	}

}
