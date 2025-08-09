package com.wipro.service;
import com.wipro.mvc.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;

    public List<String> getCarList() {
        return carRepository.getAllCars();
    }

}
