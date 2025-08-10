package com.tcs.entity.relation1demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entity.relation1demo.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
