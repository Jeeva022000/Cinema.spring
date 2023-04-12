package com.cinema.cinema.GlobalHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cinema.cinema.customException.ActorNameException;
import com.cinema.cinema.customException.IdNotFound;
import com.cinema.cinema.customException.NameException;
import com.cinema.cinema.customException.YearException;
import com.cinema.entity.Movie;
import com.fasterxml.jackson.core.sym.Name;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(YearException.class)
	public String yearHandler() {
		return "you're giving invalid Year";
	}
	@ExceptionHandler(ActorNameException.class)
	public ResponseEntity<Object> actorName() {
		return new ResponseEntity<Object>("Invalid", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NameException.class)
	public ResponseEntity<Object> nameExcep() {
		return new ResponseEntity<Object>("Invalid", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<Object> IdnotFound() {
		return new ResponseEntity<Object>("Invalid",HttpStatus.BAD_REQUEST);
	}

}
