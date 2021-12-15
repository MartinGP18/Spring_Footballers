package com.qa.Spring_Footballers.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	//create
	T create(T t);
	
	//readAll
	List<T> getAll();
	
	//readById
	T getById(long id);
	
	//update
	T update(long id, T t);
	
	//delete
	boolean delete(long id);

}
