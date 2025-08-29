package com.wipro.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        List<FoodItem>foodList =new ArrayList<>();
		        foodList.add(new FoodItem("veg noodles", "Veg", "chinese", 150));
		        foodList.add(new FoodItem("fried rice", "Non Veg", "chinese", 200));
		        foodList.add(new FoodItem("Pasta", "Veg", "continental", 170));

		         List<FoodItem> chineseFood =foodList
		        		 .stream()
		                .filter(item -> item.getCuisine().equals("chinese"))
		                .collect(Collectors.toList());
		         System.out.println(chineseFood);
		    }
		

}
