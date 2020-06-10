package com.lucasrodrigues.api_restful_mongo.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucasrodrigues.api_restful_mongo.services.ObjectNotFoundException;

@ControllerAdvice //essa classe é responsavel por tratar possiveis erros nas requições
public class ResourceExceptionHandle {
	
	@ExceptionHandler(ObjectNotFoundException.class) //interceptar a requisição que gerou a exessao
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
