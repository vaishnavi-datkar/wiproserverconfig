package com.wipro.cityboot.controller;

import com.wipro.cityboot.model.City;
import com.wipro.cityboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public String showCities(Model model) {
        List<City> cities = cityService.getCities();
        model.addAttribute("cities", cities);
        return "cities";  // JSP page name
    }
}
