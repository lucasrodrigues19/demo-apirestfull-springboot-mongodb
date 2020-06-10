package com.lucasrodrigues.api_restful_mongo.services;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
