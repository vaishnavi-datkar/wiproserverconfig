package com.wipro.carregistrationdetailsms.service;

import com.wipro.carregistrationdetailsms.entity.Car;
import com.wipro.carregistrationdetailsms.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car updateCar(Long id, Car updatedCar) {
        return carRepository.findById(id).map(car -> {
            car.setMake(updatedCar.getMake());
            car.setRegistrationDetail(updatedCar.getRegistrationDetail());
            return carRepository.save(car);
        }).orElse(null);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
