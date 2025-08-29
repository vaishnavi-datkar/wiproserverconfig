package com.tcs.entity.relation1demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.entity.relation1demo.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}