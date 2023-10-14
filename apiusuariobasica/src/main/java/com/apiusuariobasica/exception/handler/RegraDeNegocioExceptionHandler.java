package com.apiusuariobasica.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apiusuariobasica.exception.RegraDeNegocioException;

public class RegraDeNegocioExceptionHandler {
	 
	@ExceptionHandler(RegraDeNegocioException.class)
	  public ResponseEntity<String> handleRegraDeNegocioException(RegraDeNegocioException ex) {
	    return ResponseEntity.badRequest().body(ex.getMessage());
	  }
	}

