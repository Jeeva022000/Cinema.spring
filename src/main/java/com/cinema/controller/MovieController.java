package com.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinema.customException.ActorNameException;
import com.cinema.cinema.customException.IdNotFound;
import com.cinema.cinema.customException.NameException;
import com.cinema.cinema.customException.YearException;
import com.cinema.entity.Movie;
import com.cinema.service.MovieService;

import jakarta.persistence.GeneratedValue;

@RestController
public class MovieController {
	@Autowired
	MovieService ms;
	@PostMapping("/setMovie")
	public String setMovie(@RequestBody Movie movie) throws YearException {
		return ms.setMovie(movie);
	}
	@PostMapping("/setAllMovie")
	public String setAllMovie(@RequestBody List<Movie> movie) throws YearException {
		return ms.setAll(movie);
	}
	@GetMapping("/getId/{id}")
	public Movie getById(@PathVariable int id) throws IdNotFound {
		return ms.getById(id);
	}
	@GetMapping("getAll")
	public List<Movie> getAll() {
		return ms.getAll();
	}
	@GetMapping("/getMovie/{name}")
	public List<Movie> getMovieByName(@PathVariable String name) throws NameException { 
		return ms.getMovieName(name);
	}
	@GetMapping("/getReleasedYear/{year}")
	public List<Movie> getMovieYear(@PathVariable int year) throws YearException {
		return ms.getMovieYear(year);
	}
	@GetMapping("/getHeroName/{heroName}")
	public List<Movie> getActorName(@PathVariable String heroName) throws ActorNameException {
		return ms.getActorName(heroName);
	}
	

}
