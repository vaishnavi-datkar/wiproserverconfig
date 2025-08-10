package com.wipro.cityboot.repository;

import com.wipro.cityboot.model.City;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {
    @Override
    public List<City> getAllCities() {
        return Arrays.asList(
            new City("Mumbai"),
            new City("Delhi"),
            new City("Bangalore"),
            new City("Hyderabad"),
            new City("Chennai")
        );
    }
}
