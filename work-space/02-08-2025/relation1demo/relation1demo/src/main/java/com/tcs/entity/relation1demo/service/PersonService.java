package com.tcs.entity.relation1demo.service;

import java.util.List;
import com.tcs.entity.relation1demo.entity.Person;

public interface PersonService {
    void save(Person person);
    List<Person> findAll();
}
