package com.wipro.oop;

public class Restaurant {
	
	private String order;
	private int orderNo;
	private float price;
	
	Restauran(){
		
	}

	

	public Restaurant(String order, int orderNo) {
		super();
		this.order = order;
		this.orderNo = orderNo;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Restaurant [order=" + order + ", orderNo=" + orderNo + ", price=" + price + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Restaurant r1 = new Restaurant("Pizza", 101);
		System.out.println(r1);
	}

}
