package com.sprint1.CabBooking.advice;

import java.util.NoSuchElementException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sprint1.CabBooking.exception.AuthenticationFailureException;
import com.sprint1.CabBooking.exception.EmptyInputException;
import com.sprint1.CabBooking.exception.TripBookingNotFoundException;
import com.sprint1.CabBooking.exception.UserNotFoundException;
import com.sprint1.CabBooking.exception.userNameNotExistingexception;


@ControllerAdvice	

public class MyControllerAdvice extends ResponseEntityExceptionHandler{
	
	//predefined Exception
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException)
	{
		return new  ResponseEntity<String>("No such value is present in DB, Please change your request",HttpStatus.BAD_REQUEST);
	}
	//predefined Exception
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException elementException)
	{
		return new  ResponseEntity<String>("No such value is present in DB, Please change your request",HttpStatus.BAD_REQUEST);
	}
	
	//predefined Exception
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return new  ResponseEntity<Object>("Please change the Http method type",HttpStatus.NOT_FOUND);
	}
	
	//User-defined exception 
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException elementException)
	{
		return new  ResponseEntity<String>("Input field is empty, Please look into it",HttpStatus.BAD_REQUEST);
	}
	
	//User-defined exception 
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException elementException)
	{
		return new  ResponseEntity<String>("User is not present in the database",HttpStatus.BAD_REQUEST);
	}
	
	//User-defined exception 
	@ExceptionHandler(TripBookingNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(TripBookingNotFoundException elementException)
	{
		return new  ResponseEntity<String>("Trip is not present in the database",HttpStatus.BAD_REQUEST);
	}
	//User-defined exception 
		@ExceptionHandler(AuthenticationFailureException.class)
		public ResponseEntity<String> handleAuthenticationFailureException(AuthenticationFailureException elementException)
		{
			return new  ResponseEntity<String>("Login in failed",HttpStatus.BAD_REQUEST);
		}
		//User-defined exception 
		@ExceptionHandler(userNameNotExistingexception.class)
		public ResponseEntity<String> handleuserNameNotExistingexception(userNameNotExistingexception elementException)
		{
			return new  ResponseEntity<String>("user not registered",HttpStatus.BAD_REQUEST);
		}

}
