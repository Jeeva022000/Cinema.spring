package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

	@Query(value= "select * from movies where name like ?",nativeQuery=true)
	public Movie getMovieName(String name);

}
