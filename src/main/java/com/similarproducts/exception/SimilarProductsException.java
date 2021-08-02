package com.similarproducts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RestControllerAdvice
public class SimilarProductsException extends Exception {
    
	private static final long serialVersionUID = 7340514399091342739L;

	private HttpStatus status;
	private String message;

	public SimilarProductsException() {
	}
    
	public SimilarProductsException(String message) {
		super(message);
	}

    public SimilarProductsException(HttpStatus status, String message) {
    	super(message);
    	this.status = status;
    }
    
}
