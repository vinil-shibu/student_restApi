package com.jsp.student_restApi.exception;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.student_restApi.helper.ResponseStructure;

@RestControllerAdvice
public class MyExceptionHandler {
	
	@Autowired
	ResponseStructure<String> structure;
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> handler(NoSuchElementException exception){
		structure.setMessage("Data Not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
}
