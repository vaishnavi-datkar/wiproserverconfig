package com.wipro.mvc.repository;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;
@Repository
public class CarRepository {
	public List<String> getAllCars() {
        return Arrays.asList("Audi", "Mercedes", "BMW");
    }
}


