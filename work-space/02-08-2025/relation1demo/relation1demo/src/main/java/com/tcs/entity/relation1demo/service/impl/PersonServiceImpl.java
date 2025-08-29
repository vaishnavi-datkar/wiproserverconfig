package com.tcs.entity.relation1demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.relation1demo.entity.Person;
import com.tcs.entity.relation1demo.repo.PersonRepo;
import com.tcs.entity.relation1demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepo personRepo;
	
	@Override
	public void save(Person person) {
		personRepo.save(person);

	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepo.findAll();
	}

}