package com.wipro.ops;

public abstract class Animal {

	String name;
	String makeSound;
	  
	public Animal(String name, String makeSound) {
		super();
		this.name = name;
		this.makeSound = makeSound;
	}
	public abstract void makesound();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMakeSound() {
		return makeSound;
	}
	public void setMakeSound(String makeSound) {
		this.makeSound = makeSound;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", makeSound=" + makeSound + "]";
	}
	
}
