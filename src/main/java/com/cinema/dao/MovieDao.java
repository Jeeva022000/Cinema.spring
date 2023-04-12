package com.cinema.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.cinema.customException.IdNotFound;
import com.cinema.entity.Movie;
import com.cinema.repository.MovieRepository;

@Repository
public class MovieDao {
	@Autowired
	MovieRepository mr;

	public String setMovie(Movie movie) {
		mr.save(movie);
		return "Saved";
	}

	public String setAll(List<Movie> movie) {
		mr.saveAll(movie);
		return "Saved";
	}

	public Movie getById(int id) throws IdNotFound {
		return mr.findById(id).orElseThrow(()-> new IdNotFound());
	}

	public List<Movie> getAll() {
		return mr.findAll();
	}

	public Movie getMovieName(String name) {
		return mr.getMovieName(name);
	}

}
