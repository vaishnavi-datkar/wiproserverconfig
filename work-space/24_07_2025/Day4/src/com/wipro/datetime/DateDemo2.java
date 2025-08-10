package com.wipro.datetime;

import java.time.LocalDate;
import java.time.Period;

public class DateDemo2{
    
    public static int getAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(2002, 2, 20);
        int age = getAge(birthDate);
        System.out.println("Age is: " + age + " years");
    }
}
