package com.wipro.bean.springversion;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;

	@Component
	public class Mobile {

	    private Display display;

	    @Autowired  // Constructor-based DI
	    public Mobile(Display display) {
	        this.display = display;
	    }

	    public void showSpecs() {
	        System.out.println("Mobile configuration:");
	        display.showSize();
	    }
	

}
