package com.wipro.cityboot.service;

import com.wipro.cityboot.model.City;
import com.wipro.cityboot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getCities() {
        return cityRepository.getAllCities();
    }
}
