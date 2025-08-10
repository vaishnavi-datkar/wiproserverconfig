package com.tcs.entity.relation1demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.relation1demo.entity.Movie;
import com.tcs.entity.relation1demo.repo.MovieRepo;
import com.tcs.entity.relation1demo.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;

    @Override
    public void save(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }
}
