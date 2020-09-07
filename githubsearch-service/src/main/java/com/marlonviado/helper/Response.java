package com.marlonviado.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> extends ResponseEntity<T> {
	
	public Response(HttpStatus status) {
		super(status);
	}
	
	public Response(T body, HttpStatus status) {
		
		super(body,status);
		
	}
	
	public static <R> ResponseEntity<R> returned(R body) {
		return ResponseEntity.ok(body);
	}

}
