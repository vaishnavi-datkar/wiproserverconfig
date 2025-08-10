package com.wipro.secondboot.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public class MoviesRepo{
	List<String> getMoviesList(){
		return Arrays.asList("Titanic","Catch me if you can","Gravity");
	}

}
