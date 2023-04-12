package com.cinema.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.customException.ActorNameException;
import com.cinema.cinema.customException.IdNotFound;
import com.cinema.cinema.customException.NameException;
import com.cinema.cinema.customException.YearException;
import com.cinema.dao.MovieDao;
import com.cinema.entity.Movie;

@Service
public class MovieService {
	@Autowired
	MovieDao md;
	public String setMovie(Movie movie) throws YearException {

		if(movie.getReleasedYear()<=2023) {
		return md.setMovie(movie);
		}
		else {
			throw new YearException();
		}
		
	}
	public String setAll(List<Movie> movie) throws YearException {
		List<Movie> x = movie.stream().filter(y-> y.getReleasedYear()>=2024).collect(Collectors.toList());
		if(x.isEmpty()) {
			
			return md.setAll(movie);
			
		}
		
		else {
			 throw new YearException();
		}
	}
	public Movie getById(int id) throws IdNotFound {
		
		return md.getById(id);
	}
	public List<Movie> getAll() {
		
		return md.getAll();
	}
	public List<Movie> getMovieName(String name) throws NameException {
		List<Movie> x = getAll();
		 List<Movie> y = x.stream().filter(d -> d.getName().equals(name)).collect(Collectors.toList()); 
		 if(y.isEmpty()) {
			 throw new NameException();
		}
		else {
		 return y;
		}
		 
	}
	public List<Movie> getMovieYear(int year) throws YearException {
		List<Movie> x = md.getAll();
		List<Movie> y = x.stream().filter(d-> d.getReleasedYear()>=year).collect(Collectors.toList());
		if(y.isEmpty()) {
			throw new YearException("Invalid");
		}
		else {
			return y;
		}
	}
	public List<Movie> getActorName(String heroName) throws ActorNameException {
		List<Movie> x = md.getAll();
		List<Movie> y = x.stream().filter(h -> h.getHeroName().equals(heroName)).collect(Collectors.toList());
		if(y.isEmpty()) {
			throw new ActorNameException();
		}
		else {
			return y;
		}
	}

}
