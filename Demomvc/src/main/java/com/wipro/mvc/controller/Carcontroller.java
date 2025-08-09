package com.wipro.mvc.controller;

import com.wipro.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/car")
public class Carcontroller {

    @Autowired
    private CarService carService;  

    @GetMapping("/list")
    public String showCarList(Model model) {
        List<String> cars = carService.getCarList();  
        model.addAttribute("cars", cars);
        return "carlist";
    }
}
