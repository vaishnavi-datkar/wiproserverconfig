package com.wipro.secondboot.service;

import java.util.List;

import com.wipro.secondboot.repo.MoviesRepo;

public interface MovieService {
	MovieRepo moviRepo;
List<String> getMovieList1();
public default List<String> getMovieList(){
	return null;
}
}

