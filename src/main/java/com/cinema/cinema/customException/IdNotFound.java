package com.cinema.cinema.customException;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class IdNotFound extends Exception {
	public IdNotFound() {
		super();
	}

}
