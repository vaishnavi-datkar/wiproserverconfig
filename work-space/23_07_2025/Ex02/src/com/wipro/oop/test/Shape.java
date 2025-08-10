package com.wipro.oop;

public class Shape {
	private float height;
	private int noOfSide;
	private float area;
	
	public Shape() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shape(float height, int noOfSide, float area) {
		super();
		this.height = height;
		this.noOfSide = noOfSide;
		this.area = area;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getNoOfSide() {
		return noOfSide;
	}
	public void setNoOfSide(int noOfSide) {
		this.noOfSide = noOfSide;
	}
	public float getArea() {
		return area;
	}
	
	
	public void setArea(float area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Shape [height=" + height + ", noOfSide=" + noOfSide + ", area=" + area + "]";
	}
	

}
