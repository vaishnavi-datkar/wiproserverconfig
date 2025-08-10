package com.tcs.entity.relation1demo.service;

import java.util.List;

import com.tcs.entity.relation1demo.entity.Movie;

public interface MovieService {

    void save(Movie movie);
    List<Movie> findAll();
}
