package com.tcs.entity.relation1demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.relation1demo.entity.Person;
import com.tcs.entity.relation1demo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping
	void save(@RequestBody Person person)
	{
		personService.save(person);
	}
	
	@GetMapping
	List<Person> findAll()
	{
		return personService.findAll();
	}


}