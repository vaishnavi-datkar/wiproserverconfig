package com.tcs.entity.relation1demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tcs.entity.relation1demo.entity.Movie;
import com.tcs.entity.relation1demo.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public void save(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }
}
