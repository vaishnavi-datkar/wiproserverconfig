package com.wipro.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamDemo6 {
	public static void main(String[] args) {
		List<FoodItem> foodList = new ArrayList<>();
		foodList.add(new FoodItem("veg noodles", "Veg", "chinese", 150));
		foodList.add(new FoodItem("fried rice", "Non Veg", "chinese", 200));
		foodList.add(new FoodItem("Pasta", "Veg", "continental", 170));

		Optional<FoodItem> mostExpensiveChinese = foodList
				.stream()
			.filter(f -> f.cuisine.equalsIgnoreCase("chinese"))
			.max(Comparator.comparing(f -> f.price));

		System.out.println(
			mostExpensiveChinese.isPresent()
				? "Most expensive Chinese dish: " + mostExpensiveChinese.get()
				: "No Chinese food found."
		);
	}
}
